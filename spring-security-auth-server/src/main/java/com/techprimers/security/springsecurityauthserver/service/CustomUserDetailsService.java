package com.techprimers.security.springsecurityauthserver.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.techprimers.security.springsecurityauthserver.model.CustomUserDetails;
import com.techprimers.security.springsecurityauthserver.model.Role;
import com.techprimers.security.springsecurityauthserver.model.Users;



@Service
public class CustomUserDetailsService implements UserDetailsService {

   /* @Autowired
    private UsersRepository usersRepository;*/

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        /*Optional<Users> usersOptional = usersRepository.findByName(username);

        usersOptional
                .orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
        return usersOptional
                .map(CustomUserDetails::new)
                .get();*/
    	Users user = new Users();
    	user.setActive(1);
    	user.setEmail("krish@gmail.com");
    	user.setId(1);
    	user.setLastName("Bhowmick");
    	user.setName("Krish");
    	user.setPassword("pass");
    	Set<Role> roles = new HashSet<Role>();
    	Role role = new Role();
    	role.setRole("CREATE");
    	role.setRoleId(1);
    	roles.add(role);
    	user.setRoles(roles);    	
    	
    	
    	return new CustomUserDetails(user);    	
    }
}
