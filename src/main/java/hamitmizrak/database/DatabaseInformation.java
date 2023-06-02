package hamitmizrak.database;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// LOMBOK
@Data
@Builder
abstract public class DatabaseInformation {
    private String url;
    private String user;
    private String password;
    private String forNameData;

    // parametresiz constructor
    public DatabaseInformation() {
        // MYSQL
        this.url = "jdbc:mysql://localhost:3306/blog";
        this.user = "root";
        this.password = "root";
        this.forNameData = "com.mysql.jdbc.Driver";

        //POSTGRESQL
        /*this.url="jdbc:postgresql://localhost:5432/blog";
        this.user="root";
        this.password="root";
        this.forNameData="org.postgresql.Driver";*/

        //H2DB
       /* this.url="jdbc:h2:file./memory_persist/blog";
        this.user="root";
        this.password="root";
        this.forNameData="org.h2.Driver";*/
    }

    // parametreli constructor
    public DatabaseInformation(String url, String userName, String userPassword, String forNameData) {
        this.url = url;
        this.user = userName;
        this.password = userPassword;
        this.forNameData = forNameData;
    }
} //end class
