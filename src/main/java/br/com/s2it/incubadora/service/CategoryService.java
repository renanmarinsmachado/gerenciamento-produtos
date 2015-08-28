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
	
	public void save(Category category){
		repository.persist(category);
	}
	
	public void update(Category category){
		repository.update(category);
	}
	
	public void delete(Category category){
		repository.delete(category);
	}
	
	public List<Category> listAll(Category category){
		return repository.listAll();
	}
	
	public Category findByDescription(String description){
		return repository.findByDescription(description);
	}
}
