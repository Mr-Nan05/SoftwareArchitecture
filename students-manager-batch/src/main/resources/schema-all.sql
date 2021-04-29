DROP TABLE student IF EXISTS;

CREATE TABLE student  (
                         id BIGINT IDENTITY NOT NULL PRIMARY KEY,
                         name VARCHAR(20),
                         major VARCHAR(20),
                         phone VARCHAR(20)
);