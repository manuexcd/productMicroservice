package tfg.microservice.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tfg.microservice.product.dto.ProductDTO;
import tfg.microservice.product.exception.ProductNotFoundException;
import tfg.microservice.product.mapper.ProductMapper;
import tfg.microservice.product.model.Constants;
import tfg.microservice.product.service.ProductService;

@RestController
@RequestMapping(value = Constants.PATH_PRODUCTS)
public class ProductController {

	@Autowired
	private ProductService productManager;

	@Autowired
	private ProductMapper mapper;

	@GetMapping
	public ResponseEntity<Page<ProductDTO>> getAllProducts(
			@RequestParam(defaultValue = Constants.PAGINATION_DEFAULT_PAGE) int page,
			@RequestParam(defaultValue = Constants.PAGINATION_DEFAULT_SIZE) int pageSize) {
		return new ResponseEntity<>(
				mapper.mapEntityPageToDtoPage(productManager.getAllProducts(PageRequest.of(page, pageSize))),
				HttpStatus.OK);
	}

	@GetMapping(value = "/name")
	public ResponseEntity<Page<ProductDTO>> getAllProductsOrderByName(
			@RequestParam(defaultValue = Constants.PAGINATION_DEFAULT_PAGE) int page,
			@RequestParam(defaultValue = Constants.PAGINATION_DEFAULT_SIZE) int pageSize) {
		return new ResponseEntity<>(
				mapper.mapEntityPageToDtoPage(productManager.getAllProductsOrderByName(PageRequest.of(page, pageSize))),
				HttpStatus.OK);
	}

	@GetMapping(value = "/price")
	public ResponseEntity<Page<ProductDTO>> getAllProductsOrderByPrice(
			@RequestParam(defaultValue = Constants.PAGINATION_DEFAULT_PAGE) int page,
			@RequestParam(defaultValue = Constants.PAGINATION_DEFAULT_SIZE) int pageSize) {
		return new ResponseEntity<>(mapper.mapEntityPageToDtoPage(
				productManager.getAllProductsOrderByPrice(PageRequest.of(page, pageSize))), HttpStatus.OK);
	}

	@GetMapping(value = "/pricedesc")
	public ResponseEntity<Page<ProductDTO>> getAllProductsOrderByPriceDesc(
			@RequestParam(defaultValue = Constants.PAGINATION_DEFAULT_PAGE) int page,
			@RequestParam(defaultValue = Constants.PAGINATION_DEFAULT_SIZE) int pageSize) {
		return new ResponseEntity<>(mapper.mapEntityPageToDtoPage(
				productManager.getAllProductsOrderByPriceDesc(PageRequest.of(page, pageSize))), HttpStatus.OK);
	}

	@GetMapping(value = "/stock")
	public ResponseEntity<Page<ProductDTO>> getAllProductsOrderByStockAvailable(
			@RequestParam(defaultValue = Constants.PAGINATION_DEFAULT_PAGE) int page,
			@RequestParam(defaultValue = Constants.PAGINATION_DEFAULT_SIZE) int pageSize) {
		return new ResponseEntity<>(
				mapper.mapEntityPageToDtoPage(
						productManager.getAllProductsOrderByStockAvailable(PageRequest.of(page, pageSize))),
				HttpStatus.OK);
	}

	@GetMapping(value = "/search/{param}")
	public ResponseEntity<Page<ProductDTO>> getProductsByParam(@PathVariable String param,
			@RequestParam(defaultValue = Constants.PAGINATION_DEFAULT_PAGE) int page,
			@RequestParam(defaultValue = Constants.PAGINATION_DEFAULT_SIZE) int pageSize) {
		return new ResponseEntity<>(
				mapper.mapEntityPageToDtoPage(productManager.getProductsByParam(param, PageRequest.of(page, pageSize))),
				HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) throws ProductNotFoundException {
		try {
			return new ResponseEntity<>(mapper.mapEntityToDto(productManager.getProduct(id)), HttpStatus.OK);
		} catch (ProductNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping
	public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO dto) {
		return new ResponseEntity<>(mapper.mapEntityToDto(productManager.updateProduct(mapper.mapDtoToEntity(dto))),
				HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO dto) {
		return new ResponseEntity<>(mapper.mapEntityToDto(productManager.addProduct(mapper.mapDtoToEntity(dto))),
				HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> deleteProduct(@PathVariable Long id) {
		productManager.deleteProduct(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
