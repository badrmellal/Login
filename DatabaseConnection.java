package workLoad;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {
    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();
 
    }
 }

        /*
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT Name, age FROM employee WHERE ID = 1");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("Name") + " " + resultSet.getInt("age"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
*/