# 📚 CrudSpringBibliowl

Este é um projeto de CRUD, por meio da construção de API RESTFUL, com a associação entre alunos e livros, desenvolvido em **Spring Boot**, usando **JPA**, **MySQL**, e documentado com **Swagger**. 

---

## 🚀 Tecnologias Utilizadas

- Java 22  
- Spring Boot 3.4+  
- Spring Data JPA  
- MySQL 8  
- Swagger (Springdoc OpenAPI)  
- Maven

---

## 🛠️ Como Executar o Projeto

### ✅ Pré-requisitos

- Java 17 ou superior (recomendado Java 22)  
- Maven instalado  
- Banco de dados MySQL rodando

---

### 🔧 Passos para rodar localmente

1. **Clone o repositório:**

```bash
git clone https://github.com/ramonlopes23/CrudSpringBibliowl.git
cd CrudSpringBibliowl
```

### 🛠️ Configurando o banco de dados
No arquivo src/main/resources/application.properties, altere as seguintes configurações conforme seu ambiente:


spring.datasource.url=jdbc:mysql://localhost:3306/nomedobanco  
spring.datasource.username=seu_usuario  
spring.datasource.password=sua_senha  
spring.jpa.hibernate.ddl-auto=update  

### 💡 O banco de dados deve existir no MySQL antes da execução.

### ▶️ Executando a aplicação via bash:

```bash
./mvnw spring-boot:run
```
### Ou, caso esteja usando Windows:
```bash
mvn spring-boot:run
```
### 📑 Documentação com Swagger
Acesse a interface do Swagger UI após iniciar a aplicação:

### 🔗 http://localhost:8080/swagger-ui/index.html

### 🧪 Endpoints principais
GET /alunos            - Listam todos os alunos.  

GET /livros            - Listam todos os livros.  


POST /alunos           - Criam um novo aluno.  

POST /livros           - Criam um novo livro.  


PUT /alunos/{id}       - Atualizam um aluno existente.  

PUT /livros/{id}       - Atualizam um livro existente.  


DELETE /alunos/{id}    - Removem um aluno.  

DELETE /livros/{id}    - Removem um livro.  



### 👤 Autores
Ramon Lopes, Melissa Rodrigues, Edicledisson Santana e Wellington Aguiar

