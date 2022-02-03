-- Insert

-- Update

UPDATE students
SET grad_year = grad_year + 100;

SELECT *
FROM students;

UPDATE students
SET grad_year  = grad_year - 200,
    first_name = 'John';

UPDATE students
SET last_name = 'Smith'
WHERE last_name = 'Wen';

UPDATE students
SET last_name = 'Smith'
WHERE id = 1;

UPDATE students
SET last_name = 'Smith'
WHERE grad_year = 2022;

UPDATE students
SET last_name = 'Smith'
WHERE grad_year = 3022;

-- Delete

DELETE
FROM students;

SELECT *
FROM students;

DELETE
FROM students
WHERE last_name = 'Nguyen';

DELETE
FROM students
WHERE id = 5;

DELETE
FROM students
WHERE grad_year = 2022;

DELETE
FROM students
WHERE last_name = 'Nguyen-Nguyen';


