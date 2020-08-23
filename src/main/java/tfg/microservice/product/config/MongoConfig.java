package tfg.microservice.product.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

	@Value("${mongodb.url}")
	private String mongoUrl;

	@Override
	protected String getDatabaseName() {
		return "products";
	}

	@Override
	public MongoClient mongoClient() {
		return MongoClients.create(mongoUrl);
	}

}
