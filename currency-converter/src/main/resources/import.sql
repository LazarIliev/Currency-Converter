

CREATE TABLE currencies (
    code VARCHAR(5) NOT NULL,
    name VARCHAR(30) NOT NULL,
    rate DECIMAL(10, 7) NOT NULL,
    ratio INT NOT NULL ,
    PRIMARY KEY (code)
);

