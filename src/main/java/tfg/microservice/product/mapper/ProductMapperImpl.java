package tfg.microservice.product.mapper;

import org.springframework.stereotype.Component;

import tfg.microservice.product.dto.ProductDTO;
import tfg.microservice.product.model.Product;

@Component
public class ProductMapperImpl extends GenericMapperImpl<Product, ProductDTO> implements ProductMapper {

	@Override
	public Class<Product> getClazz() {
		return Product.class;
	}

	@Override
	public Class<ProductDTO> getDtoClazz() {
		return ProductDTO.class;
	}
}
