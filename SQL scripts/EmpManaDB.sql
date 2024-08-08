-- Tạo bảng EMPLOYEES
CREATE TABLE EMPLOYEES (
    	emp_id INT AUTO_INCREMENT PRIMARY KEY,
	personal_id VARCHAR(12) UNIQUE,
	first_name VARCHAR(20),
	last_name VARCHAR(20),
	tin VARCHAR(14) UNIQUE, -- Tax identification number
	acc_number VARCHAR(20) UNIQUE, -- stk ngân hàng
	start_date DATE,
	department_id INT,
	position_id INT,
	salary INT,
	status VARCHAR(10) NOT NULL,
	user_type VARCHAR(10) NOT NULL
	gender binary,
	address VARCHAR(255),
	tel VARCHAR(10) UNIQUE,
	dob DATE,
	email VARCHAR(100) UNIQUE
	password VARCHAR(255) NOT NULL,
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

-- Tạo bảng REQUESTS
CREATE TABLE REQUESTS (
    req_id INT AUTO_INCREMENT PRIMARY KEY,
    emp_id INT NOT NULL,
	req_time DATETIME NOT NULL,
	request_type INT,
	status INT,
	manager_id INT,
    FOREIGN KEY (manager_id) REFERENCES EMPLOYEES(emp_id),
	FOREIGN KEY (emp_id) REFERENCES EMPLOYEES(emp_id)
);

-- Tạo bảng DETAILED_REQUEST
CREATE TABLE DETAILED_REQUEST (
    req_id INT PRIMARY KEY,
	start_date DATE,
	end_date DATE,
	reason TEXT,
    FOREIGN KEY (req_id) REFERENCES REQUESTS(req_id)
);

-- Tạo bảng ACTIVITIES
CREATE TABLE ACTIVITIES (
    event_id INT PRIMARY KEY,
	emp_id INT,
	total_time VARCHAR(10),
	total_distance FLOAT,
    FOREIGN KEY (emp_id) REFERENCES EMPLOYEES(emp_id)
);

-- Tạo bảng POINT_HISTORY
CREATE TABLE POINT_HISTORY (
    emp_id INT NOT NULL,
	changed_on DATETIME NOT NULL, -- thời gian xảy ra biến động
	amount INT,
	activity BINARY, -- tăng hoặc giảm
	reward_id INT,
	PRIMARY KEY (emp_id, changed_on),
    FOREIGN KEY (emp_id) REFERENCES EMPLOYEES(emp_id)
);

-- Tạo bảng REWARD_LIST
CREATE TABLE REWARD_LIST (
    reward_id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255),
	point INT,
	quantity INT
);

-- Tạo khóa ngoại
ALTER TABLE EMPLOYEES
ADD CONSTRAINT fk_emp_pos
FOREIGN KEY (position_id) REFERENCES POSITIONS(position_id);



