package tfg.microservice.product.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseSequenceTest {

	@Test
	public void testEmptyConstructor() {
		DatabaseSequence sequence = new DatabaseSequence();
		assertNotNull(sequence);
	}

	@Test
	public void testConstructor() {
		DatabaseSequence sequence = new DatabaseSequence("id", 1);
		assertNotNull(sequence);
	}

	@Test
	public void testGetters() {
		DatabaseSequence sequence = new DatabaseSequence("id", 1);
		assertNotNull(sequence.getId());
		assertNotNull(sequence.getSeq());
	}
}
