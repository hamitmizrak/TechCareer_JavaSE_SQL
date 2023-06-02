package hamitmizrak.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// LOMBOK
@Data
@AllArgsConstructor
abstract public class BaseDto {
    private Long id;
    private Date createdDate;

    // Parametresiz constructor
    public BaseDto() {
        this.createdDate=new Date(System.currentTimeMillis()); // 1 ocak 1970
    }
}
