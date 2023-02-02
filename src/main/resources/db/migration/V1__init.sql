
CREATE TABLE blockchain (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

create index if not exists blockchain_name_idx on blockchain (name);

INSERT INTO blockchain (id, name)
VALUES (1, 'Ethereum')