package br.com.s2it.incubadora.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name="category")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2751367897394166021L;

	public Category() {}
	
	public Category(int id) {
		this.id = id;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="category_id")
    private int id;

    @Column(name="description")
    private String description;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
