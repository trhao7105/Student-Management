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
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── vn/edu/hcmut/cse/adsoftweng/lab/
│   │   │       ├── controller/
│   │   │       ├── entity/
│   │   │       ├── repository/
│   │   │       ├── service/
│   │   │       └── StudentManagementApplication.java
│   │   │
│   │   └── resources/
│   │       ├── templates/
│   │       └── application.properties
│   │
│   └── test/
│
├── pom.xml
└── README.md
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
git clone https://github.com/trhao7105/Student-Management.git
cd student-management
```

### 2️⃣ Cấu hình PostgreSQL

- Tạo database mới trong PostgreSQL  
- Cập nhật thông tin kết nối trong `application.properties`  

### 3️⃣ Chạy project

```bash
mvn spring-boot:run
```

Hoặc chạy trực tiếp từ IDE (IntelliJ / VS Code)

Truy cập:

```
http://localhost:8080/students
```

---

## 📸 Screenshot Module Lab 4

### 1️⃣ Trang danh sách sinh viên
![Student List](https://github.com/user-attachments/assets/e8794a0d-6123-4ca4-886c-d9daba9b4313)

### 2️⃣ Form thêm sinh viên
![Add Student](https://github.com/user-attachments/assets/f862f20a-e361-429c-b5e1-be8ad4d4ff04)

### 3️⃣ Cơ sở dữ liệu PostgreSQL
![Database](https://github.com/user-attachments/assets/f26fbae2-0c43-49fc-a5c9-68ea484f6e38)

### 4️⃣ Chức năng cập nhật sinh viên
![Update](https://github.com/user-attachments/assets/5affc707-e149-48f8-b1c1-dbf988cac10c)

### 5️⃣ Chức năng xóa sinh viên
![Delete](https://github.com/user-attachments/assets/f0797261-b7cf-4049-8c1c-95008d7e3a34)

### 6️⃣ Deploy thành công trên Render
![Deploy](https://github.com/user-attachments/assets/c1ee8519-934a-4fc6-8f0c-fd039e71be51)

---

# 📘 Lab 1 – Trả lời câu hỏi (Câu 2, 3, 4)

---

## 2️⃣ Ràng buộc Khóa Chính (Primary Key Constraint)

### Thực nghiệm

```sql
INSERT INTO students (id, name, email, age)
VALUES (1, 'Duplicate Test', 'dup@example.com', 20);
```

### Kết quả

Database báo lỗi:

```
UNIQUE constraint failed: students.id
```

### Giải thích

Cột `id` được khai báo:

```sql
id INTEGER PRIMARY KEY
```

Primary Key có hai đặc tính:

- Không được trùng (UNIQUE)  
- Không được NULL  

Database chặn thao tác này để đảm bảo mỗi sinh viên có một định danh duy nhất và bảo vệ tính toàn vẹn dữ liệu.

---

## 3️⃣ Toàn vẹn dữ liệu (NULL Constraint)

### Thực nghiệm

```sql
INSERT INTO students (id, name, email, age)
VALUES (20, NULL, 'noname@example.com', 20);
```

### Kết quả

Nếu cột `name` không có `NOT NULL`, database sẽ không báo lỗi.

### Giải thích

Nếu bảng khai báo:

```sql
name TEXT
```

NULL được chấp nhận.

Nếu muốn ngăn chặn:

```sql
name TEXT NOT NULL
```

### Ảnh hưởng trong Java

Nếu Entity có:

```java
private String name;
```

Giá trị NULL có thể gây:

- NullPointerException  
- Lỗi hiển thị  
- Sai logic xử lý  

Cần kết hợp ràng buộc ở Database và validate ở tầng Service.

---

## 4️⃣ Cấu hình Hibernate – ddl-auto

Trong dự án sử dụng:

```properties
spring.jpa.hibernate.ddl-auto=update
```

### Các chế độ phổ biến

| Giá trị      | Ý nghĩa |
|-------------|----------|
| create      | Tạo lại bảng mỗi lần chạy |
| update      | Cập nhật cấu trúc bảng, giữ dữ liệu |
| create-drop | Tạo khi start, xóa khi stop |
| none        | Không tự động thay đổi schema |

Sử dụng `update` giúp:

- Giữ nguyên dữ liệu khi restart  
- Tự động cập nhật cấu trúc khi Entity thay đổi  
- Phù hợp môi trường development  

Trong production nên dùng `none` và quản lý schema bằng migration tool.

---

## ✅ Kết luận

Dự án đã hoàn thành đầy đủ các chức năng CRUD:

- Kết nối PostgreSQL thành công  
- Tích hợp giao diện Thymeleaf  
- Deploy thành công lên cloud  
- Hiểu rõ cơ chế Constraint và Hibernate configuration  

---
