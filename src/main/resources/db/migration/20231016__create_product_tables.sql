CREATE TABLE public.brand (
    id NUMERIC NOT NULL PRIMARY KEY,
    name VARCHAR
);

CREATE TABLE public.product (
    id NUMERIC NOT NULL PRIMARY KEY,
    brand_id NUMERIC,
    name VARCHAR
);

CREATE TABLE public.price (
    brand_id NUMERIC,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    price_list NUMERIC,
    product_id NUMERIC,
    priority NUMERIC,
    price NUMERIC,
    curr VARCHAR
);
