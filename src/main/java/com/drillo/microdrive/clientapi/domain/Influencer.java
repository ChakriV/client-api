package com.drillo.microdrive.clientapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "influencer")
@Entity
public class Influencer {
    @Id
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "location")
    String location;

    @JsonIgnore
    @Column(name = "user_access_token")
    String userAccessToken;

    @JsonIgnore
    @Column(name = "token_expiry")
    Timestamp tokenExpiry;

    @Column(name = "follower_count")
    Long follower_count;

    @Column(name = "ageRange")
    String ageRange;

    @Column(name = "engagementRate")
    Float engagementRate;

    @ManyToMany(targetEntity = Client.class, fetch = FetchType.LAZY)
    List<Client> clients;

    @ManyToMany(targetEntity = Program.class, fetch = FetchType.LAZY)
    List<Program> programs;

}
