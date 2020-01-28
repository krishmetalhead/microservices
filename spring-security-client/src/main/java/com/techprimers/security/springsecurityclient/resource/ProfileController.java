package com.techprimers.security.springsecurityclient.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techprimers.security.springsecurityclient.service.MyService;

@RestController
@RequestMapping(value = "/resource")
public class ProfileController {

	@Autowired
	MyService service;    
	@RequestMapping(value = "/profile", method = RequestMethod.GET)	
	@PreAuthorize("hasAuthority('ROLE_CREATE')")
	public String save() {
		return service.serviceMethod();
	}
}
