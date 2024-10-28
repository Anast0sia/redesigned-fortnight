INSERT INTO public.CUSTOMERS
VALUES (1, 'John', 'Smith', 34, 789789789),
       (2, 'Ivan', 'Ivanov', 28, 898989),
       (3, 'Lily', 'Webb', 23, 999999)
    ON CONFLICT (id) DO NOTHING;