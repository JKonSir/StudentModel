DROP TABLE IF EXISTS students;

DROP TABLE IF EXISTS groups;

DROP SEQUENCE IF EXISTS generate_id;

CREATE SEQUENCE generate_id INCREMENT BY 1
MINVALUE 1 NO MAXVALUE
START WITH 1 NO CYCLE;

CREATE TABLE IF NOT EXISTS groups
(
  id BIGINT PRIMARY KEY DEFAULT  nextval('generate_id'),
  group_number INTEGER NOT NULL UNIQUE,
  faculty_name VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS students
(
  id BIGINT PRIMARY KEY DEFAULT nextval('generate_id'),
  first_name VARCHAR(20) NOT NULL,
  last_name VARCHAR(20) NOT NULL,
  age INTEGER NOT NULL,
  group_id INTEGER NOT NULL REFERENCES groups(id)
);

INSERT INTO groups(group_number, faculty_name)
    VALUES (1, 'magic');

INSERT INTO groups(group_number, faculty_name)
    VALUES (2, 'might');

INSERT INTO groups(group_number, faculty_name)
    VALUES (3, 'griffindor');

INSERT INTO students(first_name, last_name, age, group_id)
    VALUES ('VASYA', 'VASECHKIN', 22, 1);

INSERT INTO students(first_name, last_name, age, group_id)
    VALUES ('PETYA', 'PETECHKIN', 23, 1);

INSERT INTO students(first_name, last_name, age, group_id)
    VALUES ('MISHA', 'MICHAILOV', 25, 2);

INSERT INTO students(first_name, last_name, age, group_id)
    VALUES ('MASHA', 'VASECHKINA', 24, 3);