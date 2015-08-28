package br.com.s2it.incubadora.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by root on 10/08/15.
 */
@Entity
@Table(name = "product")
@DynamicUpdate
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
    
    @ManyToMany(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
    @JoinTable(name = "product_acessory",
    		joinColumns={@JoinColumn(name="product_id")},
    		inverseJoinColumns={@JoinColumn(name="accessory_id")})
    private List<Accessory> acessories;

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

	public List<Accessory> getAcessories() {
		if (acessories == null) {
			acessories = new ArrayList<Accessory>();
		}

		return acessories;
	}

	public void setAcessories(List<Accessory> acessories) {
		this.acessories = acessories;
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
