package com.drillo.microdrive.clientapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class Program {
    String id;
    String name;
    boolean isActive;
    Timestamp startDate;
    Timestamp endDate;
    Long totalImpressions;
    Long  engagementRate;
}
