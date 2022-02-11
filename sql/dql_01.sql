-- Items to select

SELECT *
FROM students;

SELECT *, *
FROM students;

SELECT first_name, last_name, email
FROM students;

SELECT first_name || ' ' || last_name AS full_name, first_name, last_name, email
FROM students;

SELECT 'Hello', 'World'
FROM students;

SELECT 'Hello' as greeting, *
FROM students;


-- Filtering which rows to select

SELECT *
FROM students
WHERE first_name = 'John';

SELECT *
FROM students
WHERE last_name LIKE '%on%';

SELECT *
FROM students
WHERE id <= 3;

SELECT *
FROM students
WHERE grad_year = 2022;

SELECT *
FROM students
WHERE grad_year = 2022
  AND id <= 2;

SELECT *
FROM students
WHERE id BETWEEN 3 AND 5;

SELECT *
FROM students
WHERE id IN (1, 2, 3);

SELECT *
FROM students
WHERE id IN (SELECT id FROM students WHERE grad_year = 2022);


-- Order of rows

SELECT *
FROM students
ORDER BY last_name;

SELECT *
FROM students
ORDER BY last_name DESC;

SELECT *
FROM students
ORDER BY grad_year DESC, last_name;

-- How many rows to select

SELECT *
FROM students
LIMIT 3;

SELECT *
FROM students
OFFSET 2;

SELECT *
FROM students
ORDER BY id
LIMIT 3 OFFSET 2;

-- Aggregates

SELECT count(*)
FROM students;

SELECT count(*), max(grad_year), min(grad_year), avg(grad_year), sum(grad_year)
FROM students;

SELECT grad_year, count(grad_year), sum(grad_year), avg(grad_year)
FROM students
GROUP BY grad_year;

SELECT grad_year, count(grad_year), sum(grad_year), avg(grad_year)
FROM students
GROUP BY grad_year
HAVING sum(grad_year) > 2500;

SELECT DISTINCT grad_year
FROM students;
