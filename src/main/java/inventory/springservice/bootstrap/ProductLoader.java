package inventory.springservice.bootstrap;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import inventory.springservice.repositories.ProductRepository;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

	private ProductRepository productRepository;
    private Logger log = Logger.getLogger(ProductLoader.class);
	
	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
	
        productRepository.findAll();

	}
	
}
