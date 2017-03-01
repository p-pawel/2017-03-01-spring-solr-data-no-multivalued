package com.example;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Getter @Setter
@SolrDocument(solrCoreName="products")
public class SolrProductData {

    @Id
    private String code;

    @Indexed(type = "string")
    private String name;

}
