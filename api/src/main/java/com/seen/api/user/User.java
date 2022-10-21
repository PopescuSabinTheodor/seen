package com.seen.api.user;

import javax.persistence.*;

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

}
