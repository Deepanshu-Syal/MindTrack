# 🗂️ MindTrack – Personal Data Journal APP

MindTrack is a Spring Boot-based backend application for storing and managing personal data entries. It allows users to securely create, organize, and retrieve custom journal entries of any kind — including thoughts, ideas, tasks, logs, and more.

---

## 🚀 Features

- 🔐 User authentication with JWT-based login  
- 📝 Full CRUD operations for personal journal entries  
- 🧾 Flexible schema to support a wide range of personal data  
- 🗃️ Configuration support for app-level settings  
- 🧩 Clean and modular service-repository architecture  

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot 3
- Spring Security
- Spring Data MongoDB
- Lombok
- RESTful API

---

## 📁 Project Structure

```
src
└── main
    └── java
        └── com
            └── deepanshu
                └── FirstProject
                    ├── entity
                    │   ├── User.java
                    │   ├── JournalEntry.java
                    │   └── ConfigJournalAppEntity.java
                    ├── repository
                    │   ├── UserRepository.java
                    │   ├── JournalEntryRepository.java
                    │   └── ConfigJournalAppRepository.java
                    ├── service
                    │   ├── UserService.java
                    │   ├── JournalEntryService.java
                    │   └── UserDetailsServiceImpl.java
```

---

## 🔗 API Overview

### 🧑 User Authentication

- `POST /auth/register` – Register a new user  
- `POST /auth/login` – Login and receive JWT token  

### 👤 User APIs

- `GET /users/{id}` – Fetch user profile  
- `PUT /users/{id}` – Update user information  
- `DELETE /users/{id}` – Delete a user account  

### 📓 Journal APIs

- `GET /journal` – Get all journal entries for current user  
- `POST /journal` – Create a new entry  
- `PUT /journal/{id}` – Update an existing entry  
- `DELETE /journal/{id}` – Delete an entry  

---

## ⚙️ Setup Instructions

### Prerequisites

- Java 17 or higher  
- Maven  
- MongoDB (local or MongoDB Atlas)  

### 1. Clone the Repository

```bash
git clone https://github.com/Deepanshu-Syal/MindTrack.git 
```

### 2. Configure MongoDB & JWT

Edit `src/main/resources/application.properties`:

```properties
spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster.mongodb.net/mindtrack
```

### 3. Run the Application

```bash
./mvnw spring-boot:run
```

App will be available at: `http://localhost:8080`

---

## 🔐 Security Details

- JWT-based authentication with secure token handling  
- Role-based access control (if needed)  
- Passwords stored using BCrypt encryption  

---

## 🧪 Testing

You can use **Postman** or any REST client to test endpoints.  

---

## 📜 License

This project is licensed under the XXXXXXX License.

---

## 👨‍💻 Author

**Deepanshu**  
_NIT Graduate | Software Engineer @ NVIDIA_
