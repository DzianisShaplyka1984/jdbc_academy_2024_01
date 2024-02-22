create table employee
(
    id     int          not null primary key auto_increment,
    name   varchar(256) not null,
    salary int,
    year   int,
    job    varchar(256)
);

create table department
(
    id   int          not null primary key auto_increment,
    name varchar(256) not null
);

create table address
(
    id          int not null primary key auto_increment,
    street      varchar(256),
    city        varchar(256),
    appartment  varchar(256),
    employee_id int,
    CONSTRAINT FK_ADDRESS_EMPLOYEE FOREIGN KEY (employee_id) REFERENCES employee (id)
);