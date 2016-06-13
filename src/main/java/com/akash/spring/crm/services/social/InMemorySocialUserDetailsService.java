package com.akash.spring.crm.services.social;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;

public class InMemorySocialUserDetailsService implements SocialUserDetailsService{

	private Map<String, SocialUser> userMap = new HashMap<>();
	
	private static final Logger log = Logger.getLogger(InMemorySocialUserDetailsService.class);
	
	@Override
	public SocialUserDetails loadUserByUserId(String id) throws UsernameNotFoundException {
		SocialUser user = userMap.get(id);
		
		if (user == null)
			throw new UsernameNotFoundException("The user associated with social ID is not found");
		return user;
	}

	public void addUser(String id) {
		List<GrantedAuthority> authorities = 
				new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_CRM_USER"));
		SocialUser user = new SocialUser(id, null, authorities);
		userMap.put(id, user);
		
		// manually log in
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(id, null, authorities);
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		
		log.debug("Added user with Social ID: " +id);
	}
}
