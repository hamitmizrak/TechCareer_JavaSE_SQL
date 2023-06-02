package hamitmizrak.database;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// LOMBOK
@Log4j2
public class DatabaseConnection extends DatabaseInformation {

    // Connection
    private Connection connection;
    private String url = this.getUrl();
    private String user = this.getUser();
    private String password = this.getPassword();
    private String forNameData = this.getForNameData();

    // Singleton Design Pattern
    // Singleton Class
    @Getter @Setter
    private static DatabaseConnection instance;

    // Singleton Constructor: instance oluşturulmaması
    private DatabaseConnection() throws ClassNotFoundException, SQLException {
        try {
            // Database ilgili class erişim sağlamak
            Class.forName(forNameData);
            log.info("Driver Yüklendi");
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
            log.error(DatabaseConnection.class + " isnt create instance");
        } catch (Exception exception) {
            exception.printStackTrace();
            log.error(DatabaseConnection.class + " isnt create instance");
        }
        return instance;
    } // end DatabaseConnection

} //end class
