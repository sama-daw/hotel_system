CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE,
    password VARCHAR(100)
);

CREATE TABLE employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    gender ENUM('male','female'),
    job ENUM('front desk clerk','kitchen staff','room service','housekeeping','security','manager'),
    salary DECIMAL(10,2),
    phone VARCHAR(20),
    email VARCHAR(100)
);

CREATE TABLE rooms (
    room_number INT PRIMARY KEY,
    availability ENUM('free','busy') DEFAULT 'free',
    cleaning_status ENUM('clean','dirty') DEFAULT 'clean',
    price DECIMAL(10,2),
    bed_type ENUM('single','double','suite')
);

CREATE TABLE customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(100),
    gender ENUM('male','female'),
    phone VARCHAR(20),
    room_number INT,
    cost DECIMAL(10,2),
    check_in DATE,
    FOREIGN KEY (room_number) REFERENCES rooms(room_number)
);

CREATE TABLE check_in (
    checkin_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    customer_name VARCHAR(100), -- optional copy
    room_number INT,
    checkin_date DATE,
    amount_pending DECIMAL(10,2),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (room_number) REFERENCES rooms(room_number)
);

CREATE TABLE check_out (
    checkout_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    customer_name VARCHAR(100), -- optional copy
    room_number INT,
    checkin_date DATE,
    checkout_date DATE,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (room_number) REFERENCES rooms(room_number)
);

CREATE TABLE payments (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    room_number INT,
    payment_date DATE,
    amount_paid DECIMAL(10,2),
    payment_method ENUM('cash','credit card','online','bank transfer'),
    
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (room_number) REFERENCES rooms(room_number)
);

INSERT INTO users (username, password) VALUES
('admin', 'admin123'),
('reception', 'recep123'),
('manager', 'manager123');

SELECT * FROM users;

INSERT INTO employees (name, age, gender, job, salary, phone, email) VALUES
('Ahmed Ali', 28, 'male', 'front desk clerk', 5000.00, '01011111111', 'ahmed@example.com'),
('Sara Mohamed', 32, 'female', 'kitchen staff', 4500.00, '01022222222', 'sara@example.com'),
('Omar Hossam', 40, 'male', 'manager', 10000.00, '01033333333', 'omar@example.com');

SELECT * FROM employees;

INSERT INTO rooms (room_number, availability, cleaning_status, price, bed_type) VALUES
(101, 'free', 'clean', 200.00, 'single'),
(102, 'free', 'dirty', 350.00, 'double'),
(103, 'busy', 'clean', 500.00, 'suite');

SELECT * FROM rooms;

INSERT INTO customers (customer_name, gender, phone, room_number, cost, check_in) VALUES
('Mohamed Salah', 'male', '01044444444', 101, 200.00, '2025-12-10'),
('Fatma Hassan', 'female', '01055555555', 103, 500.00, '2025-12-11');

SELECT * FROM customers;


INSERT INTO check_in (customer_id, customer_name, room_number, checkin_date, amount_pending) VALUES
(1, 'Mohamed Salah', 101, '2025-12-10', 0.00),
(2, 'Fatma Hassan', 103, '2025-12-11', 500.00);

SELECT * FROM check_in;

INSERT INTO check_out (customer_id, customer_name, room_number, checkin_date, checkout_date) VALUES
(1, 'Mohamed Salah', 101, '2025-12-10', '2025-12-12');

SELECT * FROM check_out;


INSERT INTO payments (customer_id, room_number, payment_date, amount_paid, payment_method) VALUES
(1, 101, '2025-12-10', 200.00, 'cash'),
(2, 103, '2025-12-11', 300.00, 'credit card');


SELECT * FROM payments;





