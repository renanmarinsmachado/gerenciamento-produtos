package br.com.s2it.incubadora.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.s2it.incubadora.model.Product;

@Repository
public class ProductRepository extends AbstractRepository{

	@SuppressWarnings("unchecked")
	public List<Product> listAll() {
		Criteria criteria = getSession().createCriteria(Product.class);
        return criteria.list();
	}

	@Override
	public Object findById(int id) {
		Criteria criteria = getSession().createCriteria(Product.class);
        criteria.add(Restrictions.eq("id",id));
        return criteria.uniqueResult();
	}
	
}
