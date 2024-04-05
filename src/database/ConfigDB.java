package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
        static Connection objConnection = null;
        public static Connection openConnection(){
                System.out.println("intentando conectarse");
                try {
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        String url = "jdbc:mysql://br9njbm7oa8xryyqfuog-mysql.services.clever-cloud.com:3306/br9njbm7oa8xryyqfuog";
                        String user = "udjfvjjqjllr4zyu";
                        String password = "u19Y86cI2OHUgRLJDR1X";

                        objConnection = (Connection) DriverManager.getConnection(url, user, password);
                        System.out.println("Conectado perfectamente");
                } catch (SQLException e) {
                        System.out.println("Error:" + e.getMessage());
                } catch (ClassNotFoundException e) {
                        System.out.println("Error:" + e.getMessage());
                }

            return objConnection;
        }
        public static void closeConnection(){
                try {
                        if (objConnection!= null) {
                                objConnection.close();
                                System.out.println("Conexión cerrada correctamente");
                        }
                }catch (SQLException e){
                        System.out.println("Error:" + e.getMessage());
                }
        }


}
