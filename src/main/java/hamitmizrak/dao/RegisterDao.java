package hamitmizrak.dao;

import hamitmizrak.dto.RegisterDto;
import hamitmizrak.exception.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// LOMBOK
@Log4j2
public class RegisterDao implements IDaoConnection<RegisterDto> {

    // CREATE
    @Override
    public void create(RegisterDto registerDto) throws SQLException, ClassNotFoundException {
        try (Connection connection = getInterfaceConnection()) {
           // if(connection!=null){}
            //Connection Transaction Öncelikle kapatmak
            connection.setAutoCommit(false);

            // insert into blog.register (name,surname,email,password) values ("name44","surname44","email44@gmail.com","password44");
            String sql = "insert into blog.register (name,surname,email,password) values (?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, registerDto.getName());
            preparedStatement.setString(2, registerDto.getSurname());
            preparedStatement.setString(3, registerDto.getEmail());
            preparedStatement.setString(4, registerDto.getPassword());
            // EKLEME , TRANSACTION (Create, Delete,Update)
            int rowsEffected = preparedStatement.executeUpdate();
            if(rowsEffected>0){
                log.info(RegisterDto.class+" Ekleme Başarılı");
                // transaction işlemi başarılıysa, işlem devam etsin
                connection.commit();
            }else{
                log.info(RegisterDto.class+" Başarısız Ekleme");
                // transaction işlemi başarısızsa, işlem devam etmesinnn
                connection.rollback();
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    // LIST
    @Override
    public ArrayList<RegisterDto> list() {
        // Liste
        ArrayList<RegisterDto> registerDtoList=new ArrayList<>();
        // Dto
        RegisterDto registerDto;
        try (Connection connection = getInterfaceConnection()) {
            // Select
            String sql = "select * from blog.register";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // SİLME , TRANSACTION (Create, Delete,Update)
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                registerDto=new RegisterDto();
                registerDto.setId(resultSet.getLong("id"));
                registerDto.setName(resultSet.getString("name"));
                registerDto.setSurname(resultSet.getString("surname"));
                registerDto.setEmail(resultSet.getString("email"));
                registerDto.setPassword(resultSet.getString("password"));
                registerDtoList.add(registerDto);
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return registerDtoList;
    }

    @Override
    public RegisterDto findById(Long id) {
        // Dto
        RegisterDto registerDto=registerDto=new RegisterDto();
        try (Connection connection = getInterfaceConnection()) {
            // Select
            String sql = "select * from blog.register where id="+id;
            //String sql = "select * from blog.register where id=?";
            //String sql = "select * from blog.register where id=:id ";
            System.out.println(sql);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setInt(1, id);
            // SİLME , TRANSACTION (Create, Delete,Update)
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                registerDto.setId(resultSet.getLong("id"));
                registerDto.setName(resultSet.getString("name"));
                registerDto.setSurname(resultSet.getString("surname"));
                registerDto.setEmail(resultSet.getString("email"));
                registerDto.setPassword(resultSet.getString("password"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        if(registerDto.getId()==null){
            throw new ResourceNotFoundException(id+" Bulunamadı");
        }
        return registerDto;
    }

    // UPDATE
    @Override
    public void update(RegisterDto registerDto) {
        try (Connection connection = getInterfaceConnection()) {
            //Connection Transaction Öncelikle kapatmak
            connection.setAutoCommit(false);
            // update  blog.register set name=?,surname=?,email=?,password=? where id=?;
            String sql = "update blog.register set name=?,surname=?,email=?,password=? where id=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, registerDto.getName());
            preparedStatement.setString(2, registerDto.getSurname());
            preparedStatement.setString(3, registerDto.getEmail());
            preparedStatement.setString(4, registerDto.getPassword());
            preparedStatement.setLong(5, registerDto.getId());
            // GÜNCELLEME , TRANSACTION (Create, Delete,Update)
            int rowsEffected = preparedStatement.executeUpdate();
            if(rowsEffected>0){
                log.info(RegisterDto.class+" Güncelleme Başarılı");
                // transaction işlemi başarılıysa, işlem devam etsin
                connection.commit();
            }else{
                log.info(RegisterDto.class+" Güncelleme Ekleme");
                // transaction işlemi başarısızsa, işlem devam etmesinnn
                connection.rollback();
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // DELETE
    @Override
    public void delete(RegisterDto registerDto) {
        try (Connection connection = getInterfaceConnection()) {
            //Connection Transaction Öncelikle kapatmak
            connection.setAutoCommit(false);
            // delete from  blog.register  where id=?;
            String sql = "delete from  blog.register  where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, registerDto.getId());
            // SİLME , TRANSACTION (Create, Delete,Update)
            int rowsEffected = preparedStatement.executeUpdate();
            if(rowsEffected>0){
                log.info(RegisterDto.class+" Silme Başarılı");
                // transaction işlemi başarılıysa, işlem devam etsin
                connection.commit();
            }else{
                log.info(RegisterDto.class+" Silme Ekleme");
                // transaction işlemi başarısızsa, işlem devam etmesinnn
                connection.rollback();
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}//end class
