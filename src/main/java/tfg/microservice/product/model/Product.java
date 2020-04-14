package tfg.microservice.product.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
public class Product implements Serializable {

	private static final long serialVersionUID = 4340552175235204140L;

	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	@Id
	private Long id;
	@Indexed(unique = true)
	private String name;
	@Indexed(unique = true)
	private String description;
	private double price;
	private int stockAvailable;
	private boolean isVisible = true;
	private boolean isReturnable = true;
	private String imageUrl;

	public Product(String name, String description, double price, int stockAvailable, boolean isVisible) {
		this.setName(name);
		this.setDescription(description);
		this.setPrice(price);
		this.setStockAvailable(stockAvailable);
		this.setVisible(isVisible);
	}

	public void updateStock(int stock) {
		this.stockAvailable += stock;
	}
}
