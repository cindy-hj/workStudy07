package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Icon;

public interface IconRepository extends JpaRepository<Icon, Integer> {

}
