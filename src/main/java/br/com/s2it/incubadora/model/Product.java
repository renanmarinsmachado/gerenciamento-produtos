package br.com.s2it.incubadora.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by root on 10/08/15.
 */
@Entity
@Table(name = "product")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3038995028863400960L;

	public Product() {
		
	}
	
	public Product(int id) {
		this.id = id;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
    private int id;

    @Column(name="description")
    private String description;
    
    @Column(name="date_creation")
    private Date dateCreation;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="category_id")
    private Category category;

    @Column(name="price")
    private BigDecimal price;

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }

    public BigDecimal getPrice(){
        return price;
    }

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
