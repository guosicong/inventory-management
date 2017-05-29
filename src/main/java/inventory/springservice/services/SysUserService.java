package inventory.springservice.services;

import inventory.springservice.domain.SysUser;

public interface SysUserService {
	Iterable<SysUser> listAllSysUsers();

}
