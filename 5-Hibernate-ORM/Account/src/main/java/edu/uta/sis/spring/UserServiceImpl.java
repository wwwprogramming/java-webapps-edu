package edu.uta.sis.spring;

import edu.uta.sis.spring.tietokanta.UserRepository;
import edu.uta.sis.spring.tietokanta.entiteetit.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hannu Lohtander on 2.4.2016.
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public WwwUser getUser(String username) {
        User u = userRepository.getUser(username);
        return new WwwUser(new Long(u.getId()),u.getUsername(), u.getPassword(),u.getEmail(),u.getRole());
    }

    public WwwUser getUser(Long userId) {
        User u = userRepository.getUser(userId.intValue());
        return new WwwUser(new Long(u.getId()),u.getUsername(), u.getPassword(),u.getEmail(),u.getRole());
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        return getUser(username);
    }

    @Transactional(readOnly = false)
    public void register(WwwUser u) {
        User dbu = new User();
        dbu.setEmail(u.getEmail());
        dbu.setPassword(u.getPassword());
        dbu.setRole(u.getRole());
        dbu.setUsername(u.getUsername());
        userRepository.store(dbu);
    }

    public List<WwwUser> getUsers() {
        List<User> users = userRepository.getUsers();
        ArrayList<WwwUser> wwwUserArrayList = new ArrayList<WwwUser>();
        if (users != null && !users.isEmpty()) {
            for (User u : users) {
                wwwUserArrayList.add(new WwwUser(new Long(u.getId()), u.getUsername(), u.getPassword(), u.getEmail(), u.getRole()));
            }
        }
        return wwwUserArrayList;
    }
}
