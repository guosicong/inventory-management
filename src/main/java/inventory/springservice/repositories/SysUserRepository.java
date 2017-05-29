package inventory.springservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import inventory.springservice.domain.SysUser;

/**
 * Created by sang on 2017/1/10.
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByUsername(String username);
    Iterable<SysUser> findAllByOrderByUsername();
}
