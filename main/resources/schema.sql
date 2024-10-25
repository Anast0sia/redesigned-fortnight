CREATE TABLE IF NOT EXISTS CUSTOMERS(
                          id serial PRIMARY KEY,
                          name text,
                          surname text,
                          age int,
                          phone_number bigint
);

CREATE TABLE IF NOT EXISTS ORDERS(
                       id serial PRIMARY KEY,
                       date date,
                       customer_id serial,
                       product_name text,
                       amount int,
                       FOREIGN KEY (customer_id) REFERENCES CUSTOMERS(id)
);

INSERT INTO CUSTOMERS
VALUES (1, 'John', 'Smith', 34, 789789789),
       (2, 'Ivan', 'Ivanov', 28, 898989),
       (3, 'Lily', 'Webb', 23, 999999)
ON CONFLICT (id) DO NOTHING;

INSERT INTO ORDERS
VALUES (669, '12.12.2000', 1, 'milk', 30),
       (565, '09.04.2024', 2, 'chocolate', 77),
       (128, '16.09.2022', 3, 'shoes', 100)
ON CONFLICT (id) DO NOTHING;