package org.fasttrackit.onlineshop;

import org.fasttrackit.onlineshop.domain.Product;
import org.fasttrackit.onlineshop.exception.ResourceNotFondException;
import org.fasttrackit.onlineshop.service.ProductService;
import org.fasttrackit.onlineshop.transfer.SaveProductRequest;
import org.junit.jupiter.api.Assertions;
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
        createProduct();
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
    @Test
    void getProduct_whenExistingProduct_thenReturnProduct () {
        Product product = createProduct();
        Product response = productService.getProduct(product.getId());

        assertThat(response, notNullValue());
        assertThat(response.getId(), is(product.getId()));
        assertThat(response.getPrice(), is(product.getPrice()));
        assertThat(response.getQantity(), is(product.getQantity()));
        assertThat(response.getImageUrl(), is(product.getImageUrl()));
        assertThat(response.getDescription(), is(product.getDescription()));
    }
@Test
    void getProduct_whenNonExistingProduct_thenThrowResourceNotFoundException() {
    Assertions.assertThrows(ResourceNotFondException.class,()-> productService.getProduct(99999));
    }

    void updateProduct_whenValidRequest_thenReturnUpdatedProduct() {
        Product product = createProduct();

        SaveProductRequest request = new SaveProductRequest();
        request.setName(product.getName() + "updated");
        request.setDescription(product.getDescription() + "updated");
        request.setPrice(product.getPrice() + 10);
        request.setQantity(product.getQantity() + 10);

        Product updatedProduct = productService.updateProdct(product.getId(), request);

        assertThat(updatedProduct, notNullValue());
        assertThat(updatedProduct.getId(), is(product.getId()));
        assertThat(updatedProduct.getName(), is(request.getName()));
        assertThat(updatedProduct.getDescription(), is(request.getDescription()));
        assertThat(updatedProduct.getPrice(), is(request.getPrice()));
        assertThat(updatedProduct.getQantity(), is(request.getQantity()));
    }
@Test
    void deteleProduct_whenExistingProduct_thenProductDoesNotExistAnyMore() {

    Product product = createProduct();

    productService.deleteProduct(product.getId());
    Assertions.assertThrows(ResourceNotFondException.class, () -> productService.getProduct(product.getId()));

}



    private Product createProduct() {
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

        return product;
    }


}

