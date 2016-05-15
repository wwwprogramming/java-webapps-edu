package edu.uta.sis.calendars.domain.service;

import edu.uta.sis.calendars.domain.data.WwwUser;
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

    public void remove(Long id);

    public WwwUser update(Long id, String name, String email, String pw);

    public void disable(Long id);
}
