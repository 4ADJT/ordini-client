CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS client_address (
                                id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                                street VARCHAR(255) NOT NULL,
                                number INTEGER NOT NULL,
                                complement VARCHAR(255),
                                neighborhood VARCHAR(100),
                                city VARCHAR(100) NOT NULL,
                                state VARCHAR(100) NOT NULL,
                                country VARCHAR(100) NOT NULL,
                                zip_code VARCHAR(20) NOT NULL,
                                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS clients (
                         id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                         name VARCHAR(255) NOT NULL,
                         email VARCHAR(255) NOT NULL UNIQUE,
                         phone VARCHAR(50),
                         cellphone VARCHAR(50),
                         document VARCHAR(50) NOT NULL UNIQUE,
                         address_id UUID NOT NULL,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                         CONSTRAINT fk_clients_address
                             FOREIGN KEY (address_id)
                                 REFERENCES client_address(id)
                                 ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS idx_clients_name ON clients(name);
CREATE INDEX IF NOT EXISTS idx_clients_email ON clients(email);
CREATE INDEX IF NOT EXISTS idx_clients_document ON clients(document);
CREATE INDEX IF NOT EXISTS idx_client_address_city ON client_address(city);
CREATE INDEX IF NOT EXISTS idx_client_address_zip_code ON client_address(zip_code);
