package hamitmizrak.database;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// LOMBOK
@Log4j2
@Getter @Setter
public class DatabaseConnection extends DatabaseInformation {

    // Connection
    private Connection connection;
    private String url = super.getUrl(); // super keywordu üst atadan veri almak için kullandım
    private String user = super.getUser();
    private String password = super.getPassword();
    private String forNameData = super.getForNameData();

    // Singleton Design Pattern
    // Singleton Class

    private static DatabaseConnection instance;

    // Singleton Constructor: instance oluşturulmaması
    private DatabaseConnection() throws ClassNotFoundException, SQLException {
        try {
            // Database ilgili class erişim sağlamak
            Class.forName("com.mysql.jdbc.Driver");
            log.info("Driver Yüklendi");
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "root", "root");
            connection = DriverManager.getConnection(url, user, password);
            log.info("Database Bağlantısını Başarılı");
        } catch (Exception exception) {
            log.error(DatabaseConnection.class + " Driver or connection Failed !!!!");
            exception.printStackTrace();
        } //end catch
    }//end DatabaseConnection

    // Bu Classı Dış dünyaya bağlayan tek kapı
    public static DatabaseConnection getInstance() throws SQLException, ClassNotFoundException {
        try {
            // eğer bağlantı yoksa veya kapatılmışsa
            if (instance == null || instance.connection.isClosed()) {
                instance = new DatabaseConnection();
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
            log.error(DatabaseConnection.class + " isn't create instance "+sql);
        } catch (Exception exception) {
            exception.printStackTrace();
            log.error(DatabaseConnection.class + " isn't create instance "+exception);
        }
        return instance;
    } // end DatabaseConnection

    // PSVM
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
         DatabaseConnection databaseConnection=new DatabaseConnection();
    }
} //end class
