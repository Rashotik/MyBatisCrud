create schema if not exists test_schema;
create table if not exists country(id int primary key , name varchar(20));
CREATE SEQUENCE if not exists country_seq
    START WITH 1
    INCREMENT BY 1;

create table if not exists city(`id` int primary key , `name` varchar(20), `country_id` int);
CREATE SEQUENCE if not exists city_seq
    START WITH 1
    INCREMENT BY 1;

create table if not exists street(id int primary key , name varchar(20), city_id int);
CREATE SEQUENCE if not exists street_seq
    START WITH 1
    INCREMENT BY 1;

ALTER TABLE street ADD UNIQUE (`name`, `city_id`);

INSERT INTO country(id, name) VALUES ( nextval('country_seq'), 'Russia' ), (nextval('country_seq'), 'USA');
INSERT INTO city(id, name, country_id) VALUES ( nextval('city_seq'), 'Moscow', 1 ), (nextval('city_seq'), 'New-York', 2), (nextval('city_seq'), 'Novgorod', 1);
INSERT INTO street(id, name, city_id) VALUES ( nextval('street_seq'), 'Stepnaya', 1), (nextval('street_seq'), 'Sovetskaya', 2);