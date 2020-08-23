package tfg.microservice.product;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductApplicationTests {

	@Test
	public void main() {
		ProductApplication.main(new String[] {});
		assertTrue(true);
	}

	@Test
	void contextLoads() {
		assertTrue(true);
	}
}
