package edu.uta.courses.service;

import edu.uta.courses.repository.domain.WwwUser;

/**
 * Created by me on 10.2.2015.
 */
public interface UserService {

    public WwwUser getUser(String username);

    public WwwUser getUser(Long userId);



}
