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
Método  Endpoint    Descrição
GET	/alunos	Lista todos os alunos
POST	/alunos	Cria um novo aluno
PUT	/alunos/{id}	Atualiza um aluno existente
DELETE	/alunos/{id}	Remove um aluno

### 📁 Estrutura de diretórios
src/
├── main/
│   ├── java/com/crud/crud/
│   │   ├── model/
│   │   ├── repository/
│   │   ├── controller/
│   └── resources/
│       └── application.properties
└── test/

### 👤 Autores
Ramon Lopes
Melissa Rodrigues
Edicledisson Santana
Wellington Aguiar

