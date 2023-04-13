package com.example.model;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

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
@Table(name="category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryIdx;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="user_idx")
	private User userIdx;
	
	@Column(length = 45)
	private String name;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "categoryIdx",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	List<Item> items;
}
