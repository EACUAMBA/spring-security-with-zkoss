package com.eacuamba.spring_security_with_zkoss.domain.service;

import com.eacuamba.spring_security_with_zkoss.domain.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        logger.info("Acessando o banco de dados.");
        return  this.userRepository.findAllUsers().stream().filter(user -> user.getUsername().trim().equalsIgnoreCase(s.trim())).findFirst().orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }
}
