package br.com.s2it.incubadora.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.s2it.incubadora.model.Category;
import br.com.s2it.incubadora.repository.CategoryRepository;

@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
//	@Autowired
//	private ProductService productService;
	
	public void save(Category category){
		repository.persist(category);
	}
	
	public void update(Category category){
		repository.update(category);
	}
	
	public void delete(Category category){
		repository.delete(category);
	}
	
	public List<Category> listAll(){
		return repository.listAll();
	}
	
	public Category findByDescription(String description){
		return repository.findByDescription(description);
	}
	
	public Category findById(int id){
		return (Category) repository.findById(id);
	}
	
	public Category findByIdWithProducts(int id){
		
//		Category category = this.findById(id);
//		category.setProdutos(productService.findByCategory(category));
		
		Category category = (Category) repository.findById(id);
		
		return category;
	}
}
