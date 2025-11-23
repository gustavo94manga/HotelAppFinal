package com.angel.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.angel.entities.Customer;
import com.angel.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HotelAppUserDetailsService implements UserDetailsService{
	
	private final CustomerRepository customerRepository;
	
	   @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Customer customer = customerRepository.findByEmail(username).orElseThrow(() -> new
	                UsernameNotFoundException("User details not found for the user: " + username));
	        List<GrantedAuthority> authorities = customer.getAuthorities().stream().map(authority -> new
	                        SimpleGrantedAuthority(authority.getRole())).collect(Collectors.toList());
	        return new User(customer.getEmail(), customer.getPwd(), authorities);
	    }

}