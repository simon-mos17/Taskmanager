# Task Management REST API

A simple backend REST API built with Spring Boot for managing tasks.  
This project demonstrates a clean layered architecture (Controller → Service → Repository), 
data persistence with MySQL, validation, and filtering functionality.

---

## 🚀 Tech Stack

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA (Hibernate)
- MySQL
- Jakarta Validation
- Maven

---

## 📦 Features

- Create, Read, Update, Delete (CRUD)
- Filter tasks by status and priority
- Automatic default values (status & priority)
- Input validation using @NotBlank
- Custom exception handling (NotFoundException)
- Layered architecture (Controller → Service → Repository)

---

## 🏗 Architecture

**Controller**  
Handles HTTP requests and responses  

**Service**  
Contains business logic  

**Repository**  
Handles database interaction via Spring Data JPA  

---

## 📌 API Endpoints

| Method | Endpoint        | Description |
|--------|----------------|-------------|
| POST   | `/tasks`       | Create new task |
| GET    | `/tasks`       | Get all tasks (optional filters) |
| GET    | `/tasks/{id}`  | Get task by ID |
| PUT    | `/tasks/{id}`  | Update task |
| DELETE | `/tasks/{id}`  | Delete task |

---

## 🔎 Filtering Example

```
GET /tasks?status=NOT_STARTED
GET /tasks?priority=HIGH
GET /tasks?status=DONE&priority=MEDIUM
```

---

## 🧪 Example Request

### Create Task

```
POST /tasks
Content-Type: application/json
```

```json
{
  "title": "Learn Spring Boot",
  "description": "Build a REST API project",
  "priority": "HIGH"
}
```

---

## 🛠 Setup & Run

### 1️⃣ Start MySQL

Create database:

```sql
CREATE DATABASE taskdb;
```

---

### 2️⃣ Configure `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/taskdb
spring.datasource.username=taskuser
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
```

---

### 3️⃣ Run the application

```bash
./mvnw spring-boot:run
```

Application runs at:

```
http://localhost:8080
```

---

## 📂 Project Structure

```
task
 ├── Task.java
 ├── TaskController.java
 ├── TaskService.java
 ├── TaskRepository.java
 ├── enums
 └── exception
```

---

## 🎯 Purpose

This project was built to demonstrate backend development skills including:

- REST API design
- Database integration
- Validation and error handling
- Clean architecture principles

---
