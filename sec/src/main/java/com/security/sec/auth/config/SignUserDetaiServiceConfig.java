package com.security.sec.auth.config;

import com.security.sec.auth.UserDetail;
import com.security.sec.entity.User;
import com.security.sec.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component("signUserDetailService")
public class SignUserDetaiServiceConfig implements UserDetailsService {
    @Autowired
    private IUserService userService;

    /**
     * 启动刷新token类型，会判断用户是否还存活
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User currentUser = userService.getByName(s);
        if (currentUser == null){
            throw new UsernameNotFoundException("用户没找到");

        }
        return new UserDetail(currentUser);
    }
}
