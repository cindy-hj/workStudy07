package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="post_img")
public class PostImg {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postImgIdx;
	
	@ManyToOne
	@JoinColumn(name="post_idx")
	private Post posts;
	
	@Column(length = 200)
	private String img;

}
