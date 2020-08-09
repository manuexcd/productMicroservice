package tfg.microservice.product.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tfg.microservice.product.exception.ProductNotFoundException;
import tfg.microservice.product.model.Product;
import tfg.microservice.product.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ProductServiceTest {

	@Mock
	private ProductRepository dao;

	@Mock
	private SequenceGeneratorService sequenceGenerator;

	@InjectMocks
	private ProductServiceImpl service;

	private Pageable pageRequest;

	@Test
	public void testGetAllProducts() {
		given(dao.findByIsVisibleTrue(pageRequest)).willReturn(Page.empty());
		assertNotNull(service.getAllProducts(pageRequest));
	}

	@Test
	public void testGetAllProductsOrderByName() {
		given(dao.findAllByOrderByName(pageRequest)).willReturn(Page.empty());
		assertNotNull(service.getAllProductsOrderByName(pageRequest));
	}

	@Test
	public void testGetAllProductsOrderByPrice() {
		given(dao.findAllByOrderByPrice(pageRequest)).willReturn(Page.empty());
		assertNotNull(service.getAllProductsOrderByPrice(pageRequest));
	}

	@Test
	public void testGetAllProductsOrderByPriceDesc() {
		given(dao.findAllByOrderByPriceDesc(pageRequest)).willReturn(Page.empty());
		assertNotNull(service.getAllProductsOrderByPriceDesc(pageRequest));
	}

	@Test
	public void testGetAllProductsOrderByStockAvailable() {
		given(dao.findAllByOrderByStockAvailable(pageRequest)).willReturn(Page.empty());
		assertNotNull(service.getAllProductsOrderByStockAvailable(pageRequest));
	}

	@Test
	public void testGetProductsByParam() {
		given(dao.findByParam(anyString(), eq(pageRequest))).willReturn(Page.empty());
		assertNotNull(service.getProductsByParam(anyString(), eq(pageRequest)));
	}

	@Test
	public void testGetProductById() throws ProductNotFoundException {
		given(dao.findById(any())).willReturn(Optional.of(new Product()));
		assertNotNull(service.getProduct(any()));
	}

	@Test(expected = ProductNotFoundException.class)
	public void testProductNotFound() throws ProductNotFoundException {
		given(dao.findById(any())).willReturn(Optional.ofNullable(null));
		assertNull(service.getProduct(any()));
	}

	@Test
	public void testAddProduct() {
		Product product = new Product();
		given(dao.save(product)).willReturn(product);
		assertNotNull(service.addProduct(product));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddProductException() {
		assertNotNull(service.addProduct(null));
	}

	@Test
	public void testUpdateProduct() {
		Product product = new Product();
		given(dao.save(product)).willReturn(product);
		assertNotNull(service.updateProduct(product));
	}

	@Test
	public void testDeleteProduct() {
		Product product = new Product();
		dao.save(product);
		Long id = product.getId();
		service.deleteProduct(id);
		assertFalse(dao.existsById(id));
	}
}