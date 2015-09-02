package br.com.s2it.incubadora.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.s2it.incubadora.model.po.Category;

@Repository
public class CategoryRepository extends AbstractRepository{

	public Category findByIdWithProducts(int id) {
		Query query = getSession().createQuery("FROM Category c JOIN FETCH c.products WHERE c.id = :id");
		query.setParameter("id", id);
		return (Category) query.uniqueResult();
	}
	
	@Override
	public Object findById(int id) {
		Criteria criteria = getSession().createCriteria(Category.class);
        criteria.add(Restrictions.eq("id",id));
        return criteria.uniqueResult();
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
