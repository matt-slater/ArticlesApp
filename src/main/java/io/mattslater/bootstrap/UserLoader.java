package io.mattslater.bootstrap;

import io.mattslater.model.User;
import io.mattslater.repos.UserRepository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class UserLoader implements ApplicationListener<ContextRefreshedEvent> {

	private UserRepository userRepository;
	private Logger logger = Logger.getLogger(UserLoader.class);
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void onApplicationEvent(ContextRefreshedEvent event) {
		User a = new User();
		a.setEmail("matt@example.com");
		a.setFirstName("Matt");
		a.setLastName("Slater");
		a.setPassword("123shaman");
		userRepository.save(a);
		
		logger.info("added " + a.getFirstName());
		
		User b = new User();
		b.setEmail("emma@example.com");
		b.setFirstName("Emma");
		b.setLastName("Kimlin");
		b.setPassword("123shaman");
		userRepository.save(b);
		
		logger.info("added " + b.getFirstName());
		
		
	}

}
