package tfg.microservice.product.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoOperations;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class SequenceGeneratorServiceTest {

	@Mock
	private MongoOperations mongoOperations;

	@InjectMocks
	private SequenceGeneratorService service;

	@Test
	public void generateSequenceTest() {
		assertNotNull(service.generateSequence("sequence"));
	}

	@Test
	public void generateSequenceTest2() {
		assertEquals(1, service.generateSequence("sequence"));
	}
}
