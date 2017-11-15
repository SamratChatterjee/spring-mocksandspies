package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import model.Product;

@Repository("productRepository")
@Component
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
