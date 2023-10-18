package com.itfactory;

import java.sql.*;
import java.util.List;

public class UserDatabaseImpl implements UserDatabaseInt {
    Connection con;

    public boolean userExists(int userId) throws SQLException {
        con = DBConnection.createDBConnetion();
        String query = "select count(*) from user_test where id=?";
        try (PreparedStatement pstm = con.prepareStatement(query)) {
            pstm.setInt(1, userId);
            try (ResultSet result = pstm.executeQuery()) {
                if (result.next()) {
                    int count = result.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void createUser(User user) {
        con = DBConnection.createDBConnetion();
        String query = "insert into user_test values(?,?,?,?,?)";
        try {
            if (userExists(user.getId())) {
                System.out.println("Error: User with ID " + user.getId() + " already exists.");
            } else {
                PreparedStatement pstm = con.prepareStatement(query);
                pstm.setInt(1, user.getId());
                pstm.setString(2, user.getNume());
                pstm.setString(3, user.getPrenume());
                pstm.setString(4, user.getEmail());
                pstm.setInt(5, user.getVarsta());
                int cnt = pstm.executeUpdate();
                if (cnt != 0) {
                    System.out.println("User created successfully!");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<User> showAllUsers() {
        con = DBConnection.createDBConnetion();
        String query = "select * from user_test";
        System.out.println("Detalii Useri :");
        System.out.println("--------------------------------------------------");

        System.out.format("%-5s %-5s %-10s %-15s %-10s%n", "ID", "Nume", "Prenume", "Email", "Varsta");


        System.out.println("--------------------------------------------------");

        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                System.out.format("%d\t%s\t%s\t%s\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getInt(5));
                System.out.println("---------------------------------------------");

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public User showUserBasedOnID(int id) {
        con = DBConnection.createDBConnetion();
        String query = "select * from user_test where id=" + id;
        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                System.out.format("%d\t%s\t%s\t%s\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getInt(5));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public void updateUser(int id, String nume, String prenume, String email, int varsta) {
        con = DBConnection.createDBConnetion();
        String query = "update user_test set nume=?, prenume=?, email=?, varsta=? where id=?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, nume);
            pstm.setString(2, prenume);
            pstm.setString(3, email);
            pstm.setInt(4, varsta);
            pstm.setInt(5, id);
            int cnt = pstm.executeUpdate();
            if (cnt != 0)
                System.out.println("Datele utilizatorului updatate cu succes!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void deleteUser(int id) {
        con = DBConnection.createDBConnetion();
        String query = "DELETE FROM user_test WHERE id=?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            int cnt = pstm.executeUpdate();
            if (cnt != 0) {
                System.out.println("Utilizator sters cu succes! ID: " + id);
            } else {
                System.out.println("User-ul with ID " + id + " nu a fost gasit.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
