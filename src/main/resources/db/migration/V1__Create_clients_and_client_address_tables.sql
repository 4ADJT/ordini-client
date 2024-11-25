CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE clients (
                         id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                         name VARCHAR(255) NOT NULL,
                         email VARCHAR(255) UNIQUE NOT NULL,
                         phone VARCHAR(20),
                         cellphone VARCHAR(20),
                         document VARCHAR(50) UNIQUE NOT NULL,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE client_address (
                                id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                                street VARCHAR(255) NOT NULL,
                                number INT,
                                complement VARCHAR(255),
                                neighborhood VARCHAR(255),
                                city VARCHAR(255) NOT NULL,
                                state VARCHAR(100) NOT NULL,
                                country VARCHAR(100) NOT NULL,
                                zip_code VARCHAR(20) NOT NULL,
                                longitude BIGINT,
                                latitude BIGINT,
                                client_id UUID UNIQUE,
                                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                                updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,

                                CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES clients (id)
);
