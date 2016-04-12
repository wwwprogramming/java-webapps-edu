package edu.uta.sis.spring.service;


import edu.uta.sis.spring.web.WwwUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Created by me on 10.2.2015.
 */
public interface UserService extends UserDetailsService {

    public WwwUser getUser(String username);

    public WwwUser getUser(Long userId);

    public UserDetails loadUserByUsername(String username);

    public void register(WwwUser u);

    public List<WwwUser> getUsers();
}
