package tfg.microservice.product.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
public class Product implements Serializable {

	private static final long serialVersionUID = 4340552175235204140L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private long id;
	@Column(unique = true, nullable = false, length = 30)
	private String name;
	@Column(unique = false, nullable = false, length = 200)
	private String description;
	@Column(unique = false, nullable = false)
	private double price;
	@Column(unique = false, nullable = true)
	private int stockAvailable;
	@Column(unique = false, nullable = false)
	private boolean isVisible = true;
	@Column(unique = false, nullable = false)
	private boolean isReturnable = true;

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
