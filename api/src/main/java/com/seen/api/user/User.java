package com.seen.api.user;

import javax.persistence.*;

import com.seen.api.comment.Comment;
import com.seen.api.movie.Movie;
import com.seen.api.post.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  private String firstName;
  
  private String lastName;
  
  private String email;
  
  private String password;

  private List<String> genders;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "date_of_birth")
  private Date dateOfBirth;

  @Lob
  @Basic(fetch = FetchType.LAZY)
  private byte[] profilePicture;

  @OneToMany(fetch = FetchType.LAZY)
  private List<User> friends;

  @OneToMany(fetch = FetchType.LAZY)
  private List<User> followers;

  @OneToMany(fetch = FetchType.LAZY)
  private List<User> following;

  @OneToMany(fetch =  FetchType.LAZY)
  @JoinColumn(name = "post_id")
  private Post post;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "comment_id")
  private Comment comment;

  private int reviews;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "movie_id")
  private List<Movie> likedMovies;

}
