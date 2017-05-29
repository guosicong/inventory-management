package inventory.springservice.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import inventory.springservice.domain.Product;


public interface ProductRepository extends CrudRepository<Product, Integer> {

	Iterable<Product> findAllByOrderByIDAsc();

	Iterable<Product> findAllByOrderByBrandAscXinghaoAscIsKidAscColorAsc();

	//Product findOne(Integer id);

	//@Query(value = "Select UPDATE size_and_count set count = ?1 where Id = ?2", nativeQuery=true)
	//Product findOneByOrderBySizeAndCounts_SizeASC(Integer id);
}
