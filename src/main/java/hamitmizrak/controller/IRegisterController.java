package hamitmizrak.controller;

import hamitmizrak.dto.RegisterDto;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IRegisterController {

    // CREATE
    public void create(RegisterDto registerDto) throws SQLException, ClassNotFoundException;

    // LIST
    public ArrayList<RegisterDto> list();

    public RegisterDto findById(Long id);

    // UPDATE
    public void update(RegisterDto registerDto);

    // DELETE
    public void delete(RegisterDto registerDto);

} //end interface
