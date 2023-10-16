package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> usersList() {
        return entityManager.createQuery("SELECT u From User u", User.class).getResultList();
    }


    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void adduser(User user) {
        entityManager.persist(user);
    }


    @Override
    public void delete(long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }


    @Override
    public void update(User user) {
        entityManager.merge(user);
    }
}