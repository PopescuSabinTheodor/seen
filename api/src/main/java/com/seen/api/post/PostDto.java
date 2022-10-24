package com.seen.api.post;


public class PostDto {
    private String content;

    private String description;

    private String datePost;

    private int upVotes;

    private int downVotes;

    private int shares;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDatePost() {
        return datePost;
    }

    public void setDatePost(String datePost) {
        this.datePost = datePost;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(int upVotes) {
        this.upVotes = upVotes;
    }

    public int getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(int downVotes) {
        this.downVotes = downVotes;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "content='" + content + '\'' +
                ", description='" + description + '\'' +
                ", datePost=" + datePost +
                ", upVotes=" + upVotes +
                ", downVotes=" + downVotes +
                ", shares=" + shares +
                '}';
    }
}
