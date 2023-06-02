package hamitmizrak.dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.util.Date;

// LOMBOK
@Getter
@Setter // @Data @ToString

@AllArgsConstructor
@Builder
@Log4j2

public class RegisterDto extends BaseDto {
    //Field
    private String name;
    private String surname;
    private String email;
    private String password;

    // parametresiz constructor
    public RegisterDto() {
    }

    // parametreli constructor
    public RegisterDto(Long id, Date createdDate, String name, String surname, String email, String password) {
        super(id, createdDate);
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    // toString
    @Override
    public String toString() {
        return "RegisterDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                "} " + super.toString();
    }
} //end class
