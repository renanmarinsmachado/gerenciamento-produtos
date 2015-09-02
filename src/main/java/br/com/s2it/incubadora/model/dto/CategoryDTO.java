package br.com.s2it.incubadora.model.dto;

import java.util.List;

public class CategoryDTO {

	private int id;
	
	private String description;

	private List<ProductDTO> products;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ProductDTO> getProducts() {
		resolveRecursion();
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
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
