package br.com.s2it.incubadora.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    
    @OneToMany(mappedBy="category", fetch=FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Product> products;
    
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

	public List<Product> getProducts() {
		if (products == null) {
			products = new ArrayList<Product>();
		}
		resolveRecursion();
		
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void resolveRecursion(){
		if(this.products != null){			
			for(int i=0;i<this.products.size();i++){
				this.products.get(i).setCategory(null);
			}
		}
	}
}
