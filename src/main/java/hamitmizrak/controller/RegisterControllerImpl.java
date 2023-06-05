package hamitmizrak.controller;

import hamitmizrak.dao.RegisterDao;
import hamitmizrak.dto.RegisterDto;
import hamitmizrak.exception.ResourceNotFoundException;
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
    public RegisterDto findById(Long id) {
        return registerDao.findById(id);
    }

    // UPDATE
    @Override
    public void update(RegisterDto registerDto) {
        RegisterDto findById=findById(registerDto.getId());
        if(findById!=null)
         registerDao.update(registerDto);
        else
            throw new ResourceNotFoundException(registerDto.getId()+" id Bulunamadı");
    }

    //DELETE
    @Override
    public void delete(RegisterDto registerDto) {
        RegisterDto findById=findById(registerDto.getId());
        if(findById!=null)
            registerDao.delete(registerDto);
        else
            throw new ResourceNotFoundException(registerDto.getId()+" id Bulunamadı");
    }
}
