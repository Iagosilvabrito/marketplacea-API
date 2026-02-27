CREATE TABLE category (
                    id serial PRIMARY KEY,
                    name VARCHAR(100) NOT NULL,
                    description VARCHAR(500) NOT NULL,
                    isActive BOOLEAN NOT NULL DEFAULT TRUE,
                    createdAt TIMESTAMP

);