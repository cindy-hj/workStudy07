package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Likes;

public interface LikesRepository extends JpaRepository<Likes, Integer> {

}
