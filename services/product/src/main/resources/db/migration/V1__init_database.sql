-- Create tables
CREATE TABLE IF NOT EXISTS category (
    id INTEGER NOT NULL PRIMARY KEY DEFAULT nextval('category_seq'),
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS product (
    id INTEGER NOT NULL PRIMARY KEY DEFAULT nextval('product_seq'),
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    available_quantity NUMERIC(10, 2) NOT NULL,
    price NUMERIC(10, 2),
    category_id INTEGER,
    CONSTRAINT fk1productcat FOREIGN KEY (category_id) REFERENCES category(id)
);

-- Create sequences
CREATE SEQUENCE IF NOT EXISTS category_seq
    INCREMENT BY 50
    START WITH 1;

CREATE SEQUENCE IF NOT EXISTS product_seq
    INCREMENT BY 50
    START WITH 1;
