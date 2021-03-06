package tfg.microservice.product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tfg.microservice.product.exception.ProductNotFoundException;
import tfg.microservice.product.model.Product;
import tfg.microservice.product.repository.ProductRepository;

@Service("productManager")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository products;

	@Autowired
	private SequenceGeneratorService sequenceService;

	@Override
	public Page<Product> getAllProducts(Pageable page) {
		return products.findByIsVisibleTrue(page);
	}

	@Override
	public Page<Product> getAllProductsOrderByName(Pageable page) {
		return products.findAllByOrderByName(page);
	}

	@Override
	public Page<Product> getAllProductsOrderByPrice(Pageable page) {
		return products.findAllByOrderByPrice(page);
	}

	@Override
	public Page<Product> getAllProductsOrderByPriceDesc(Pageable page) {
		return products.findAllByOrderByPriceDesc(page);
	}

	@Override
	public Page<Product> getAllProductsOrderByStockAvailable(Pageable page) {
		return products.findAllByOrderByStockAvailable(page);
	}

	@Override
	public Page<Product> getProductsByParam(String param, Pageable page) {
		return products.findByParam(param, page);
	}

	@Override
	public Product getProduct(Long id) throws ProductNotFoundException {
		return products.findById(id).orElseThrow(ProductNotFoundException::new);
	}

	@Override
	public Product addProduct(Product product) {
		if (product != null)
			product.setId(sequenceService.generateSequence(Product.SEQUENCE_NAME));
		return Optional.ofNullable(product).map(newProduct -> products.save(newProduct))
				.orElseThrow(IllegalArgumentException::new);
	}

	@Override
	public Product updateProduct(Product product) {
		return Optional.ofNullable(product).map(productUpdated -> products.save(productUpdated))
				.orElseThrow(IllegalArgumentException::new);
	}

	@Override
	public void deleteProduct(Long id) {
		products.deleteById(id);
	}
}
