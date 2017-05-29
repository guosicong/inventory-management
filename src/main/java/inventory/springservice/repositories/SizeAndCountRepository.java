package inventory.springservice.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import inventory.springservice.domain.SizeAndCount;

public interface SizeAndCountRepository extends CrudRepository<SizeAndCount, Integer>{
	
	@Modifying
    @Query(value = "INSERT INTO size_and_count (product_id, size,count) " +
            "VALUES (?1, ?2, ?3)", nativeQuery=true)
	public void insertSizeAndCount(Integer id, float size,Integer count);
	
	@Modifying
	@Query(value = "UPDATE size_and_count set count = ?1 where Id = ?2", nativeQuery=true)
	public void updateSizeAndCountCount(Integer count, Integer id);

	public Iterable<SizeAndCount> findAllByOrderBySizeAsc();
	
}
