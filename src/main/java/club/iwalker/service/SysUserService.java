package club.iwalker.service;

import club.iwalker.repository.SysUserRepository;
import club.iwalker.entity.SysUser;
import com.google.common.base.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * Created by wangchen on 2017/1/7.
 */
@Service
public class SysUserService implements UserDetailsService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<SysUser> sysUserOptional = sysUserRepository.findByUsername(username);
        if (sysUserOptional.isPresent()) {
            return sysUserOptional.get();
        }

        /*SysUser sysUser = null;

        Optional<String> optional = Optional.fromNullable(username);
        if (optional.isPresent()) {
            sysUser = new SysUser();
            sysUser.setId(1000001L);
            sysUser.setUsername("admin");
            sysUser.setPassword("password");
            List<SysRole> roleList = new ArrayList<>();
            SysRole sysRole = new SysRole();
            sysRole.setId(10001L);
            sysRole.setName("ROLE_ADMIN");
            roleList.add(sysRole);
            sysUser.setRoleList(roleList);
        }
        if(sysUser == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        return sysUser;
        */
        return null;
    }

}
