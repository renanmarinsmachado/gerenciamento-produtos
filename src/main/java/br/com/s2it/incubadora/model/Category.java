package br.com.s2it.incubadora.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="category")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2751367897394166021L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="category_id")
    private int id;

    @Column(name="description")
    private String description;
    
    @Transient
    @OneToMany(mappedBy="category")
    private List<Product> produtos;

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

	public List<Product> getProdutos() {
		if (produtos == null) {
			produtos = new ArrayList<Product>();
		}

		return produtos;
	}

	public void setProdutos(List<Product> produtos) {
		this.produtos = produtos;
	}
}
