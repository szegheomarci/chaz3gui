package com.szegheomarci.chaz3gui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
public class ChartController {

    @Autowired
    private ResultSet2ChartData resultSet2ChartData;

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;

    @RequestMapping("/priceads")
    public String priceads() {

        String result;

/*
        return "var series0UpdData={data: [" +
            "[Date.UTC(2020, 0, 1), 5]," +
            "[Date.UTC(2020, 0, 2), 8]," +
            "[Date.UTC(2020, 0, 3), 3]," +
            "[Date.UTC(2020, 0, 4), 3]," +
            "[Date.UTC(2020, 0, 5), 2]," +
            "[Date.UTC(2020, 0, 6), 11]," +
            "[Date.UTC(2020, 0, 7), 4]," +
            "[Date.UTC(2020, 0, 8), 6]," +
            "[Date.UTC(2020, 0, 9), 2]" +
            "]};" +
            " " +
            "var series1UpdData={data: [" +
            "[Date.UTC(2020, 0, 1), 34]," +
            "[Date.UTC(2020, 0, 2), 65]," +
            "[Date.UTC(2020, 0, 3), 76]," +
            "[Date.UTC(2020, 0, 4), 23]," +
            "[Date.UTC(2020, 0, 5), 43]," +
            "[Date.UTC(2020, 0, 6), 71]," +
            "[Date.UTC(2020, 0, 7), 98]," +
            "[Date.UTC(2020, 0, 8), 33]," +
            "[Date.UTC(2020, 0, 9), 69]" +
            "]};";*/

        String sql="SELECT `weekstart`, ROUND(AVG(ads.PriceEuro),0), COUNT(*) " +
                "FROM `vAdsInWeeks` " +
                "LEFT JOIN ads ON `vAdsInWeeks`.`ads_ID`=`ads`.`id` " +
                "GROUP BY `weekstart` " +
                "ORDER BY `weekstart`;";

        try {
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement stmt=connection.createStatement();
            ResultSet resultSet=stmt.executeQuery(sql);
            result = resultSet2ChartData.dateNumNum(resultSet);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
     }
}
