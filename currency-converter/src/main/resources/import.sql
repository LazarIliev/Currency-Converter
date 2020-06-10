INSERT INTO admins(id, name, password)VALUES ('111','admin1', 'password1');

CREATE TABLE currencies (
    code VARCHAR(5) NOT NULL,
    name VARCHAR(30) NOT NULL,
    reverse_rate DECIMAL(10, 7) NOT NULL,
    rate DECIMAL(10, 7) NOT NULL,
    PRIMARY KEY (code)
);

INSERT INTO currencies(code, name, reverse_rate, rate)VALUES ('AD', 'Australian Dollar', 9.829676, 1.20529);