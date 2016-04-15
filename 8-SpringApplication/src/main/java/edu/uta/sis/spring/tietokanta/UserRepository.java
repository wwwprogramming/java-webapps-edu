package edu.uta.sis.spring.tietokanta;

import edu.uta.sis.spring.tietokanta.entiteetit.User;

import java.util.List;

/**
 * Created by Hannu Lohtander on 5.4.2016.
 */
public interface UserRepository {

    public User getUser(Integer id);

    public User getUser(String username);

    public List<User> getUsers();

    public void store(User u);

    public void update(User u);

}
