package edu.uta.courses.repository;

import edu.uta.courses.repository.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by me on 10.2.2015.
 */
@Transactional
public interface PersonRepository {

    public void update(User u);

    public void create(User u);

    public void delete(User u);

    public void archive(User u);



    public User findByUsername(String username);

    public User findByKey(String hashKey);

    public User findById(Long id);


    public List<User> findActiveUsers();

    public List<User> findUsers();

    public Boolean existByUsername(String u);

}