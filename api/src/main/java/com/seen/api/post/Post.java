package com.seen.api.post;

import com.seen.api.comment.Comment;
import com.seen.api.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String content;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_post")
    private Date datePost;

    private int upVotes;

    private int downVotes;

    private int shares;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post")
    private Comment comment;
}
