package productcrudapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;

@Controller
public class ProductController {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/")
	public String home(Model m) {
		List<Product> products = this.productDao.getAllProducts();
		System.out.println(products);
		m.addAttribute("products",products);
		return "index";
	}
	
	@RequestMapping("/add-product")
	public String addProduct() {
		return "add_product_form";
	}
	
	@RequestMapping(value="/handle-product",method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product,HttpServletRequest req) {
		System.out.println(product);
		this.productDao.createProduct(product);
		RedirectView r = new RedirectView();
		r.setUrl(req.getContextPath()+"/");
		return r;
	}
	
	@RequestMapping(value="/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId,HttpServletRequest req) {
		System.out.println(productId);
		this.productDao.deleteProduct(productId);
		RedirectView r = new RedirectView();
		r.setUrl(req.getContextPath()+"/");
		return r;
	}
	
	@RequestMapping(value="/update/{pId}",method = RequestMethod.GET)
	public String updateProduct(@PathVariable("pId") int productId,Model m) {
		System.out.println(productId);
		Product product = this.productDao.getSingleProduct(productId);
		System.out.println(product.getId());
		m.addAttribute("product", product);
		return "update_form";
	}
}
