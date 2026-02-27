# STUDENT MANAGEMENT SYSTEM

---

## 👥 Thông tin nhóm

- **TRẦN ANH HÀO** – 2310856  
- **TRẦN PHẠM MINH HIẾU** – 2310979

---

## 🚀 Link chạy dự án

🔗 **Demo Online:**  
https://student-management-api-jc50.onrender.com/students  

---

## 🧩 Giới thiệu dự án

Dự án **Student Management System** được xây dựng bằng Spring Boot nhằm thực hiện các chức năng quản lý sinh viên cơ bản.

Ứng dụng cho phép:

- Hiển thị danh sách sinh viên
- Thêm sinh viên mới
- Cập nhật thông tin sinh viên
- Xóa sinh viên
- Kết nối cơ sở dữ liệu PostgreSQL
- Triển khai (deploy) ứng dụng lên môi trường cloud

---

## 🛠️ Công nghệ sử dụng

- Java  
- Spring Boot  
- Spring MVC  
- Spring Data JPA (Hibernate)  
- PostgreSQL  
- Thymeleaf  
- Maven  
- Render (Cloud Deployment)

---

## 🗂️ Cấu trúc thư mục chính

```
student-management/
│
├── src/main/java/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   └── entity/
│
├── src/main/resources/
│   ├── templates/
│   └── application.properties
│
└── pom.xml
```

---

## ⚙️ Cấu hình cơ sở dữ liệu

Ví dụ cấu hình trong `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://<host>:5432/<database>
spring.datasource.username=<username>
spring.datasource.password=<password>

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

---

## ▶️ Hướng dẫn chạy dự án Local

### 1️⃣ Clone project

```bash
git clone <link-repository>
cd student-management
```

### 2️⃣ Cấu hình database PostgreSQL

- Tạo database mới trong PostgreSQL
- Cập nhật thông tin kết nối trong `application.properties`

### 3️⃣ Chạy project

```bash
mvn spring-boot:run
```

Hoặc chạy trực tiếp từ IDE (IntelliJ / VS Code)

Truy cập trình duyệt:

```
http://localhost:8080/students
```

---

## 📸 Screenshot Module Lab 4

### 1️⃣ Trang danh sách sinh viên
![Student List](https://github.com/user-attachments/assets/e8794a0d-6123-4ca4-886c-d9daba9b4313)

---

### 2️⃣ Form thêm sinh viên
![Add Student](https://github.com/user-attachments/assets/f862f20a-e361-429c-b5e1-be8ad4d4ff04)

---

### 3️⃣ Cơ sở dữ liệu PostgreSQL
![Database](https://github.com/user-attachments/assets/f26fbae2-0c43-49fc-a5c9-68ea484f6e38)

---

### 4️⃣ Chức năng cập nhật sinh viên
![Update](https://github.com/user-attachments/assets/5affc707-e149-48f8-b1c1-dbf988cac10c)

---

### 5️⃣ Chức năng xóa sinh viên
![Delete](https://github.com/user-attachments/assets/f0797261-b7cf-4049-8c1c-95008d7e3a34)

---

### 6️⃣ Deploy thành công trên Render
![Deploy](https://github.com/user-attachments/assets/c1ee8519-934a-4fc6-8f0c-fd039e71be51)

---

## ✅ Kết luận

Dự án đã hoàn thành đầy đủ các chức năng CRUD cơ bản:

- Kết nối thành công với PostgreSQL  
- Tích hợp giao diện bằng Thymeleaf  
- Triển khai thành công lên môi trường cloud  
- Hoạt động ổn định khi truy cập online  

---

⭐ **Hoàn thành Lab 4 – Student Management System**
