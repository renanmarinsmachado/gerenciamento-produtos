package br.com.s2it.incubadora.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.s2it.incubadora.model.Category;

@Repository
public class CategoryRepository extends AbstractRepository{

	@Override
	public Object findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Category findByDescription(String description) {
		Criteria criteria = getSession().createCriteria(Category.class);
        criteria.add(Restrictions.eq("description",description));
        return (Category) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Category> listAll() {
		Criteria criteria = getSession().createCriteria(Category.class);
        return criteria.list();
	}
}
