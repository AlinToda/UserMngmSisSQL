package com.itfactory;

import java.sql.SQLException;
import java.util.List;

public interface UserDatabaseInt {
    public void createUser(User user) throws SQLException;

    public List<User> showAllUsers();

    public User showUserBasedOnID(int id);

    public void updateUser(int id, String nume, String prenume, String email, int varsta);

    public void deleteUser(int id);
}