# Modo de execução da aplicação Spring Boot Ordini Client

## Requisitos
 - Java 21 (JDK)
 - Docker
 - Plugin Docker Compose

### Recomendações

 - IDE Intellij IDEA
 - Cliente SQL (DBeaver, DataGrip, etc)

## Build

A execução do build é feita através do comando `./gradlew build` na raiz do projeto.

> [!IMPORTANT]
> 
> Requer variáveis de ambiente para execução
> Use os exemplos abaixo do arquivo `.env` de desenvolvimento para definir as variáveis ambiente de produção.

### Desenvolvimento

Use o arquivo de tipo `.env` para definir as variáveis de ambiente necessárias para execução da aplicação.

```dotenv {.env}
DB_USER=postgres
DB_PASSWORD=postgres
DB_POSTGRES=ordini
DB_URL=jdbc:postgresql://postgresdb:5432/ordini

APP_PORT=8080
APP_DB_DATASOURCE=jdbc:postgresql://postgresdb:5432/ordini
APP_DB_USERNAME=postgres
APP_DB_PASSWORD=postgres

RABBITMQ_HOST=localhost
RABBITMQ_PORT=5672
RABBITMQ_USERNAME=guest
RABBITMQ_PASSWORD=guest
```

## Execução

Para executar a aplicação, basta executar o comando `docker-compose up -d` na raiz do projeto.
