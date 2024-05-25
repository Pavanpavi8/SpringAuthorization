package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Model.MyUser;
import com.example.demo.Model.MyUserRepo;

@Service
public class MyUserService implements UserDetailsService {
	@Autowired
	MyUserRepo userRepo;
	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<MyUser>user = userRepo.findByName(username);
		if(user.isPresent()) {
			var obj = user.get();
			return User.builder()
					.username(obj.getName())
					.password(encoder.encode(obj.getPassword()))
					.roles(getRole(obj))
					.build();
		}
		else {
			throw new UsernameNotFoundException(username + "NOT FOUND !!!");
		}
	}

	private String[] getRole(MyUser obj) {
		return obj.getRole().split(",");
	}

}
