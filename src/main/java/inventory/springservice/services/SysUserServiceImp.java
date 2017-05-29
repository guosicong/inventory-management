package inventory.springservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inventory.springservice.domain.SysUser;
import inventory.springservice.repositories.SysUserRepository;

@Service
public class SysUserServiceImp implements SysUserService {
	
	@Autowired
	private SysUserRepository sysUserRepository;

	public SysUserRepository getSysUserRepository() {
		return sysUserRepository;
	}

	public void setSysUserRepository(SysUserRepository sysUserRepository) {
		this.sysUserRepository = sysUserRepository;
	}

	@Override
	public Iterable<SysUser> listAllSysUsers() {
		// TODO Auto-generated method stub
		return this.sysUserRepository.findAllByOrderByUsername();
	}
	

}
