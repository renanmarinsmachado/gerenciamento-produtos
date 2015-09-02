package br.com.s2it.incubadora.controller;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.s2it.incubadora.model.po.Accessory;
import br.com.s2it.incubadora.model.po.Category;
import br.com.s2it.incubadora.model.po.Product;
import br.com.s2it.incubadora.service.CategoryService;
import br.com.s2it.incubadora.service.ProductService;

/**
 * Created by root on 10/08/15.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	public static final String VIEW = "product";
	
	@Autowired
	private ProductService service;
	
	@Autowired
	private CategoryService categoryService;
	
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String save(Product product, Model model){    	
    	
    	service.save(product);
    	
        return listAll(model);
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String listAll(Model model){    
    	
    	Product product = new Product();
    	product.setDescription("kk");
    	product.setPrice(new BigDecimal(12));
    	product.setDateCreation(new Date());
    	
    	Accessory accessory = new Accessory();
    	accessory.setName("teste");
    	product.getAcessories().add(accessory);
    	
    	Category category = new Category();
    	category.setDescription("descr");
    	categoryService.save(category);
    	
    	product.setCategory(categoryService.findByDescription("descr"));
    	
    	ObjectMapper mapper = new ObjectMapper();
    	
    	try {
			System.out.println(mapper.writeValueAsString(product));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	service.save(product);
    	
    	model.addAttribute("products", service.listAll());
        return VIEW;
    }
}
