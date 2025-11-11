CREATE DATABASE library_db;

USE library_db;

--- Create tables
CREATE TABLE books(
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    title VARCHAR(100) NOT NULL,
                    author VARCHAR(100) NOT NULL,
                    available BOOLEAN DEFAULT TRUE,
                    quantity INT NOT NULL
);

CREATE TABLE users(
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(100) NOT NULL,
                    email VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE transactions(
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    user_id INT NOT NULL,
                    book_id INT NOT NULL,
                    action VARCHAR(20) NOT NULL,
                    date DATE NOT NULL,
                    FOREIGN KEY (user_id) REFERENCES users(id),
                    FOREIGN KEY (book_id) REFERENCES books(id)
);

--- To see table details and their values
SELECT * FROM books;
SELECT * FROM users;
SELECT * FROM transactions;
