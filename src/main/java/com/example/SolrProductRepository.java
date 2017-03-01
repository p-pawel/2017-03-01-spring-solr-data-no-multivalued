package com.example;

import org.springframework.data.solr.repository.SolrCrudRepository;

public interface SolrProductRepository extends SolrCrudRepository<SolrProductData, String> {


}

