import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class main {
    public static void main(String [] args) throws SQLException{
    Connection connection = DriverManager.getConnection("jdbc:h2:./target/manydb;AUTO_SERVER=true", "postgres", "postgres");

    }
}
