package inventory.springservice.services;

import inventory.springservice.domain.SizeAndCount;

public interface SizeAndCountService {

    //Iterable<SizeAndCount> listAllSizeAndCounts();
	SizeAndCount getSizeAndCountById(Integer id);
	void saveSizeAndCount(Integer id, float size, Integer count, Long sysUserId);
	void updateSizeAndCountCount(Integer count, SizeAndCount sizeAndCount);
	SizeAndCount deleteSizeAndCountById(Integer id, SizeAndCount sizeAndCount);
	void deleteSizeAndCountById(Integer id);
}
