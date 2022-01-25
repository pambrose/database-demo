DROP TABLE IF EXISTS students;

CREATE TABLE students
(
    id         SERIAL UNIQUE PRIMARY KEY,
    created    TIMESTAMPTZ DEFAULT NOW(),
    first_name TEXT    NOT NULL,
    last_name  TEXT    NOT NULL,
    email      TEXT    NOT NULL UNIQUE,
    grad_year  INTEGER NOT NULL
);

INSERT INTO students (first_name, last_name, email, grad_year)
VALUES ('Bill', 'Wen', 'bwen@gmail.com', 2022);

INSERT INTO students (first_name, last_name, email, grad_year)
VALUES ('Steve', 'Schmidt', 'steve@schmidt.com', 2022);

INSERT INTO students (first_name, last_name, email, grad_year)
VALUES ('Penny', 'Thomas', 'penny@thomas.com', 2022);

INSERT INTO students (first_name, last_name, email, grad_year)
VALUES ('Mary', 'Green', 'mgreen@mac.com', 2021);

INSERT INTO students (first_name, last_name, email, grad_year)
VALUES ('Tim', 'Nguyen', 'tim@ibm.com', 2021);

INSERT INTO students (first_name, last_name, email, grad_year)
VALUES ('Wendy', 'White', 'wwhite@aol.com', 2020);

SELECT *
FROM students;

INSERT INTO students (first_name, last_name)
VALUES ('Joe', 'Bennet');

INSERT INTO students (email, grad_year)
VALUES ('ssmith@gmail.com', 2020);
