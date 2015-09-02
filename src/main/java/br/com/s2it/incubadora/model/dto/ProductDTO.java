package br.com.s2it.incubadora.model.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ProductDTO {

	private int id;

    private String description;
    
    private Date dateCreation;
    
    private CategoryDTO category;

    private BigDecimal price;

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

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public CategoryDTO getCategory() {
		resolveRecursion();
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
    
	public void resolveRecursion(){
		if(this.category != null){			
			this.category.setProducts(null);
		}
	}
}
