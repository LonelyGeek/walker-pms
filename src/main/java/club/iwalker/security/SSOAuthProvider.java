package club.iwalker.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * Created by wangchen on 2017/3/3.
 */
@Component
public class SSOAuthProvider implements AuthenticationProvider {
    private static final Logger log = LoggerFactory.getLogger(SSOAuthProvider.class);

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.debug("自定义provider调用");

        // 返回一个Token对象表示登陆成功
        return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), Collections.<GrantedAuthority>emptyList());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
