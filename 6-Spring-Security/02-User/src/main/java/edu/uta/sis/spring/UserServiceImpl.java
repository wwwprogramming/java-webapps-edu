package edu.uta.sis.spring;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by Hannu Lohtander on 2.4.2016.
 */

public class UserServiceImpl implements UserService {


    public WwwUser getUser(String username) {
        return new WwwUser(new Long(1), username, "rosebud");
    }

    public WwwUser getUser(Long userId) {
        return new WwwUser(new Long(1), "username", "rosebud");
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        WwwUser user = null;
        user = getUser(username);
        return user;
    }

}
