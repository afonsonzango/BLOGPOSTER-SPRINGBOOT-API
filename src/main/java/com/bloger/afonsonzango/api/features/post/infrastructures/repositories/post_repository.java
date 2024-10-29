package com.bloger.afonsonzango.api.features.post.infrastructures.repositories;

import com.bloger.afonsonzango.api.features.post.domain.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface post_repository extends JpaRepository <Post, Long> { }
