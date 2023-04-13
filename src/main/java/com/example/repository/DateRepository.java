package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Date;

public interface DateRepository extends JpaRepository<Date, Integer> {

}
