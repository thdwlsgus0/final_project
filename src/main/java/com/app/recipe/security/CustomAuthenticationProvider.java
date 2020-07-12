package com.app.recipe.security;

import javax.inject.Inject;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Inject
    private CustomDetailService userDeSer;
	@Inject
	private BCryptPasswordEncoder encoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        
        CustomUserDetails user = (CustomUserDetails) userDeSer.loadUserByUsername(username);
        
        boolean match = encoder.matches(password, user.getPassword());
        System.out.println(">>>>>>match:"+match);
        
        if(user.isAuthlogin()) {
        	username = user.getUsername();
        	password = user.getPassword();
        }
        else if(!match) throw new BadCredentialsException(username);
        
        if(!user.isEnabled()) throw new BadCredentialsException(username);
        
        return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
}
