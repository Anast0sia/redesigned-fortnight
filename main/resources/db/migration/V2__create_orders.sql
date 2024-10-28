CREATE TABLE IF NOT EXISTS ORDERS(
                                     id serial PRIMARY KEY,
                                     date date,
                                     customer_id serial,
                                     product_name text,
                                     amount int,
                                     FOREIGN KEY (customer_id) REFERENCES CUSTOMERS(id)
    );