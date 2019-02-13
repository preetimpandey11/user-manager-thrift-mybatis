package com.user.dao;

import com.user.SessionFactory;
import com.user.User;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {


    public User getUser(int id) {
        try (SqlSession sqlSession = SessionFactory.getInstance().openSession()) {
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            return mapper.getUser(id);
        }
    }

    public void addUser(User user) {
        try (SqlSession sqlSession = SessionFactory.getInstance().openSession()) {
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            mapper.addUser(user);
            sqlSession.commit();
        }
    }

    @Override
    public void updateUser(User user) {
        try (SqlSession sqlSession = SessionFactory.getInstance().openSession()) {
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            mapper.updateUser(user);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteUser(int id) {
        try (SqlSession sqlSession = SessionFactory.getInstance().openSession()) {
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            mapper.deleteUser(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        try (SqlSession sqlSession = SessionFactory.getInstance().openSession()) {
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            list = mapper.getAll();
        }
        return list;
    }

}
