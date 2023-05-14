package com.szegheomarci.chaz3gui.controller;

import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ResultSet2ChartData {

    public String dateNumNum(ResultSet resultSet) {
        int month;
        StringBuilder result = new StringBuilder("var series0UpdData={data: [");
        StringBuilder result2 = new StringBuilder("var series1UpdData={data: [");
        String comma="";
        try {
            while (resultSet.next()) {
                result.append(comma);
                result2.append(comma);
                result.append("[Date.UTC(");
                result2.append("[Date.UTC(");
                result.append(resultSet.getString(1), 0, 4);
                result2.append(resultSet.getString(1), 0, 4);
                result.append(", ");
                result2.append(", ");
                month=Integer.parseInt(resultSet.getString(1).substring(5,7)) - 1;
                result.append(Integer.toString(month));
                result2.append(Integer.toString(month));
                result.append(", ");
                result2.append(", ");
                result.append(resultSet.getString(1), 8, 10);
                result2.append(resultSet.getString(1), 8, 10);
                result.append("), ");
                result2.append("), ");
                result.append(resultSet.getString(2));
                result2.append(resultSet.getString(3));
                result.append("]");
                result2.append("]");
                comma=", ";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result.append("]}; ");
        result2.append("]};");

        result.append(result2.toString());

        return result.toString();
    }
}
