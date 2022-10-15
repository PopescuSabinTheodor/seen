import React from 'react';
import { shallow } from "enzyme";
import App from "../App";

describe('Test App Entry point', function () {
    it('should have a button containing Hello World', function () {
        const wrapper = shallow(<App/>);
        expect(wrapper.find("ForwardRef(Button)").text()).toEqual("Hello World");
    });
});