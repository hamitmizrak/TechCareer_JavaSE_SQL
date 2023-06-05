package hamitmizrak.main;

import hamitmizrak.controller.RegisterControllerImpl;
import hamitmizrak.dto.RegisterDto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Find Optional
public class RegisterMain {

    // Constructor Speed Data
    public RegisterMain() throws SQLException, ClassNotFoundException {
        RegisterControllerImpl registerController = new RegisterControllerImpl();
        for (int i = 0; i <=5 ; i++) {
            RegisterDto registerDto = new RegisterDto();
            registerDto.setName("name"+i);
            registerDto.setSurname("surname"+i);
            registerDto.setEmail("email+i");
            registerDto.setPassword("password+i");
            registerController.create(registerDto);
            System.out.printf("%20s%n ",registerDto);
        }
    }

    // METHOD
    // Scanner user data
    private static int userData() {
        Scanner klavye = new Scanner(System.in);
        System.out.println("\n### Lütfen seçim yapınız. ###");
        //ENUM
        System.out.println("1-) CREATE \n2-) LIST\n3-) FIND\n4-) UPDATE\n5-) DELETE\n6-) ÇIKIŞ");
        int chooise = klavye.nextInt();
        return chooise;
    }

    // CREATE
    private static RegisterDto create() throws SQLException, ClassNotFoundException {
        System.out.println("CREATE");
        RegisterControllerImpl registerController = new RegisterControllerImpl();
        Scanner klavye = new Scanner(System.in);
        String name, surname, email, password;
        // SCANNER
        System.out.println("Adınızı Giriniz");
        name = klavye.nextLine();
        System.out.println("Soyadınız Giriniz");
        surname = klavye.nextLine();
        System.out.println("Email Giriniz");
        email = klavye.nextLine();
        System.out.println("Password Giriniz");
        password = klavye.nextLine();
        RegisterDto registerDto = new RegisterDto();
        registerDto.setName(name);
        registerDto.setSurname(surname);
        registerDto.setEmail(email);
        registerDto.setPassword(password);
        registerController.create(registerDto);
        return registerDto;
    }

    // LIST
    private static List<RegisterDto> list() {
        RegisterControllerImpl registerController = new RegisterControllerImpl();
        System.out.println("LIST");
        ArrayList<RegisterDto> list = registerController.list();
        list.forEach((temp) -> {
            //System.out.println(temp);
            // s d f
            System.out.printf("%d, %20s, %20s, %20s, %20s, %20s ",temp.getId(),temp.getName(), temp.getSurname(), temp.getEmail(),temp.getPassword(), temp.getCreatedDate());
            System.out.println();
            //System.out.printf("%d, %15s, %15s, %15s, %15s, %15s%n ",temp.getId(),temp.getName(), temp.getSurname(), temp.getEmail(),temp.getPassword(), temp.getCreatedDate());
        });
        return list;
    }

    // FIND
    private static RegisterDto findById(){
        System.out.println("FIND");
        RegisterControllerImpl registerController = new RegisterControllerImpl();
        Scanner klavye = new Scanner(System.in);
        RegisterDto registerDeleteDto = new RegisterDto();
        System.out.println("Lütfen Objeyi bulmak  id yazınız.");
        registerDeleteDto.setId(klavye.nextLong());
        RegisterDto registerDto=  registerController.findById(registerDeleteDto.getId());
        System.out.println(registerDto);
        return registerDto;
    }

    // UPDATE
    private static RegisterDto update() {
        System.out.println("UPDATE");
        RegisterControllerImpl registerController = new RegisterControllerImpl();
        Scanner klavye = new Scanner(System.in);

        // DATABASE FIND
        // BaseDto
        // CommandLineRunner
        String name, surname, email, password;
        Long id;
        // SCANNER
        System.out.println("id Giriniz");
        id = klavye.nextLong();
        klavye.nextLine();
        System.out.println("Adınızı Giriniz");
        name = klavye.nextLine();
        System.out.println("Soyadınız Giriniz");
        surname = klavye.nextLine();
        System.out.println("Email Giriniz");
        email = klavye.nextLine();
        System.out.println("Password Giriniz");
        password = klavye.nextLine();
        RegisterDto registerUpdateDto = RegisterDto.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .build();
        registerUpdateDto.setId(id);
        registerController.update(registerUpdateDto);
        return registerUpdateDto;
    }

    // DELETE
    private static void delete() {
        System.out.println("DELETE");
        RegisterControllerImpl registerController = new RegisterControllerImpl();
        Scanner klavye = new Scanner(System.in);
        RegisterDto registerDeleteDto = new RegisterDto();
        System.out.println("Lütfen silmek istediğiniz id yazınız.");
        registerDeleteDto.setId(klavye.nextLong());
        registerController.delete(registerDeleteDto);
    }

    // LOGOUT
    private static void logout() {
        System.out.println("ÇIKIŞ");
        System.exit(0);
    }


    // method Chooise
    private static void methodChooise() throws SQLException, ClassNotFoundException {
        // Speed Data
        RegisterMain registerMain=new RegisterMain();
        // sonsuz döngü => for(;;){}
        while (true) {
            int userData = userData();
            switch (userData) {
                case 1:
                    create();
                    break;
                case 2:
                    list();
                    break;
                case 3:
                    list();
                    findById();
                    break;
                case 4:
                    list();
                    update();
                    break;
                case 5:
                    list();
                    delete();
                    break;
                case 6:
                    logout();
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
    } //end PSVM

} //end class
