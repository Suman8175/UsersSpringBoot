--liquibase formatted SQL

--changeset Suman:1
CREATE TABLE user_table (
    user_id SERIAL primary key  not null ,
    user_name varchar(255),
    user_gender char,
    user_dob date,
    user_address varchar(255)
);


