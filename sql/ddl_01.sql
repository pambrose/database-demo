DROP TABLE IF EXISTS students;

CREATE TABLE students
(
    first_name TEXT,
    last_name  TEXT,
    email      TEXT,
    grad_year  INTEGER
);

INSERT INTO students (first_name, last_name, email, grad_year)
VALUES ('Bill', 'Wen', 'bwen@gmail.com', 2022);

INSERT INTO students
VALUES ('Steve', 'Schmidt', 'steve@schmidt.com', 2022);

INSERT INTO students
VALUES ('Penny', 'Thomas', 'penny@thomas.com', 2022);

INSERT INTO students
VALUES ('Mary', 'Green', 'mgreen@mac.com', 2021);

INSERT INTO students
VALUES ('Tim', 'Nguyen', 'tim@ibm.com', 2021);

INSERT INTO students
VALUES ('Wendy', 'White', 'wwhite@aol.com', 2020);

SELECT *
FROM students;

INSERT INTO students (first_name, last_name)
VALUES ('Joe', 'Bennet');

INSERT INTO students (email, grad_year)
VALUES ('ssmith@gmail.com', 2020);