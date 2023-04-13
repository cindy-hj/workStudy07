package com.example.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name="user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userIdx;
	
	@Column(length = 45)
	private String email;
	
	@Column(length = 100)
	private String password;
	
	@Column(length = 45)
	private String salt;
	
	@Column(length = 45)
	private String nickname;
	
	@Column(length = 45)
	private String repname;
	
	@Column(length =45)
	private String coname;
	
	@Column(length = 200)
	private String img;
	
	private Float longitude;
	
	private Float latitude;
	
	@Column(length = 100)
	private String location;
	
	@Column(length = 45)
	private String phoneNumber;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "userIdx",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	List<Category> categorys;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "userIdx",fetch = FetchType.LAZY)
	List<Likes> likes;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "userIdx",fetch = FetchType.LAZY)
	List<Post> posts;
}
