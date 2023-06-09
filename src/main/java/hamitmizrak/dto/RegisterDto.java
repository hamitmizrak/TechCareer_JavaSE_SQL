package hamitmizrak.dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import java.util.Date;

// LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class RegisterDto extends BaseDto{ //extends BaseDto
    //Field
    private String name;
    private String surname;
    private String email;
    private String password;

    // Constructor (Super, this)
    public RegisterDto(Long id, Date createdDate) {
        super(id, createdDate);
    }

    public RegisterDto(Long id, Date createdDate, String name, String surname, String email, String password) {
        super(id, createdDate);
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
} //end class
