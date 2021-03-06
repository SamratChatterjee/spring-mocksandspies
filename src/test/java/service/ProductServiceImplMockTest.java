package service;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import model.Product;
import repository.ProductRepository;

public class ProductServiceImplMockTest {

	private ProductServiceImpl productServiceImpl;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private Product product;
    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
        productServiceImpl = new ProductServiceImpl();
        productServiceImpl.setProductRepository(productRepository);
    }
    
    @Test
    public void shouldReturnProduct_whenGetProductByIdIsCalled() throws Exception {
        // Arrange     
        when(productRepository.findOne(5)).thenReturn(product);
        // Act    
        Product retrievedProduct = productServiceImpl.getProductById(5);
        // Assert    
        assertThat(retrievedProduct, is(equalTo(product)));
    }
    @Test
    public void shouldReturnProduct_whenSaveProductIsCalled() throws Exception {
        // Arrange       
        when(productRepository.save(product)).thenReturn(product);
        // Act         
        Product savedProduct = productServiceImpl.saveProduct(product);
        // Assert         
        assertThat(savedProduct, is(equalTo(product)));
    }
    @Test
    public void shouldCallDeleteMethodOfProductRepository_whenDeleteProductIsCalled() throws Exception {
        // Arrange         
        doNothing().when(productRepository).delete(5);
        ProductRepository my = Mockito.mock(ProductRepository.class);
        // Act         
        productServiceImpl.deleteProduct(5);
        // Assert         
        verify(productRepository, times(1)).delete(5);
    }
}
