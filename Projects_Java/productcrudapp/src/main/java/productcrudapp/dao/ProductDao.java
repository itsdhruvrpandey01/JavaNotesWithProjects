package productcrudapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import productcrudapp.model.Product;

@Component
public class ProductDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
//	save
	@Transactional
	public void createProduct(Product product) {
		this.hibernateTemplate.saveOrUpdate(product);
	}
	
//	GetAllProducts
	@Transactional
	public List<Product> getAllProducts(){
		List<Product> products= this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
//  Delete 
	@Transactional
	public void deleteProduct(int pid) {
		Product p=this.hibernateTemplate.load(Product.class,pid);
		this.hibernateTemplate.delete(p);
	}
	
//	get single product
	@Transactional
	public Product getSingleProduct(int pid) {
		return this.hibernateTemplate.get(Product.class,pid);
	}
}
 