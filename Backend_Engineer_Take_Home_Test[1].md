
# IST : Take-Home Test: Back-End Engineer (Spring Boot)

## Tujuan
Menguji kemampuan kandidat dalam:
1. Mendesain dan mengembangkan RESTful API menggunakan Spring Boot.
2. Mengelola data dengan database relasional menggunakan Spring Data JPA.
3. Menerapkan konsep arsitektur perangkat lunak yang baik.
4. Menulis kode yang terstruktur, bersih, dan dapat diuji.
5. Memahami dan mengimplementasikan fitur tambahan seperti autentikasi, pagination, atau deployment menggunakan Docker.

---

## Instruksi Umum
1. Buat sebuah RESTful API untuk sistem pengelolaan transaksi keuangan.
2. Gunakan **Spring Boot** sebagai framework utama.
3. Aplikasi ini harus mampu menangani data pengguna, akun, dan transaksi, dengan ketentuan seperti yang dijelaskan di bawah.
4. Serahkan hasil pekerjaan dalam repository Git Local dengan dokumentasi lengkap.

---

## Spesifikasi Fitur dan Detail

### 1. User Management
Buatlah API untuk mengelola data pengguna dengan fitur berikut:
- **Membuat Pengguna**: Endpoint untuk menambahkan pengguna baru.
  - Input:
    ```json
    {
      "name": "John Doe",
      "email": "johndoe@example.com"
    }
    ```
  - Output:
    ```json
    {
      "id": "UUID",
      "name": "John Doe",
      "email": "johndoe@example.com",
      "created_at": "2024-01-01T10:00:00Z"
    }
    ```
- **Membaca Daftar Pengguna**: Endpoint untuk mendapatkan daftar semua pengguna.
- **Membaca Detail Pengguna**: Endpoint untuk membaca detail pengguna berdasarkan `id`.
- **Memperbarui Pengguna**: Endpoint untuk memperbarui data pengguna.
- **Menghapus Pengguna**: Endpoint untuk menghapus pengguna berdasarkan `id`.

Atribut pengguna:
- `id` (UUID)
- `name` (String)
- `email` (String, unik, dengan validasi email)
- `created_at` (Timestamp, otomatis diisi saat data dibuat)

---

### 2. Account Management
Setiap pengguna dapat memiliki satu atau lebih akun. Buat API untuk:
- **Membuat Akun**: Endpoint untuk menambahkan akun baru ke pengguna yang sudah ada.
  - Input:
    ```json
    {
      "user_id": "UUID",
      "initial_balance": 1000.00
    }
    ```
  - Output:
    ```json
    {
      "id": "UUID",
      "user_id": "UUID",
      "balance": 1000.00,
      "created_at": "2024-01-01T10:00:00Z"
    }
    ```
- **Membaca Akun Pengguna**: Endpoint untuk mendapatkan semua akun milik pengguna tertentu.

Atribut akun:
- `id` (UUID)
- `user_id` (UUID, foreign key ke pengguna)
- `balance` (BigDecimal, saldo awal dapat 0 atau diatur oleh input)
- `created_at` (Timestamp, otomatis diisi saat data dibuat)

---

### 3. Transaction Management
Setiap akun dapat memiliki beberapa transaksi. Buat API untuk:
- **Mencatat Transaksi Baru**:
  - Input:
    ```json
    {
      "account_id": "UUID",
      "type": "DEBIT",
      "amount": 200.00
    }
    ```
  - Rules:
    - Tipe transaksi (`type`) dapat berupa `DEBIT` atau `CREDIT`.
    - Untuk transaksi `DEBIT`, pastikan saldo akun mencukupi sebelum melakukan pengurangan saldo.
    - Perbarui saldo akun setelah transaksi berhasil.
  - Output:
    ```json
    {
      "id": "UUID",
      "account_id": "UUID",
      "type": "DEBIT",
      "amount": 200.00,
      "timestamp": "2024-01-01T11:00:00Z"
    }
    ```
- **Mendapatkan Histori Transaksi**:
  - Endpoint untuk mengambil histori transaksi pada akun tertentu.
  - Tambahkan fitur **pagination** (misalnya, parameter `page` dan `size`).

Atribut transaksi:
- `id` (UUID)
- `account_id` (UUID, foreign key ke akun)
- `type` (enum: `DEBIT` atau `CREDIT`)
- `amount` (BigDecimal)
- `timestamp` (Timestamp, otomatis diisi saat data dibuat)

---

### 4. Reporting
Buat endpoint untuk mendapatkan laporan transaksi:
- Input:
  - Parameter query: `type` (opsional: `DEBIT` atau `CREDIT`), `start_date`, dan `end_date`.
- Output:
  ```json
  {
    "type": "DEBIT",
    "total_transactions": 5,
    "total_amount": 1000.00
  }
  ```

---

## Teknologi dan Tools
- **Spring Boot** (versi 2.7+ atau 3.x).
- **PostgreSQL** sebagai database (gunakan Spring Data JPA).
- Pilihan untuk dokumentasi API:
  - Swagger/OpenAPI (preferred).
  - Postman Collection.
- Dependency Management: **Maven** atau **Gradle**.

---

## Kriteria Tambahan
1. Implementasi **JWT Authentication**: Tambahkan fitur login/logout dan autentikasi token.
2. **Dockerization**: Siapkan file Docker untuk menjalankan aplikasi dan database.
3. **Kustom Query**: Tambahkan endpoint untuk mendapatkan semua akun dengan saldo lebih dari jumlah tertentu.

---

## Kriteria Penilaian
1. **Fungsionalitas**: Semua fitur utama bekerja sesuai deskripsi.
2. **Kualitas Kode**:
   - Bersih, modular, dan menggunakan prinsip **SOLID**.
   - Mengikuti praktik terbaik dalam pengelolaan dependency Spring Boot.
3. **Pengujian**:
   - Unit test dan integration test memiliki cakupan yang baik.
   - Gunakan framework seperti **JUnit** atau **Mockito**.
4. **Dokumentasi**:
   - API mudah diakses dan dipahami (Swagger atau Postman).
   - README berisi panduan instalasi dan penggunaan aplikasi.
   - Git History.
5. **Bonus Features**: Implementasi fitur opsional mendapat poin tambahan.

---

## Pengumpulan Hasil
1. Upload GIT Archieve ke google form melalui link https://forms.gle/KyRqivAMQGK2zrUA8
2. Repository harus mencakup:
   - Kode sumber lengkap.
   - File README.md dengan:
     - Cara menjalankan aplikasi secara lokal.
     - Struktur proyek dan deskripsi endpoint.
     - Panduan menjalankan tes.
   - File `docker-compose.yml` (jika menggunakan Docker).
   - File dokumentasi API (jika tidak menggunakan Swagger).
3. Pastikan kode Anda dapat dijalankan tanpa masalah.

**Deadline:** 3-5 hari setelah menerima soal.

---

Jika Anda memerlukan klarifikasi lebih lanjut, beri tahu kami!
