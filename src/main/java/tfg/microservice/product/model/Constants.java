package tfg.microservice.product.model;

public final class Constants {
	private Constants() {
	}

	public static final String PAGINATION_DEFAULT_PAGE = "0";
	public static final String PAGINATION_DEFAULT_SIZE = "5";

	public static final String PATH_PRODUCTS = "/products";
	public static final String PATH_PRODUCTS_WILDCARD = "/products/**";

	public static final String PARAM_ID = "/{id}";
	public static final String PARAM = "/{param}";

	public static final String GOOGLE_CLOUD_PROJECT_ID = "tfg-kubernetes-250608";
	public static final String GOOGLE_CLOUD_BUCKET_NAME = "tfg-images";
}
