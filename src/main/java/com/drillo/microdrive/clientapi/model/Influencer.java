package com.drillo.microdrive.clientapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class Influencer {
    String id;
    String name;
    String location;

    @JsonIgnore
    String userAccessToken;

    @JsonIgnore
    Timestamp tokenExpiry;

    String ageRange;
    Float engagementRate;

    public Influencer(String influencerId, String influencerName, String location, String ageRange, Float engagementRate) {
        this.id = influencerId;
        this.name = influencerName;
        this.location = location;
        this.ageRange = ageRange;
        this.engagementRate = engagementRate;
    }
}
