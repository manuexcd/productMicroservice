package tfg.microservice.product.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import tfg.microservice.product.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {

	Optional<Product> findByName(String name);

	Page<Product> findAllByOrderByName(Pageable page);

	Page<Product> findAllByOrderByPrice(Pageable page);

	Page<Product> findAllByOrderByPriceDesc(Pageable page);

	Page<Product> findAllByOrderByStockAvailable(Pageable page);

	@Query("{ $or: [ { name: { $regex: ?0 } }, { description: { $regex: ?0 } } ] }")
	Page<Product> findByParam(String param, Pageable page);

	Page<Product> findByIsVisibleTrue(Pageable page);
}
