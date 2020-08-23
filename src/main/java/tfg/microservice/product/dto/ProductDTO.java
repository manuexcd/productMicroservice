package tfg.microservice.product.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 4340552175235204140L;
	private Long id;
	private String name;
	private String description;
	private double price;
	private int stockAvailable;
	@JsonProperty
	private boolean isVisible;
	private String imageUrl;
}
