package com.bloger.afonsonzango.api.features.comment.infrastructures.repositories;

import com.bloger.afonsonzango.api.features.comment.domain.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface comment_repository extends JpaRepository <Comment, Long> { }
