# Estruturação do projeto

```plaintext
    src
    └── main
        ├── java
        │   └── com
        │       └── [domain package]
        │           └── project
        │               ├── adapter                   # Adaptadores para interface
        │               │   ├── controller            # Controladores que recebem requisições e delegam aos casos de uso
        │               │   ├── gateway               # Gateways que conectam os casos de uso a sistemas externos
        │               │   └── presenter             # Presenters que formatam a resposta para o cliente
        │               │       └── dto               # DTOs para requisições e respostas, garantindo um formato padronizado
        │               │
        │               ├── application               # Casos de uso (Use Cases)
        │               │   └── usecase               # Cada caso de uso encapsula um fluxo específico da aplicação
        │               │
        │               ├── domain                    # Camada de domínio
        │               │   ├── model                 # Entidades de domínio que representam o núcleo da lógica de negócios
        │               │   ├── repository            # Interfaces de repositório para operações de persistência
        │               │   └── exception             # Exceções personalizadas específicas do domínio
        │               │
        │               └── infrastructure            # Infraestrutura e configurações externas
        │                   ├── config                # Configurações de segurança, Eureka, OpenFeign, etc.
        │                   ├── exception             # Tratamento global de exceções, facilitando o retorno de erros padronizados
        │                   └── persistence           # Implementações de repositórios customizados
        │
        └── resources
            ├── db
            │   └── migration                         # Migrations do Flyway para versionamento do banco de dados
            ├── application.yml                       # Configurações do Spring Boot (DB, Actuator, Eureka, etc.
            
    └── test
        └── java
            └── com
                └── example
                    └── project
                        ├── application
                        │   └── usecase               # Testes de Casos de Uso, validando a lógica de negócio
                        │
                        ├── adapter
                        │   └── controller            # Testes de adaptadores e controllers para validação das interfaces
                        │
                        ├── domain                    # Testes para as entidades de domínio (models)
                        │   └── model                 # Valida a lógica interna e regras de negócio nas entidades
                        │
                        └── infrastructure
                            └── persistence           # Testes de infraestrutura e repositórios customizados
```
