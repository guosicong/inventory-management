package inventory.springservice.services;

import inventory.springservice.domain.Product;

public interface ProductService {
    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    Product deleteProductById(Integer id, Product product);
}
