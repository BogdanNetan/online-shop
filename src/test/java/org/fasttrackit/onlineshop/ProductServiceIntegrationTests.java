package org.fasttrackit.onlineshop;

import org.fasttrackit.onlineshop.domain.Product;
import org.fasttrackit.onlineshop.service.ProductService;
import org.fasttrackit.onlineshop.transfer.SaveProductRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@SpringBootTest
public class ProductServiceIntegrationTests {
    // field-injection(injecting dependecies form IoC annotating the field itself)
    //field = instance variables
    @Autowired
    private ProductService productService;

    @Test
    void createProduct_whenValidRequest_thenProductisCreated() {
        SaveProductRequest request = new SaveProductRequest();
        request.setName("Phone");
        request.setQantity(100);
        request.setPrice(300.5);

        Product product = productService.createProduct(request);

        assertThat(product, notNullValue());
        assertThat(product.getId(), greaterThan(0L));
        assertThat(product.getName(), is(request.getName()));
        assertThat(product.getQantity(), is(request.getQantity()));
        assertThat(product.getPrice(), is(request.getPrice()));
    }

    @Test
    void createProduct_whenMissingName_thenExceptionisThrow() {

        SaveProductRequest request = new SaveProductRequest();
        request.setQantity(100);
        request.setPrice(300.5);


        try {
            productService.createProduct(request);
        } catch (Exception e) {
            assertThat(e, notNullValue());
            assertThat("Unsexpected exception type." , e instanceof TransactionSystemException);
        }


    }




}