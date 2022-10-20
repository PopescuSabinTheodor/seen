package com.seen.api.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_post")
    private Date datePost;

    private int upVotes;

    private int downVotes;

    @ManyToOne
    private Comment comment;

    @OneToMany(mappedBy = "comment")
    private List<Comment> replies;
}
