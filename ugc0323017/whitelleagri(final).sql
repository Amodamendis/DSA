create database whiteleafagri;
use whiteleafagri;


create table Customer (
    Cus_id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    Con_no VARCHAR(15)
);

create table Admin (
    Admin_id INT PRIMARY KEY,
    username VARCHAR(50),
    email VARCHAR(100),
    p_s VARCHAR(100)
);

create table Plant (
    Plant_ID INT PRIMARY KEY,
    name VARCHAR(100),
    wateramount DECIMAL(10,2),
    nut_amount DECIMAL(10,2)
);

alter table plant 
modify wateramount varchar(100),
 modify nut_amount varchar(120);
select * from plant;
CREATE TABLE Worker (
    worker_ID INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL
);
select * from Worker;


create table Disease (
    Disease_ID INT PRIMARY KEY,
    name VARCHAR(100),
    symptoms TEXT,
    treatment TEXT
);

create table Inventory (
    greenhouse_ID INT PRIMARY KEY,
    Description TEXT,
    stock INT,
    number INT
);

create table tool (
    Toolname varchar(100),
    Connu int(9),
    handovertime varchar(40)
   
);
select * from tool;

create table Payment (
    payment_ID INT PRIMARY KEY,
    amount DECIMAL(10,2),
    pay_method VARCHAR(50),
    pay_date DATE,
    Cus_id INT,
    FOREIGN KEY (Cus_id) references Customer(Cus_id)
);

create table Feedback (
    FeedbackID INT PRIMARY KEY,
    message TEXT,
    Date DATE,
    Cus_id INT,
    FOREIGN KEY (Cus_id) references Customer(Cus_id)
);

CREATE TABLE cart (
  name VARCHAR(255),
  price DECIMAL(10,2),
  image VARCHAR(255),
  quantity INT,
  id INT
);

CREATE TABLE products (
  id INT PRIMARY KEY,
  name VARCHAR(255),
  price DECIMAL(10,2),
  image VARCHAR(255),
  category VARCHAR(255)
);








