-- Tạo bảng EMPLOYEES
CREATE TABLE EMPLOYEES (
    	employee_id INT AUTO_INCREMENT PRIMARY KEY,
	full_name VARCHAR(50),
	tax_code VARCHAR(20) UNIQUE, -- Tax identification number
	bank_account VARCHAR(20) UNIQUE, -- stk ngân hàng
	start_date DATE,
	department_id INT,
	position_id INT,
	salary INT,
	status VARCHAR(10) NOT NULL,
	user_type VARCHAR(10) NOT NULL
	gender binary,
	address VARCHAR(255),
	phone VARCHAR(10) UNIQUE,
	date_of_birth DATE,
	email VARCHAR(100) UNIQUE
	password VARCHAR(255) NOT NULL,
	strava_access_token VARCHAR(255),
);

-- Tạo bảng DEPARTMENTS
CREATE TABLE DEPARTMENTS (
    department_id INT AUTO_INCREMENT PRIMARY KEY,
    dep_name VARCHAR(255) NOT NULL,
    manager_id INT NOT NULL,
	FOREIGN KEY (manager_id) REFERENCES EMPLOYEES(emp_id)
);

-- Tạo bảng POSITIONS
CREATE TABLE POSITIONS (
    position_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT
);

-- Tạo bảng EMPLOYEE_REQUESTS
CREATE TABLE EMPLOYEE_REQUESTS (
    req_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT NOT NULL,
	request_date DATETIME NOT NULL,
	request_type INT,
	status INT,
	FOREIGN KEY (emp_id) REFERENCES EMPLOYEES(emp_id)
);

-- Tạo bảng EMPLOYEE_ACTIVITIES
CREATE TABLE EMPLOYEE_ACTIVITIES (
   activityId INT PRIMARY KEY,
	employee_id INT,
	campaign_name VARCHAR(255),
	kilometers_run FLOAT,
	start_date DATE,
	end_date DATE,
	type VARCHAR(10),
	distance FLOAT,
	moving_time INT,
    FOREIGN KEY (employee_id) REFERENCES EMPLOYEES(emp_id)
);

-- Tạo bảng STRAVA_TOKEN
CREATE TABLE STRAVA_TOKEN (
   id INT PRIMARY KEY,
	employee_id INT,
	access_token VARCHAR(255),
	refresh_token VARCHAR(255),
	token_type VARCHAR(255),
	expires_at INT,
    FOREIGN KEY (employee_id) REFERENCES EMPLOYEES(emp_id)
);

-- Tạo bảng VOUCHER
CREATE TABLE VOUCHER (
     id INT AUTO_INCREMENT PRIMARY KEY,
    	code VARCHAR(255),
	value INT,
	createdAt DATE,
	expiresAt DATE,
	isRedeemed binary,
    FOREIGN KEY (emp_id) REFERENCES EMPLOYEES(emp_id)
);

-- Tạo bảng REWARD
CREATE TABLE REWARD (
    id INT AUTO_INCREMENT PRIMARY KEY,
	employeeId INT,
	point INT,
	quantity INT
);

-- Tạo bảng VOUCHER
CREATE TABLE REWARD (
    id INT AUTO_INCREMENT PRIMARY KEY,
	employeeId INT,
	point INT,
	quantity INT
);

-- Tạo khóa ngoại
ALTER TABLE EMPLOYEES
ADD CONSTRAINT fk_emp_pos
FOREIGN KEY (position_id) REFERENCES POSITIONS(position_id);



