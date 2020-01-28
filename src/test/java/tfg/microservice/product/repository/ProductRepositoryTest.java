package tfg.microservice.product.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import tfg.microservice.product.model.Product;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ProductRepository products;

	@Before
	public void setUp() {
		String string = "Prueba";
		Product product = new Product(string, string, 2, 2, true);
		entityManager.persist(product);
		entityManager.flush();
	}

	@Test
	public void findAll() {
		assertNotNull(products.findAll());
	}

	@Test
	public void findById() {
		assertNotNull(products.findById((long) 1));
	}

	@Test
	public void findByParam() {
		assertNotNull(products.findByParam("Prueba", PageRequest.of(1, 1)));
	}

	@Test
	public void findByName() {
		assertNotNull(products.findByName("aa"));
	}

	@Test
	public void findAllByOrderByName() {
		assertNotNull(products.findAllByOrderByName(PageRequest.of(1, 1)));
	}

	@Test
	public void findAllByOrderByPrice() {
		assertNotNull(products.findAllByOrderByPrice(PageRequest.of(1, 1)));
	}

	@Test
	public void findAllByOrderByPriceDesc() {
		assertNotNull(products.findAllByOrderByPriceDesc(PageRequest.of(1, 1)));
	}

	@Test
	public void findAllByOrderByStockAvailable() {
		assertNotNull(products.findAllByOrderByStockAvailable(PageRequest.of(1, 1)));
	}

	@Test
	public void findByIsVisibleTrue() {
		assertNotNull(products.findByIsVisibleTrue(PageRequest.of(1, 1)));
	}
}
