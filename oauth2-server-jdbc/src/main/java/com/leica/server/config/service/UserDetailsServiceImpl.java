package com.leica.server.config.service;

import com.leica.server.entity.TbUser;
import com.leica.server.repository.TbUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * SpringSecurity认证授权业务
 *
 * @author leica
 * @since 2019/6/6 1:10
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private TbUserRepository tbUserRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        TbUser tbUser = tbUserRepository.findTbUserByUsername(s);
        if (tbUser == null) {
            return null;
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        tbUser.getTbRoles().forEach(tbRole -> {
            tbRole.getTbPermissions().forEach(tbPermission -> {
                authorities.add(new SimpleGrantedAuthority(tbPermission.getEnname()));
            });
        });
        return new User(tbUser.getUsername(),tbUser.getPassword(),authorities);
    }
}
