package com.gricev.web.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DataBaseHandler extends Configs {
    Connection dbConnection;


    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);
        return dbConnection;
    }

    public void signUpUser(RegistrateEntity registrateEntity) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME + "," +
                Const.USERS_EMAIL + "," + Const.USERS_PASSWORD + "," +
                Const.USERS_LOCATION + "," + Const.USERS_SEX + Const.USERS_PHONENUMBER +")" +
                "VALUES(?,?,?,?,?,?,?)";
        PreparedStatement prSt = null;
        try {
            prSt = getDbConnection().prepareStatement(insert);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(1, registrateEntity.getFirstName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(2, registrateEntity.getLastName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(3, registrateEntity.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(4, registrateEntity.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(5, registrateEntity.getCountry());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(6, registrateEntity.getSex());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setLong(7, registrateEntity.getPhoneNumber());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUser(RegistrateEntity registrateEntity)  {
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USERS_EMAIL + "=? AND " + Const.USERS_PASSWORD + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, registrateEntity.getEmail());
            prSt.setString(2, registrateEntity.getPassword());

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }
}