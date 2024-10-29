package com.bloger.afonsonzango.api.features.reaction.infrastructures.repositories;

import com.bloger.afonsonzango.api.features.reaction.domain.entities.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface reactions_repository extends JpaRepository <Reaction, Long> { }