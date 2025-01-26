CREATE TABLE IF NOT EXISTS transactions (
    id BIGSERIAL NOT NULL,
    description VARCHAR(255),
    amount NUMERIC(19, 2),
    type VARCHAR(50),
    date_time TIMESTAMP,
    PRIMARY KEY (id)
);
