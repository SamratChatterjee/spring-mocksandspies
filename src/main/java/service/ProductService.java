package service;

import model.Product;

public interface ProductService {
	public Product getProductById(Integer id);
	public Product saveProduct(Product product);
	public void deleteProduct(Integer id);
}
