package br.com.s2it.incubadora.servicedozer;

import java.util.List;

import javax.transaction.Transactional;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.s2it.incubadora.model.dto.CategoryDTO;
import br.com.s2it.incubadora.model.po.Category;
import br.com.s2it.incubadora.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceDozer {

	@Autowired
	private CategoryRepository repository;
	
	@Autowired
	private Mapper mapper;
	
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
	
	public CategoryDTO findById(int id){
		Category category = (Category) repository.findById(id);
		
		if(category == null){
			return null;
		}
		
		CategoryDTO categoryDTO = mapper.map(category, CategoryDTO.class);
		
		return categoryDTO;
	}
	
	public CategoryDTO findByIdWithProducts(int id){
		Category category = (Category) repository.findByIdWithProducts(id);
		
		if(category == null){
			return null;
		}
		
		CategoryDTO categoryDTO = mapper.map(category, CategoryDTO.class);
		
		return categoryDTO;
	}
}
