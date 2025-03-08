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
2. **Jalankan aplikasi menggunakan `docker-compose.yml`**
   ```sh
   docker-compose up -d
   ```
3. **Pastikan container berjalan**:
   ```sh
   docker ps
   ```
   Aplikasi akan berjalan di `http://localhost:9090`.

## 3. Mengakses API dengan Postman

### Contoh Request

- **Cek status aplikasi**:
  ```sh
  GET http://localhost:9090/users/list
  ```
- **Endpoint lain** dapat disesuaikan sesuai dengan API aplikasi Anda.

## 4. Menutup Aplikasi

- Jika dijalankan secara manual:
  ```sh
  CTRL + C
  ```
- Jika menggunakan Docker Compose:
  ```sh
  docker-compose down
  ```

