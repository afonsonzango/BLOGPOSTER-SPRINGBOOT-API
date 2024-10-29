package com.bloger.afonsonzango.api.features.reaction.domain.entities;

import com.bloger.afonsonzango.api.features.comment.domain.entities.Comment;
import com.bloger.afonsonzango.api.features.post.domain.entities.Post;
import com.bloger.afonsonzango.api.features.reaction.domain.enums.types;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reaction")
public class Reaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    private types type;

    private int reactor;

    @ManyToOne()
    @JoinColumn(name = "post_id", nullable = true)
    private Post post;

    @ManyToOne()
    @JoinColumn(name = "comment_id", nullable = true)
    private Comment comment;

    @PrePersist
    protected void generateUUID () {
        this.uuid = UUID.randomUUID();
    }

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
