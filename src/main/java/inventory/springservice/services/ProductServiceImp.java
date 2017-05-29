package inventory.springservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inventory.springservice.domain.Product;
import inventory.springservice.repositories.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	public ProductRepository getProductRepository() {
		return productRepository;
	}

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Iterable<Product> listAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAllByOrderByBrandAscXinghaoAscIsKidAscColorAsc();
	}

	@Override
	public Product getProductById(Integer id) {
		// TODO Auto-generated method stub
		return productRepository.findOne(id);
	}

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		System.out.println("***saveProduct!!!");
		return productRepository.save(product);
	}

	@Override
	public Product deleteProductById(Integer id, Product product) {
		// TODO Auto-generated method stub
		productRepository.delete(product);
        productRepository.delete(id);
        return product;
	}
	
	
}
