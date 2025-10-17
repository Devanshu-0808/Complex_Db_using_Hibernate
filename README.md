# Complex Database using Spring Boot Data Jpa(Hibernate) Project

# Simple Relationship View
![Alt text](Hibernate_Practice.png)


# E-Commerce Database Schema

This repository contains the database schema and relationships for a sample e-commerce platform.

---

## 📊 Database Tables & Relationships

### 1. `users` Table
| Column     | Type                   | Description          |
|-----------|-----------------------|--------------------|
| id        | BIGINT (PK)           | User ID            |
| name      | VARCHAR(100)          | Full name          |
| email     | VARCHAR(100)          | Unique email       |
| password  | VARCHAR(200)          | Encrypted password |
| role      | ENUM('CUSTOMER','ADMIN') | Role of the user  |
| created_at| TIMESTAMP             | Registration time  |

**Relationships:**
- One User → Many Orders
- One User → Many Addresses
- One User → One Cart
- One User → Many Reviews

---

### 2. `address` Table
| Column  | Type                | Description         |
|--------|--------------------|-------------------|
| id     | BIGINT (PK)        | Address ID        |
| street | VARCHAR(200)       | Street address    |
| city   | VARCHAR(100)       | City              |
| state  | VARCHAR(100)       | State             |
| zipcode| VARCHAR(20)        | Zip code          |
| country| VARCHAR(50)        | Country           |
| user_id| FK → users.id       | Owner of address  |

**Relationships:**
- ManyToOne → User
- OneToMany → Order (shipping address)

---

### 3. `category` Table
| Column | Type          | Description     |
|--------|--------------|----------------|
| id     | BIGINT (PK)  | Category ID    |
| name   | VARCHAR(100) | Category name  |
| description | TEXT     | Description    |

**Relationships:**
- OneToMany → Product

---

### 4. `product` Table
| Column        | Type                | Description        |
|---------------|-------------------|------------------|
| id            | BIGINT (PK)        | Product ID       |
| name          | VARCHAR(150)       | Product name     |
| description   | TEXT               | Details          |
| price         | DECIMAL(10,2)      | Product price    |
| stock_quantity| INT                | Available stock  |
| category_id   | FK → category.id   | Category         |
| created_at    | TIMESTAMP          | Added date       |

**Relationships:**
- ManyToOne → Category
- OneToMany → Review
- OneToMany → CartItem
- OneToMany → OrderItem

---

### 5. `cart` Table
| Column     | Type            | Description     |
|-----------|----------------|----------------|
| id        | BIGINT (PK)    | Cart ID        |
| user_id   | FK → users.id  | Owner          |
| created_at| TIMESTAMP      | Creation date  |

**Relationships:**
- OneToOne → User
- OneToMany → CartItem

---

### 6. `cart_item` Table
| Column     | Type           | Description       |
|-----------|---------------|-----------------|
| id        | BIGINT (PK)   | Cart item ID     |
| cart_id   | FK → cart.id  | Cart reference   |
| product_id| FK → product.id | Product         |
| quantity  | INT           | Quantity         |

**Relationships:**
- ManyToOne → Cart
- ManyToOne → Product

---

### 7. `orders` Table
| Column            | Type                                      | Description          |
|------------------|-------------------------------------------|--------------------|
| id                | BIGINT (PK)                               | Order ID           |
| order_date        | TIMESTAMP                                 | Date               |
| status            | ENUM('PENDING','SHIPPED','DELIVERED','CANCELLED') | Status |
| total_amount      | DECIMAL(10,2)                             | Total              |
| user_id           | FK → users.id                             | Buyer              |
| shipping_address_id | FK → address.id                          | Delivery address   |

**Relationships:**
- ManyToOne → User
- OneToMany → OrderItem
- OneToOne → Payment

---

### 8. `order_item` Table
| Column     | Type           | Description       |
|-----------|----------------|-----------------|
| id        | BIGINT (PK)    | Order item ID     |
| order_id  | FK → orders.id | Parent order     |
| product_id| FK → product.id| Product          |
| quantity  | INT             | Number of items |
| price     | DECIMAL(10,2)  | Price per item   |

**Relationships:**
- ManyToOne → Order
- ManyToOne → Product

---

### 9. `payment` Table
| Column          | Type                                  | Description          |
|-----------------|--------------------------------------|--------------------|
| id              | BIGINT (PK)                           | Payment ID         |
| payment_mode    | ENUM('CREDIT_CARD','UPI','COD')       | Payment method     |
| payment_status  | ENUM('SUCCESS','FAILED','PENDING')   | Status             |
| transaction_id  | VARCHAR(100)                          | Reference          |
| amount          | DECIMAL(10,2)                         | Paid amount        |
| order_id        | FK → orders.id                         | Related order      |

**Relationships:**
- OneToOne → Order

---

### 10. `review` Table
| Column     | Type           | Description       |
|-----------|----------------|-----------------|
| id        | BIGINT (PK)    | Review ID        |
| rating    | INT             | 1–5 stars       |
| comment   | TEXT            | Feedback        |
| created_at| TIMESTAMP       | Date            |
| user_id   | FK → users.id   | Reviewer        |
| product_id| FK → product.id | Product reviewed|

**Relationships:**
- ManyToOne → User
- ManyToOne → Product

---

## 🔗 Relationships Summary

**User Relationships**
- `users → orders` (1:M)
- `users → address` (1:M)
- `users → cart` (1:1)
- `users → review` (1:M)

**Product Relationships**
- `category → product` (1:M)
- `product → cart_item` (1:M)
- `product → order_item` (1:M)
- `product → review` (1:M)

**Order Relationships**
- `orders → order_item` (1:M)
- `orders → payment` (1:1)
- `address → orders` (1:M)

**Cart Relationships**
- `cart → cart_item` (1:M)
- `cart_item → product` (M:1)






This is a **Spring Boot** demo project named `practice` demonstrating the use of:

- Spring Boot Web
- Spring Data JPA
- MySQL database
- Spring Boot Actuator
- Lombok

---

## Project Information

- **Group ID:** `com.springboot`
- **Artifact ID:** `practice`
- **Version:** `0.0.1-SNAPSHOT`
- **Java Version:** `25`
- **Description:** Demo project for Spring Boot
- **License:** [Add your license here]

---

## Maven Dependencies

The project uses the following Maven dependencies:

| Dependency | Purpose |
|------------|---------|
| `spring-boot-starter-web` | For building REST APIs and web applications |
| `spring-boot-starter-data-jpa` | For working with JPA and Hibernate |
| `spring-boot-starter-actuator` | For monitoring and management |
| `spring-boot-devtools` | For hot reloading during development |
| `mysql-connector-j` | MySQL database driver |
| `lombok` | Reduce boilerplate code using annotations |
| `spring-boot-starter-test` | For unit and integration testing |

---


