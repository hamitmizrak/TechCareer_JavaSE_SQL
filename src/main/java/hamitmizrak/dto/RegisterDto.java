package hamitmizrak.dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.util.Date;

// LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class RegisterDto { //extends BaseDto
    //Field
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Date createdDate=new Date(System.currentTimeMillis());

} //end class
