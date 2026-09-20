# ĐỒ ÁN: TÌM HIỂU HỆ QUẢN TRỊ CSDL HƯỚNG ĐỐI TƯỢNG MÃ NGUỒN MỞ DB4O
> **Ứng dụng thực nghiệm:** Hệ thống Quản lý Sinh viên (Java & db4o)

---

## 📌 1. Giới thiệu tổng quan
Đồ án tập trung nghiên cứu **Hệ Quản trị CSDL Hướng đối tượng (OODBMS) mã nguồn mở db4o (Database for Objects)**. Dự án minh họa cách lưu trữ trực tiếp các đối tượng Java (Java Objects) vào đĩa cứng mà không cần sử dụng tầng trung gian chuyển đổi ORM (như Hibernate/JDBC) hay các bảng CSDL quan hệ (RDBMS).

### Key Features của db4o:
* **Zero Mapping Overhead:** Lưu trữ nguyên bản Java POJO trực tiếp vào file CSDL (`.db4o`).
* **Embedded Mode:** Chạy trực tiếp bên trong ứng dụng Java mà không cần cài đặt CSDL Server độc lập.
* **Native Query (NQ):** Cho phép truy vấn dữ liệu bằng cú pháp mã nguồn Java type-safe 100%.

---

## 📂 2. Cấu trúc thư mục dự án (Directory Structure)

```text
QuanLySinhVien_db4o/
├── .vscode/                   # Cấu hình dự án cho Visual Studio Code
│   ├── launch.json            # Cấu hình Run/Debug Java
│   └── settings.json          # Cấu hình đường dẫn thư viện Java
├── lib/                       # Thư viện ngoài (External Libraries)
│   └── db4o-8.0-java5.jar     # File JAR thư viện db4o
├── bin/                       # Thư mục chứa file class sau khi biên dịch (Auto-generated)
├── src/                       # Mã nguồn chương trình (Source code)
│   ├── model/                 # Tầng dữ liệu / Lớp đối tượng (Entities/POJO)
│   │   └── SinhVien.java      # Lớp đối tượng SinhVien
│   ├── dao/                   # Tầng xử lý CSDL (Data Access Object)
│   │   └── SinhVienDAO.java   # Xử lý CRUD và Native Query với db4o
│   └── Main.java              # Chương trình chính chạy Demo ứng dụng
├── sinhvien.db4o              # File cơ sở dữ liệu của db4o (Tự động tạo khi chạy)
├── doc/                       # Tài liệu đồ án để nộp
│   ├── BaoCao_DoAn_db4o.docx  # File báo cáo Word chi tiết
│   └── ThuyetTrinh_db4o.pptx  # Slide thuyết trình PowerPoint
└── README.md                  # Tài liệu hướng dẫn dự án