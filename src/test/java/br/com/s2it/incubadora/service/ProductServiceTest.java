package br.com.s2it.incubadora.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.s2it.incubadora.model.Product;
import br.com.s2it.incubadora.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

	@Mock
	private ProductRepository repository;
	
	@InjectMocks
	private ProductService service;
	
	@Test
	public void shouldValidIfCanRemove(){
		
		int id = 123;
		Product product = new Product(id);
		
		when(repository.findById(id)).thenReturn(product);
		
		boolean isRemovible = service.canRemove(id);
		
		assertTrue(isRemovible);
	}
	
	@Test
	public void shouldValidIfCanNotRemove(){
		
		int id = 123;
		Product product = null;
		
		when(repository.findById(id)).thenReturn(product);
		
		boolean isRemovible = service.canRemove(id);
		
		assertFalse(isRemovible);
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void shouldValidIfCanRemoveWithException(){
		
		int id = 123;
		
		when(repository.findById(id)).thenThrow(Exception.class);
		
		boolean isRemovible = service.canRemove(id);
		
		assertFalse(isRemovible);
	}
}
