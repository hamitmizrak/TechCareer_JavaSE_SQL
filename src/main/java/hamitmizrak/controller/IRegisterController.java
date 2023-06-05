package hamitmizrak.controller;

import hamitmizrak.dto.RegisterDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IRegisterController {

    // CREATE
    public void create(RegisterDto registerDto) throws SQLException, ClassNotFoundException;

    // UPDATE
    public void update(RegisterDto registerDto);

    // DELETE
    public void delete(RegisterDto registerDto);

    // LIST
    public ArrayList<RegisterDto> list();
}
