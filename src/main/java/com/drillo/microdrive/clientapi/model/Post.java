package com.drillo.microdrive.clientapi.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Post {
    UUID postId;
    String platform;
    boolean isActive;
    Integer likes;
    Integer comments;

}
