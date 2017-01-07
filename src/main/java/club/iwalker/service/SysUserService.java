package club.iwalker.service;

import club.iwalker.entity.SysRole;
import club.iwalker.entity.SysUser;
import com.google.common.base.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangchen on 2017/1/7.
 */
@Service
public class SysUserService implements UserDetailsService { //1

    @Override
    public UserDetails loadUserByUsername(String username) { //2

        SysUser sysUser = null;

        Optional<String> optional = Optional.fromNullable(username);
        if (optional.isPresent()) {
            sysUser = new SysUser();
            sysUser.setId(1000001L);
            sysUser.setUsername("admin");
            sysUser.setPassword("password");
            List<SysRole> roleList = new ArrayList<>();
            sysUser.setRoles(roleList);
        }
        if(sysUser == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        return sysUser;
    }

}
