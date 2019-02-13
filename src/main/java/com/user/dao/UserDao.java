package com.user.dao;

import com.user.User;

import java.util.List;

public interface UserDao {

    public User getUser(int id);

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);

    public List<User> getAll();
}
