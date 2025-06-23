package com.example.birthstone.repository;

import com.example.birthstone.entity.Stone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoneRepository extends JpaRepository<Stone, Integer> {
    Stone findByMonth(int month);

}
