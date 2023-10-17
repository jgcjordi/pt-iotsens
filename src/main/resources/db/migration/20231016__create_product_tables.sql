CREATE TABLE public.brand (
    id BIGINT NOT NULL PRIMARY KEY,
    name VARCHAR
);

CREATE TABLE public.product (
    id BIGINT NOT NULL PRIMARY KEY,
    name VARCHAR,
    brand_id BIGINT,
    FOREIGN KEY (brand_id) REFERENCES public.brand(id)
);

CREATE TABLE public.price (
    id BIGINT NOT NULL PRIMARY KEY,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    price_list NUMERIC,
    product_id BIGINT,
    priority NUMERIC,
    price NUMERIC,
    curr VARCHAR,
    FOREIGN KEY (product_id) REFERENCES public.product(id)
);
