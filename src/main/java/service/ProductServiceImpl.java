package service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Product;
import repository.ProductRepository;

@Service("productservice")
public class ProductServiceImpl implements ProductService{

	private ProductRepository productRepository;
	
	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Product getProductById(Integer id) {
		
		return productRepository.findOne(id);
	}

	public Product saveProduct(Product product) {
		
		return productRepository.save(product);
	}

	public void deleteProduct(Integer id) {
		
		productRepository.delete(id);
	}
}
