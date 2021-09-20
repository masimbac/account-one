CREATE TABLE customer
( 
    id IDENTITY NOT NULL PRIMARY KEY ,
    firstname VARCHAR NOT NULL ,
    lastname VARCHAR NOT NULL
);

CREATE TABLE account
( 
    id IDENTITY NOT NULL PRIMARY KEY ,
    customer_id INT NOT NULL ,
    initial_credit NUMERIC(8, 2) NOT NULL,
    balance NUMERIC(8, 2) NOT NULL,
    FOREIGN KEY (customer_id) references customer(id)
);

CREATE TABLE transactions
( 
    id IDENTITY NOT NULL PRIMARY KEY ,
    account_id BIGINT NOT NULL ,
    amount NUMERIC(8, 2) NOT NULL,
    FOREIGN KEY (account_id) references account(id)
);