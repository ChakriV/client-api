package com.drillo.microdrive.clientapi.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Table(name = "post")
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @Column(name = "platform")
    String platform;

    @Column(name = "is_active")
    boolean isActive;

    @Column(name = "likes")
    Integer likes;

    @Column(name = "comment_count")
    Integer comment_count;
}
