DROP TABLE if EXISTS users;

CREATE TABLE users (
                       user_code   BIGINT AUTO_INCREMENT PRIMARY KEY,
                       id          VARCHAR(50) NOT NULL UNIQUE,
                       username    VARCHAR(50) NOT NULL UNIQUE,
                       password    VARCHAR(255) NOT NULL,
                       email       VARCHAR(100) NOT NULL UNIQUE,
                       created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       last_login  TIMESTAMP,
                       status      VARCHAR(20) DEFAULT 'ACTIVE'
);