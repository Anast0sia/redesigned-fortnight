INSERT INTO public.ORDERS
VALUES (669, '12.12.2000', 1, 'milk', 30),
       (565, '09.04.2024', 2, 'chocolate', 77),
       (128, '16.09.2022', 3, 'shoes', 100)
    ON CONFLICT (id) DO NOTHING;