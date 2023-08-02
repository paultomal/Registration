SELECT * FROM student_reg_table.registration_tbl;

ALTER TABLE registration_tbl
    CHANGE COLUMN firstname firstName varchar(50);

ALTER TABLE registration_tbl
    CHANGE COLUMN lastname lastName varchar(50);

insert into student_reg_table.registration_tbl values (3,"Mohakhali ,Dhaka","+8801521559190","1999-08-15","imam@gmail.com","Imam","Biplob","Bangladeshi","3.5","3.4" )