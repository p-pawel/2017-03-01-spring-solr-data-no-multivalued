package com.example;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

import javax.annotation.PostConstruct;
import java.net.MalformedURLException;

/**
 * Please create solr core `solr create -c products` and run Solr (assuming default port 8983)
 */
@SpringBootApplication
@EnableSolrRepositories(basePackages = {"com.example"}, multicoreSupport = true)
public class DemoApplication {

	private static final String SOLR_HOST = "http://127.0.0.1:8983/solr/";

	@Autowired
	private SolrProductRepository solrProductRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public SolrClient solrClient() throws MalformedURLException, IllegalStateException {
		return new HttpSolrClient(SOLR_HOST);
	}

	@PostConstruct
	public void init() {
		solrProductRepository.deleteAll();

		SolrProductData product = new SolrProductData();
		product.setCode("123");
		product.setName("My Cool Product");

		solrProductRepository.save(product);
	}
}
