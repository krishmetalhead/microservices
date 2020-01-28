package io.javabrains.auth.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.javabrains.auth.server.models.AuthUserDetail;
import io.javabrains.auth.server.models.Permission;
import io.javabrains.auth.server.models.Role;
import io.javabrains.auth.server.models.User;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        /*Optional<User> optionalUser = userDetailRepository.findByUsername(name);

        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username or password wrong"));

        UserDetails userDetails = new AuthUserDetail(optionalUser.get());
        new AccountStatusUserDetailsChecker().check(userDetails);*/
    	
    	//In case to test with without database
    	User user = new User();
    	user.setAccountNonExpired(true);
    	user.setAccountNonLocked(true);
    	user.setCredentialsNonExpired(true);
    	user.setEmail("krish.bhowmick@cognizant.com");
    	user.setId(1);
    	user.setPassword("password");
    	user.setUsername("user");
    	List<Role> roles = new ArrayList<Role>();
    	Role role = new Role();
    	role.setId(1);
    	role.setName("ROLE_CREATE");
    	List<Permission> permissions = new ArrayList<Permission>();
    	Permission per = new Permission();
    	per.setId(1);
    	per.setName("ROLE_CREATE_USER");
    	permissions.add(per);
    	role.setPermissions(permissions);
    	roles.add(role);
    	user.setRoles(roles);
    	user.setRoles(roles);
    	UserDetails userDetails = new AuthUserDetail(user);    	
        return userDetails;


    }
}