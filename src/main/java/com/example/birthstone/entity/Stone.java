package com.example.birthstone.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Setter
@Table(name = "Stone_info")
public class Stone {

    @Id
    @Column(name = "month", nullable = false)
    private Integer month;  // 탄생석월 (PK)

    @Column(name = "name", length = 40)
    private String name;  // 탄생석명

    @Column(name = "explan", length = 100)
    private String explan;  // 탄생석 설명
}
