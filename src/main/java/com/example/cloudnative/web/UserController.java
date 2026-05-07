package com.example.cloudnative.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cloudnative.domain.User;

import reactor.core.publisher.Mono;

@RestController
public class UserController {

	@GetMapping("user1") 
	public Mono<User> getUser1() {
		return ReactiveSecurityContextHolder.getContext()
				.map(SecurityContext::getAuthentication)
				.map(authentication -> (OidcUser) authentication.getPrincipal())
				.map(oidcUser -> new User(
						oidcUser.getPreferredUsername(),
						oidcUser.getGivenName(),
						oidcUser.getFamilyName(),
						oidcUser.getClaimAsStringList("roles")));
	}
	
	@GetMapping("user2") 
	public Mono<User> getUser2(@AuthenticationPrincipal OidcUser oidcUser) {
		var user = new User(
				oidcUser.getPreferredUsername(),
				oidcUser.getGivenName(),
				oidcUser.getFamilyName(),
				oidcUser.getClaimAsStringList("roles"));
		
		return Mono.just(user);
	}

}