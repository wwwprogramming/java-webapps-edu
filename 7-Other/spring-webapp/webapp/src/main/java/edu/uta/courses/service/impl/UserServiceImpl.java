package edu.uta.courses.service.impl;

import edu.uta.courses.repository.PersonRepository;
import edu.uta.courses.repository.domain.User;
import edu.uta.courses.repository.domain.WwwUser;
import edu.uta.courses.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by me on 10.2.2015.
 */
@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    Logger log = Logger.getLogger(UserServiceImpl.class.getName());

    @Autowired
    PersonRepository personRepository;


    @Override
    public WwwUser getUser(String username) {
        User u = personRepository.findByUsername(username);
        return new WwwUser(u);
    }

    @Override
    public WwwUser getUser(Long userId) {
        User u = personRepository.findById(userId);
        return new WwwUser(u);
    }



}

