package edu.uta.sis.calendars.data.repository;

import edu.uta.sis.calendars.data.entities.UserEntity;

import java.util.List;

/**
 * Created by Hannu Lohtander on 5.4.2016.
 */
public interface UserRepository {

    public UserEntity getUser(Integer id);

    public UserEntity getUser(String username);

    public List<UserEntity> getUsers();

    public void store(UserEntity u);

    public void update(UserEntity u);

    public void remove(Integer id);
}
