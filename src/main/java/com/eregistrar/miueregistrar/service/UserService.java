package com.eregistrar.miueregistrar.service;

import com.eregistrar.miueregistrar.model.User;

import java.util.List;

public interface UserService {

    public abstract List<User> getAllUsers();
    public abstract User saveUser(User user);
    public abstract User getUserById(Integer userId);

}
