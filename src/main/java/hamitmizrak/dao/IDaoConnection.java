package hamitmizrak.dao;

import hamitmizrak.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IDaoConnection<T> {

    // CREATE
    public void create(T t) throws SQLException, ClassNotFoundException;

    // LIST
    public ArrayList<T> list();

    // UPDATE
    public T findById(Long id);

    // UPDATE
    public void update(T t);

    // DELETE
    public void delete(T t);


    // Govdeli Connection
    default Connection getInterfaceConnection() throws SQLException, ClassNotFoundException {
        return DatabaseConnection.getInstance().getConnection();
    }

} // end interface
