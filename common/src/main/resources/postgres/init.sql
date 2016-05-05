CREATE SEQUENCE generate_id;

CREATE TABLE groups
(
  id BIGINT PRIMARY KEY DEFAULT  nextval('generate_id'),
  group_number INTEGER NOT NULL UNIQUE,
  faculty_name VARCHAR(20) NOT NULL
);

CREATE TABLE students
(
  id BIGINT PRIMARY KEY DEFAULT nextval('generate_id'),
  first_name VARCHAR(20) NOT NULL,
  last_name VARCHAR(20) NOT NULL,
  age INTEGER NOT NULL,
  group_id INTEGER NOT NULL REFERENCES groups(id)
);