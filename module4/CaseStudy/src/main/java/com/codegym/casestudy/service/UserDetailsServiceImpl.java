package com.codegym.casestudy.service;

import com.codegym.casestudy.entity.User;
import com.codegym.casestudy.entity.UserRole;
import com.codegym.casestudy.repository.UserRepository;
import com.codegym.casestudy.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(userName); // Phuong thuc lay ra user tu userName
        if (user == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        System.out.println("Found User: " + user);

        // [ROLE_USER, ROLE_ADMIN,..]
        //Lay tat ca cac role cua user truyen vao
        List<UserRole> userRoles = userRoleRepository.findByUser(user); // Lay ra list UserRole tu user nhap vao
// Lay ra list roleName cua user do, xem user do co role gi
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if ( userRoles!= null) {
            for (UserRole userRole : userRoles) {

                GrantedAuthority authority = new SimpleGrantedAuthority(userRole.getRole().getRoleName());
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getUserName(), //
//                org.springframework.security.core.userdetails.
                user.getPassword(), grantList);
//        List<UserRole> userRoles = userRoleRepository.findByUser(user);
//        GrantedAuthority authority = new SimpleGrantedAuthority(userRoles);
//        UserDetails userDetails = (UserDetails)new User(user.getUserName(),
//                user.getPassword(), Arrays.asList(authority));
//

        return userDetails;
    }
}
