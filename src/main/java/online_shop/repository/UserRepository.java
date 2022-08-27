package online_shop.repository;

import online_shop.entity.User.User;

public interface UserRepository {
    void createTable();

    User addUser(User user);

    User findById(int userId);
}