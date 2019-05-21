package com.example.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5048368401181187551L;
	private int totalPages;
	private long totalRecords;
	private int currentPage;
	private List<User> users;	

}
