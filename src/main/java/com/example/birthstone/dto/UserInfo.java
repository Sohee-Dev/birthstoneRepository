package com.example.birthstone.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserInfo {

    private LocalDate userBirthday;
    private String name;

}
