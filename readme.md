# Employee Management API

API REST desenvolvida em **Java + Spring Boot** para gerenciamento de funcionários e seus endereços, com foco em **boas práticas**, arquitetura em camadas e contratos claros de API.

---

## 🚀 Tecnologias

- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Bean Validation (`@Valid`)
- Lombok

---

## 🧱 Arquitetura

O projeto segue uma arquitetura em camadas:

com.infnet.employeemanagement

/controller

/service

/repository

/entity

/dto

/dto/request

/dto/response

/exception

/config


- **DTOs de request** validam dados de entrada
- **DTOs de response** definem o contrato de saída da API
- Entidades JPA não são expostas diretamente

---

## 🌐 Endpoints

### Listar funcionários
- GET /employees

### Buscar por ID
- GET /employees/{id}

### Criar funcionário
- POST /employees


```json
{
  "firstName": "primeiro",
  "lastName": "ultimo",
  "address": {
    "street": "Rua X",
    "city": "Rio de Janeiro",
    "state": "RJ",
    "zipCode": "12345-000"
  }
}
```

### Atualizar funcionário
- PUT /employees/{id}

*Payload completo obrigatório.*

### Remover funcionário
- DELETE /employees/{id}

## 🚫 Tratamento de Erros

Exceções customizadas (ex: EmployeeNotFoundException)

Tratamento centralizado com @RestControllerAdvice
