package ru.zelmex.marketapp.repository;


import ru.zelmex.marketapp.model.User;

public class UserDao extends BaseDao<User>{
    public UserDao() {
        super(User.class);
    }
}

