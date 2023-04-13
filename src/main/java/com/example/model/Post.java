package com.example.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="post")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postIdx;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="user_idx")
	private User userIdx;
	
	@Column(length = 200)
	private String productimg;

	@Column(length = 45)
	private String productname;
	
	private int quantity;
	
	@Column(columnDefinition = "TINYINT")
	private int isfood;
	
	private int price;
	
	@Column(length = 2000)
	private String description;
	
	@Column(length = 45)
	private String expDate;
	
	private LocalDateTime uploaddate;
	
	@Column(columnDefinition = "TINYINT")
	private int isSold;
	
	private int coverprice;
	
	@Column(length = 45)
	private String unit;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "postIdx")
	private List<Likes> likes;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "posts",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<PostImg> postImgs;
	
	
}
