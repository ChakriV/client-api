package com.drillo.microdrive.clientapi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "program")
@Entity
public class Program {
    @Id
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "start_date")
    Timestamp startDate;

    @Column(name = "end_date")
    Timestamp endDate;

    @Column(name = "total_impressions")
    Long totalImpressions;

    @Column(name = "engagement_rate")
    Long engagementRate;

    @ManyToMany(targetEntity = Client.class, fetch = FetchType.LAZY)
    List<Client> clients;

}
