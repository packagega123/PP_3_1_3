package ru.kata.spring.boot_security.demo.security;

import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.UserRepository;


@Service
@Transactional
public class UserDetailsServiceSecurity implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceSecurity(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = findByUsername(email);
        System.out.println(user.getRoles());
        if (null == user) {
            throw new UsernameNotFoundException(String.format("User %s not found", email));
        }

        return user;
    }
}
