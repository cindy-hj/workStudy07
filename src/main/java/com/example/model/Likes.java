package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="likes")
public class Likes {

	@Id
	private int id;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="user_idx")
	private User userIdx;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="post_idx")
	private Post postIdx;
}
