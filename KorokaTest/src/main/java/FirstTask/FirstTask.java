package FirstTask;

import java.sql.*;

public class FirstTask {
    public static void main(String[] args) {
        final String driverName = "com.mysql.jdbc.Driver";
        final String connectionString = "jdbc:mysql://localhost:3306/koroka";
        final String login = "root";
        final String password = "root";
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(driverName);
        }
        catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }

        try{
            connection = DriverManager.getConnection(connectionString, login, password);
            statement = connection.createStatement();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

        String sqlQuery = "SELECT AVG(`students`.`marks`) as `marksaverage` from `students` where `students`.`marks` >= 40";
        try {
            ResultSet rs = statement.executeQuery(sqlQuery);
            while(rs.next()){
                System.out.println("Marks average - " + rs.getDouble(1));
            }
            rs.close();
        }
        catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
    }
}
