package br.com.s2it.incubadora.endpoint;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.s2it.incubadora.model.Category;
import br.com.s2it.incubadora.model.Product;
import br.com.s2it.incubadora.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryEndpoint {
	
	@Autowired
	private CategoryService service;
	
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@RequestBody Category category){
		
		service.save(category);
		
		return new ResponseEntity<Product> (HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional
	public ResponseEntity<?> list(){
		
		List<Category> categories = service.listAll();
		
		return new ResponseEntity<List<Category>>(categories,HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findById(@PathVariable("id") int id) throws JsonProcessingException{
		
		Category category = service.findByIdWithProducts(id);
		
		return new ResponseEntity<Category>(category,HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody Category category){
		
		service.update(category);
		
		return new ResponseEntity<Product> (HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		
		service.delete(new Category(id));
		
		return new ResponseEntity<Product> (HttpStatus.OK);
	}
}
