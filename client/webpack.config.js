const webpack = require('webpack');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const BundleAnalyzerPlugin = require('webpack-bundle-analyzer').BundleAnalyzerPlugin;

const path = require('path');

module.exports = {
    mode: "development",
    context: __dirname,
    entry: './src/index.js',
    output: {
        path: path.resolve( __dirname, 'dist' ),
        filename: 'main.js',
        publicPath: '/',
    },
    resolve: {
        alias: {
            'react-dom': '@hot-loader/react-dom',
        },
    },
    plugins: [
        new webpack.HotModuleReplacementPlugin(),
        new HtmlWebpackPlugin({
            template: path.resolve( __dirname, 'public/index.html' ),
            filename: 'index.html'
        }),
        new BundleAnalyzerPlugin()
    ],
    devServer: {
        open: true,
        hot: true,
        port: 3000,
        static: {
            directory: path.join(__dirname, 'public'),
        },
        proxy: {
            '/api/*': {
            target: 'http://localhost:8080',
            },
        },
        historyApiFallback: true,
    },
    // devtool: 'inline-source-map',
    module: {
        rules: [
            {
                test: /\.(js|mjs|jsx|ts|tsx)$/,
                exclude: /node_modules/,
                use: ['babel-loader']
            },
            {
                test: /\.css$/,
                use: [
                {
                    loader: 'style-loader'
                },
                {
                    loader: 'css-loader',
                    options: {
                    modules: true,
                    localsConvention: 'camelCase',
                    sourceMap: true
                    }
                }
                ]
            },
        ]
    },

};