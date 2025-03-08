# Spring Boot Application Guide

## 1. Menjalankan Aplikasi Secara Manual

### Persyaratan:
- Java 17 atau yang lebih baru
- Maven 3.8+
- Postman untuk uji API

### Langkah-Langkah:
1. **Clone repository** (jika belum ada):
   ```sh
   git clone https://github.com/xphobia404/ftm
   cd your-repo
   ```
2. **Build aplikasi** menggunakan Maven:
   ```sh
   mvn clean package
   ```
3. **Jalankan aplikasi**:
   ```sh
   java -jar target/ftm.jar
   ```

Aplikasi akan berjalan di `http://localhost:9090`.

## 2. Menjalankan Aplikasi dengan Docker Compose

### Persyaratan:
- Docker
- Docker Compose

### Langkah-Langkah:
1. **Build image Docker**:
   ```sh
   docker build -t your-app .
   ```
2. **Jalankan aplikasi menggunakan `docker-compose.yml`**:
   ```sh
   docker-compose up -d
   ```
3. **Pastikan container berjalan**:
   ```sh
   docker ps
   ```
   Aplikasi akan berjalan di `http://localhost:9090`.

## 3. Mengakses API dengan Postman

### Import Collection Postman
Import file `NDS.postman_collection.json` ke aplikasi Postman, lalu gunakan sesuai dengan body yang telah disediakan.

### Daftar Endpoint
#### Users
- **Insert User**: `POST /users/insert`
- **List Users**: `GET /users/list`
- **User Detail**: `POST /users/detail`
- **Update User**: `POST /users/update`
- **Delete User**: `POST /users/delete`

#### Accounts
- **Insert Account**: `POST /accounts/insert`
- **List Accounts**: `GET /accounts/list`
- **Account Detail**: `POST /accounts/detail`
- **Find Accounts by Balance**: `POST /accounts/find`

#### Transactions
- **Insert Transaction**: `POST /transactions/insert`
- **List Transactions (Pagination)**: `GET /transactions/list?page={page}&size={size}`
- **Transaction Detail**: `POST /transactions/detail`
- **Transaction Report**: `POST /transactions/report`

## 4. Menutup Aplikasi
- Jika dijalankan secara manual:
  ```sh
  CTRL + C
  ```
- Jika menggunakan Docker Compose:
  ```sh
  docker-compose down
  ```