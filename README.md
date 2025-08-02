
# 📚 StudyBuddy Hub

> A fullstack web application that helps students find study partners, create or join study groups, and collaborate via real-time group chat.

![Screenshot](./screenshots/dashboard.png)

---

## 🚀 Features

- 🔐 User authentication (JWT-based login/register)
- 🧑‍🎓 Select your interested subjects
- 🤝 Find study buddies based on common subjects & time availability
- 👥 Create or join study groups
- 💬 Real-time group chat
- 🔍 Search for groups and users
- ⚙️ Manage group members and settings

---

## 🛠️ Tech Stack

| Layer      | Technologies |
|------------|--------------|
| **Backend** | Java, Spring Boot, Spring Security, JPA, PostgreSQL |
| **Frontend** | React / Next.js, Tailwind CSS, Axios |
| **Auth**     | JWT Token |
| **Realtime** | WebSocket / STOMP |
| **Deployment** | Render (backend), Vercel (frontend) |

---

## 🧱 Architecture Overview

```
Frontend (React/Next.js)
    ↕ Axios (REST API + JWT)
Spring Boot (REST API)
    ↕ JPA
PostgreSQL
```

---

## 🗃️ Database Schema

![ERD](./screenshots/erd.png)

Main tables:
- `users`, `subjects`, `user_subjects`
- `study_groups`, `group_members`, `messages`

---

## 🧪 Getting Started (Local Setup)

### ✅ Prerequisites

- Java 17+
- Node.js 18+
- PostgreSQL

### ⚙️ Backend (Spring Boot)

```bash
# Clone the repo
git clone https://github.com/your-username/studybuddy-hub.git
cd studybuddy-hub/backend

# Configure PostgreSQL in application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/studybuddy_db
...

# Run the app
./mvnw spring-boot:run
```

### 💻 Frontend (React / Next.js)

```bash
cd ../frontend
npm install
npm run dev
```

---

## 🔐 Test Credentials

```bash
Email: test@example.com
Password: 123456
```

---

## 📸 UI Preview

| Login Page | Search Study Group |
|------------|--------------------|
| ![](./screenshots/login.png) | ![](./screenshots/search-group.png) |

---

## ✅ Milestones

- [x] ERD design
- [x] Spring Boot API with JWT Auth
- [x] Frontend UI (React)
- [x] Subject & Group management
- [x] Real-time group chat
- [ ] Mobile responsive UI
- [ ] CI/CD pipeline (GitHub Actions)

---

## 📘 What I Learned

- Fullstack app development using Spring Boot + React
- Secure user authentication with JWT
- RESTful API design and integration
- Real-time communication via WebSocket
- Clean UI with Tailwind CSS
- Database relationships with JPA and PostgreSQL

---

## 🤝 Contributing & Contact

This project was built by **Minh – Fresher Fullstack Developer**.  
Feel free to open issues or contribute.

📫 Contact: `your-email@example.com`

---

## 📄 License

This project is licensed under the MIT License – feel free to use and modify.
