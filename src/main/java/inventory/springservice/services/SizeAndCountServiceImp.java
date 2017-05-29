package inventory.springservice.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inventory.springservice.domain.SizeAndCount;
import inventory.springservice.repositories.SizeAndCountRepository;

@Service
public class SizeAndCountServiceImp implements SizeAndCountService {
	@Autowired
	private SizeAndCountRepository sizeAndCountRepository;

	@Autowired
	public SizeAndCountRepository getSizeAndCountRepository() {
		return sizeAndCountRepository;
	}

	@Autowired
	public void setSizeAndCountRepository(SizeAndCountRepository sizeAndCountRepository) {
		this.sizeAndCountRepository = sizeAndCountRepository;
	}
	
//	@Override
//	public Iterable<SizeAndCount> listAllSizeAndCounts() {
//		return sizeAndCountRepository.findAllByOrderBySizeAsc();
//	}

	@Override
	@Transactional
	public SizeAndCount getSizeAndCountById(Integer id) {
		return sizeAndCountRepository.findOne(id);
	}
/*
	@Override
	public SizeAndCount saveSizeAndCount(SizeAndCount sizeAndCount) {
		// TODO Auto-generated method stub
    	System.out.println("**************进来了****saveSizeAndCountService1***********");
    	System.out.println(sizeAndCount.getCount());
    	System.out.println(sizeAndCount.getSize());
    	System.out.println(sizeAndCount.getProduct().getID());
		//return sizeAndCountRepository.save(sizeAndCount);
    	
    	return null;
	}
*/	
	@Override
	@Transactional
	public void saveSizeAndCount(Integer id, float size,Integer count) {	
		sizeAndCountRepository.insertSizeAndCount(id, size, count);
	};	

	@Override
	public SizeAndCount deleteSizeAndCountById(Integer id, SizeAndCount sizeAndCount) {
		// TODO Auto-generated method stub
		sizeAndCountRepository.delete(id);
		sizeAndCountRepository.delete(sizeAndCount);
		return sizeAndCount;
	}
	
	@Override
	public void deleteSizeAndCountById(Integer id) {
		// TODO Auto-generated method stub
		sizeAndCountRepository.delete(id);
	}
	
	@Override
	@Transactional
	public void updateSizeAndCountCount(Integer addCount, SizeAndCount sizeAndCount) {
		sizeAndCountRepository.updateSizeAndCountCount(addCount,sizeAndCount.getId());
	}
}
