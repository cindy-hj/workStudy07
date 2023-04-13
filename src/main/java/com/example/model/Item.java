package com.example.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="item")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemIdx;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="category_idx")
	private Category categoryIdx;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="icon_idx")
	private Icon iconIdx;
	
	@Column(length = 45)
	private String name;
	
	@Column(length = 45)
	private String unit;
	
	private int alarmcnt;
	
	private int memocnt;
	
	private int presentcnt;
	
	@Column(columnDefinition = "TINYINT")
	private int flag;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "itemIdx")
	private List<Date> dates;

}
