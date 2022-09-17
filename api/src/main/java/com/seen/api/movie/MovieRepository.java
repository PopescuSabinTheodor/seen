package com.seen.api.movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
  Page<Movie> findAllByTitle(String title, Pageable pageable);
  Optional<Movie> findByTitle(String title);
}
