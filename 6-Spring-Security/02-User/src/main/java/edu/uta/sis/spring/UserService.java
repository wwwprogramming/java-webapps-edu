package edu.uta.sis.spring;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by me on 10.2.2015.
 */
public interface UserService extends UserDetailsService {

    public WwwUser getUser(String username);

    public WwwUser getUser(Long userId);

    public UserDetails loadUserByUsername(String username);

}
