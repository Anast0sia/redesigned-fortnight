SELECT Orders.product_name
FROM Orders
         JOIN public.Customers ON Orders.customer_id = Customers.id
WHERE Customers.name = :name;