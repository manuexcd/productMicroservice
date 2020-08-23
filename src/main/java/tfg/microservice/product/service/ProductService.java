package tfg.microservice.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tfg.microservice.product.exception.ProductNotFoundException;
import tfg.microservice.product.model.Product;

public interface ProductService {
	public Page<Product> getAllProducts(Pageable page);

	public Page<Product> getAllProductsOrderByName(Pageable page);

	public Page<Product> getAllProductsOrderByPrice(Pageable page);

	public Page<Product> getAllProductsOrderByPriceDesc(Pageable page);

	public Page<Product> getAllProductsOrderByStockAvailable(Pageable page);

	public Page<Product> getProductsByParam(String param, Pageable page);

	public Product getProduct(Long id) throws ProductNotFoundException;

	public Product addProduct(Product product);
	
	public Product updateProduct(Product product);

	public void deleteProduct(Long id);
}
