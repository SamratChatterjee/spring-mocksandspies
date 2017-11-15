package service;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import model.Product;
import repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplSpyTest {

	@Spy
    private ProductServiceImpl prodServiceSpy;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private Product product;
    
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerException_whenGetProductByIdIsCalledWithoutContext() throws Exception {
        //Act
        Product retrievedProduct = prodServiceSpy.getProductById(5);
        //Assert
        assertThat(retrievedProduct, is(equalTo(product)));
    }
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerException_whenSaveProductIsCalledWithoutContext() throws Exception {
        //Arrange
        Mockito.doReturn(product).when(productRepository).save(product);
        //Act
        Product savedProduct = prodServiceSpy.saveProduct(product);
        //Assert
        assertThat(savedProduct, is(equalTo(product)));
    }
    @Test
    public void shouldVerifyThatGetProductByIdIsCalled() throws Exception {
        //Arrange
        Mockito.doReturn(product).when(prodServiceSpy).getProductById(5);
        //Act
        Product retrievedProduct = prodServiceSpy.getProductById(5);
        //Assert
        Mockito.verify(prodServiceSpy).getProductById(5);
    }
    @Test
    public void shouldVerifyThatSaveProductIsNotCalled() throws Exception {
        //Arrange
        Mockito.doReturn(product).when(prodServiceSpy).getProductById(5);
        //Act
        Product retrievedProduct = prodServiceSpy.getProductById(5);
        //Assert
        Mockito.verify(prodServiceSpy, never()).saveProduct(product);
    }
}
