package com.example.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="icon")
public class Icon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iconIdx;
	
	@Column(length = 200)
	private String img;
	
	@Column(length = 45)
	private String name;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "iconIdx")
	List<Item> items;

}
