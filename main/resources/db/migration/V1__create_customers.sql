CREATE TABLE IF NOT EXISTS CUSTOMERS(
                          id serial PRIMARY KEY,
                          name text,
                          surname text,
                          age int,
                          phone_number bigint
);