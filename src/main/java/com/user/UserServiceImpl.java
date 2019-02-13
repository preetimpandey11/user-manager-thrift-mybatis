package com.user;

import com.user.dao.UserDao;
import com.user.dao.UserDaoImpl;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UserServiceImpl implements UserService.Iface {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User getUser(int id) throws TException {
        logger.info("Getting user...");
        return userDao.getUser(id);
    }

    @Override
    public void addUser(User user) throws TException {
        logger.info("Adding user...");
        userDao.addUser(user);
    }

    @Override
    public List<User> getAll() throws TException {
        logger.info("Getting all users...");
        return userDao.getAll();
    }

    @Override
    public void deleteUser(int id) throws TException {
        logger.info("Deleting user...");
        userDao.deleteUser(id);
    }

    @Override
    public void updateUser(int id, User user) throws TException {
        logger.info("Updating user...");
        userDao.updateUser(user);
    }
}
