package com.muyus.muyucloud.service.auth;

import com.muyus.muyucloud.data.mongodb.entity.Account;
import com.muyus.muyucloud.data.mongodb.entity.AccountLocal;
import com.muyus.muyucloud.data.mongodb.entity.AccountRole;
import com.muyus.muyucloud.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * AdminUserDetailService
 *
 * 权限验证中心
 *
 * @author: WangHui
 * @email: muyu@muyus.com
 * @date: 2018/3/3
 */
@Service
public class AdminUserDetailService implements UserDetailsService {
    @Autowired
    AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        System.out.println("=========="+AccountRole.ROLE_ADMIN.toString());

        Set<GrantedAuthority> roles = new HashSet<>();

        AccountLocal accountLocal = accountService.findByPhoneNumber(s);
        if (accountLocal != null){
            Account account = accountService.findById(accountLocal.getAccountId());
            account.getRoles().forEach(accountRole -> roles.add(new SimpleGrantedAuthority(accountRole.toString())));

            return new User(s, accountLocal.getPassword(), roles);
        }

        throw new UsernameNotFoundException("用户名无效");
    }
}
