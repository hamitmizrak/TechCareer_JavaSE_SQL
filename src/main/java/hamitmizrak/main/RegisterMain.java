package hamitmizrak.main;

import hamitmizrak.controller.RegisterControllerImpl;
import hamitmizrak.dto.RegisterDto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
// Create SCANNER
// Find Optional
// RegisterDto BaseDto
// instance Look !!!

public class RegisterMain {

    // Scanner user data
    private static int userData() {
        Scanner klavye = new Scanner(System.in);
        System.out.println("\n### Lütfen seçim yapınız. ###");
        //ENUM
        System.out.println("1-) CREATE \n2-) LIST\n3-) UPDATE\n4-) DELETE\n5-) ÇIKIŞ");
        int chooise = klavye.nextInt();
        return chooise;
    }

    // method Chooise
    private static void methodChooise() throws SQLException, ClassNotFoundException {
        RegisterControllerImpl registerController=new RegisterControllerImpl();
        // sonsuz döngü => for(;;){}
        while (true) {
            int userData = userData();
            switch (userData) {
                case 1:
                    System.out.println("CREATE");
                    // SCANNER
                    RegisterDto registerDto = RegisterDto.builder()
                            .name("adı44")
                            .surname("soyadı44")
                            .email("email44")
                            .password("password44")
                            .build();
                    registerController.create(registerDto);

                    break;

                case 2:
                    System.out.println("LIST");
                    ArrayList<RegisterDto> list=  registerController.list();
                    list.forEach((temp)->{
                        System.out.println(temp);
                    });
                    break;

                case 3:
                    System.out.println("UPDATE");
                    RegisterDto registerUpdateDto = new RegisterDto();
                    registerUpdateDto.setId(1L);
                    // DATABASE FIND
                    // BaseDto
                    // CommandLineRunner
                    registerUpdateDto.setName("adı23");
                    registerUpdateDto.setSurname("surname23");
                    registerUpdateDto.setEmail("email23");
                    registerUpdateDto.setPassword("password23");
                    registerController.update(registerUpdateDto);
                    break;

                case 4:
                    System.out.println("DELETE");
                    RegisterDto registerDeleteDto = new RegisterDto();
                    registerDeleteDto.setId(1L);
                    registerController.delete(registerDeleteDto);
                    break;

                case 5:
                    System.out.println("ÇIKIŞ");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lütfen size belirtilen aralıkta tuşa basınız");
                    break;
            } //end switch
        } //end while
    } //end methodChooise


    // psvm
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        methodChooise();
    }
}
