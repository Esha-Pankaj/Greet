package com.advjava.bugtracker.model;

import java.time.LocalDate;


/**
 * Todo.java
 * This is a model class represents a Todo entity
 * @author Ramesh Fadatare
 *
 */
public class Bug {

	private Long id;
	private String title;
	private String username;
	private String userassign;
	private LocalDate targetDate;
	private String status;
	
	protected Bug() {
		
	}
	
	public Bug(long id, String title, String username, String userassign, LocalDate targetDate, String isDone) {
		super();
		this.id = id;
		this.title = title;
		this.username = username;
		this.userassign = userassign;
		this.targetDate = targetDate;
		this.status = isDone;
	}

	public Bug(String title, String username, String userassign, LocalDate targetDate, String isDone) {
		super();
		this.title = title;
		this.username = username;
		this.userassign = userassign;
		this.targetDate = targetDate;
		this.status = isDone;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getuserassign() {
		return userassign;
	}

	public void setuserassign(String userassign) {
		this.userassign = userassign;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bug other = (Bug) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
