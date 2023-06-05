package hamitmizrak.sql;

public class Persist_All_Sql {

    /**

     -- Create Database
     CREATE SCHEMA `blog` DEFAULT CHARACTER SET utf8 ;

     -- Database select
     use blog;

     -- Create Table
     CREATE TABLE `blog`.`register` (
     `id` INT NOT NULL AUTO_INCREMENT,
     `username` VARCHAR(150) NULL DEFAULT 'kullanıcı adını girmediniz',
     `surname` VARCHAR(45) NULL,
     `password` VARCHAR(45) NULL,
     `email` VARCHAR(250) NULL,
     `create_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
     PRIMARY KEY (`id`));

     -- ###############################################################################
     -- insert
     insert into blog.register (name,surname,email,password) values ("Hamit44","Mızrak44","hamitmizrak@gmail.com","Hm123456@");

     -- SQL:  non-case sentive
     -- delete
     delete FROM blog.register where id="9";

     -- update
     update  blog.register set name="Hamit55",surname="Mızrak55" where id =1;

     -- ##### SELECT ##########################################################################

     -- Select
     SELECT * FROM blog.register;

     -- Count
     select count(*) from blog.register;

     -- find
     select * from blog.register where id =1;

     -- find sadece name
     select name from blog.register where id = 1;

     -- #### LIKE ###########################################################################
     -- like
     -- name kolonunda p ile başlayan değerleri bul
     select * from blog.register where name like 'H%';

     -- name kolonunda p ile biten değerleri bul
     select * from blog.register where name like '%t';

     -- name kolonunda ikinci harfi a olan
     select * from blog.register where name like '_a%';

     -- name kolonunda hmt geçenolan
     select * from blog.register where name like '[hmt]%';

     -- name ve surname
     select * from blog.register where name like 'H%' or surname like 'm%'
     */
}
