package io.mattslater.services;




import io.mattslater.model.CustomUserDetails;
import io.mattslater.model.User;
import io.mattslater.repos.UserRepository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private Logger log = Logger.getLogger(UserDetailsService.class);
	private UserRepository userRepo;
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		userRepo = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		log.info("in user details service");
		User user = userRepo.findByEmail(username);
		if (user == null) {
			log.info("username not found");
			throw new UsernameNotFoundException("Couldn't find user: " + username);
		}
		CustomUserDetails cud = new CustomUserDetails(user);
		log.info("first name from custom user details is:" + cud.getFirstName());
		return cud;
	}
}
