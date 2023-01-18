package com.socioFix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socioFix.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
