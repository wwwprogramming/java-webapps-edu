package edu.uta.sis.calendars.domain.service.impl;

import edu.uta.sis.calendars.data.entities.UserEntity;
import edu.uta.sis.calendars.data.repository.UserRepository;
import edu.uta.sis.calendars.domain.data.WwwUser;
import edu.uta.sis.calendars.domain.service.UserService;
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
        UserEntity u = userRepository.getUser(username);
        return new WwwUser(new Long(u.getId()),u.getUsername(), u.getPassword(),u.getEmail(), u.getFullName(),u.getRole(), u.getCreated());
    }

    public WwwUser getUser(Long userId) {
        UserEntity u = userRepository.getUser(userId.intValue());
        return new WwwUser(new Long(u.getId()),u.getUsername(), u.getPassword(),u.getEmail(), u.getFullName(), u.getRole(),u.getCreated());
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        return getUser(username);
    }

    @Transactional(readOnly = false)
    public void register(WwwUser u) {
        UserEntity dbu = new UserEntity();
        dbu.setEmail(u.getEmail());
        dbu.setPassword(u.getPassword());
        dbu.setRole(u.getRole());
        dbu.setUsername(u.getUsername());
        dbu.setFullName(u.getFullName());
        userRepository.store(dbu);
        u.setId(dbu.getId().longValue());
    }

    public List<WwwUser> getUsers() {
        List<UserEntity> userEntities = userRepository.getUsers();
        ArrayList<WwwUser> wwwUserArrayList = new ArrayList<WwwUser>();
        if (userEntities != null && !userEntities.isEmpty()) {
            for (UserEntity u : userEntities) {
                wwwUserArrayList.add(new WwwUser(new Long(u.getId()), u.getUsername(), u.getPassword(), u.getEmail(), u.getFullName(), u.getRole()));
            }
        }
        return wwwUserArrayList;
    }

    public void remove(Long id) {
        userRepository.remove(id.intValue());
    }
}
