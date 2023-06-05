package hamitmizrak.dto;

import lombok.*;

import java.util.Date;

// LOMBOK
@Getter @Setter

abstract public class BaseDto {
    private Long id;
    private Date createdDate;

    // Parametresiz constructor
    public BaseDto() {
        this.createdDate=new Date(System.currentTimeMillis()); // 1 ocak 1970
    }

    public BaseDto(Long id, Date createdDate) {
        this.id = id;
        this.createdDate = createdDate;
    }
}
