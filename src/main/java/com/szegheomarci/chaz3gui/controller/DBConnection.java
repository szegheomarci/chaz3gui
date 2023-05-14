package com.szegheomarci.chaz3gui.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.sql.*;

@Component
public class DBConnection {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;

    public String getModels() {

        String models=url + " " + user + " " + " " + password;
        try {
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement stmt=connection.createStatement();
            ResultSet resultSet=stmt.executeQuery("SELECT * FROM `models`");

            while (resultSet.next())
                models+=resultSet.getString(2);

            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return models;
    }

    public Connection getConnection() throws SQLException {
        String connUrl = url;
        Connection connection = DriverManager.getConnection(url,user,password);
        return connection;
    }

    public ResultSet queryDB(String sql) {
        ResultSet resultSet=null;
        try {
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement stmt=connection.createStatement();
            resultSet=stmt.executeQuery(sql);
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return resultSet;
    }

}
