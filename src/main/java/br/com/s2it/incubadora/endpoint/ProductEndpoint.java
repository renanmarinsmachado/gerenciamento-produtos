package br.com.s2it.incubadora.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.s2it.incubadora.model.po.Product;
import br.com.s2it.incubadora.service.ProductService;

@RestController
@RequestMapping("/ed/product")
public class ProductEndpoint {

	@Autowired
	private ProductService service;
	
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@RequestBody Product product){
		
		service.save(product);
		
		return new ResponseEntity<Product> (HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> list(){
		
		List<Product> listAll = service.listAll();
		return new ResponseEntity<List<Product>>(listAll,HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody Product product){
		
		service.update(product);
		
		return new ResponseEntity<Product> (HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		
		service.delete(new Product(id));
		
		return new ResponseEntity<Product> (HttpStatus.OK);
	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> list(@PathVariable("id") int id){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		if(service.canRemove(id)){
			status = HttpStatus.OK;
		}
		
		return new ResponseEntity<Product>(status);
	}
}
