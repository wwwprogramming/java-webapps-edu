package edu.uta.courses.security;

import edu.uta.courses.repository.domain.WwwUser;
import edu.uta.courses.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by me on 10.2.2015.
 */


@Component("wwwUserDetailsService")
public class AuthenticationUserDetailsGetter implements UserDetailsService {

    Logger logger = Logger.getLogger(AuthenticationUserDetailsGetter.class.getName());

    @Autowired
    private UserService userService;

    //required by cglib because I use class based aspect weaving
    protected AuthenticationUserDetailsGetter() {
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        if (logger.isDebugEnabled()) {
            logger.debug("loadUserByUsername");
            logger.debug(username);
        }
        WwwUser user = null;
        try {
            if (userService == null) {
                throw new Exception("Autowired has failed on userService");
            }
            user = userService.getUser(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        throwExceptionIfNotFound(user, username);
        if (logger.isDebugEnabled()) {
            logger.debug("found user ["+ user.getId() +"]");
        }

        return user;
    }

    private void throwExceptionIfNotFound(WwwUser user, String login) {
        if (user == null) {
            throw new UsernameNotFoundException("User with login " + login + "  has not been found.");
        }
    }

}