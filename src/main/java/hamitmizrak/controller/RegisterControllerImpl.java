package hamitmizrak.controller;

import hamitmizrak.dao.RegisterDao;
import hamitmizrak.dto.RegisterDto;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegisterControllerImpl implements IRegisterController {

    private RegisterDao registerDao=new RegisterDao();


    // CREATE
    @Override
    public void create(RegisterDto registerDto) throws SQLException, ClassNotFoundException {
        registerDao.create(registerDto);
    }

    // LIST
    @Override
    public ArrayList<RegisterDto> list() {
        return registerDao.list();
    }

    // FIND BY ID
    @Override
    public RegisterDto findById(int id) {
        return registerDao.findById(id);
    }

    // UPDATE
    @Override
    public void update(RegisterDto registerDto) {
        registerDao.update(registerDto);
    }

    //DELETE
    @Override
    public void delete(RegisterDto registerDto) {
        registerDao.delete(registerDto);
    }


}
