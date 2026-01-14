# Bài 1: Can't Unsee - UI Testing Practice

## 1. Giới thiệu (Introduction)
* **Người thực hiện:** Bùi Trọng Nghĩa
* **Mã sinh viên:** BIT230288
* **Mục tiêu:** Rèn luyện kỹ năng kiểm thử giao diện (UI Testing), phát hiện các lỗi sai lệch nhỏ trong thiết kế (Pixel-perfect).

## 2. Kết quả thực hiện (Results)
Dưới đây là kết quả bài kiểm tra của tôi:
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/c2e7e699-ad78-4956-b262-139fb5c19f0c" />


## 3. Phân tích & Bài học (Key Takeaways)
Qua bài tập này, tôi đã học được cách phân biệt các lỗi UI thường gặp như:
* **Alignment (Căn chỉnh):** Sự lệch lạc nhỏ về vị trí giữa các phần tử.
* **Typography (Kiểu chữ):** Sự khác biệt về font-weight (độ đậm nhạt) và kerning (khoảng cách chữ).
* **Contrast & Color (Tương phản & Màu sắc):** Các lỗi về độ tương phản khiến văn bản khó đọc.
* **Consistency (Tính nhất quán):** Các icon hoặc nút bấm không đồng bộ về kích thước/kiểu dáng.

## 4. Kết luận
Bài tập giúp cải thiện đáng kể sự chú ý đến chi tiết (Attention to Detail) - một kỹ năng quan trọng của QA/QC.




# Bài 2: Student Grade Analyzer 

Dự án thực hành kiểm thử phần mềm (Software Testing) với Java và JUnit 5.
Chương trình cung cấp các chức năng phân tích điểm số học sinh và đảm bảo tính đúng đắn thông qua các ca kiểm thử đơn vị (Unit Tests).

## Mục tiêu dự án
1.  **Phát triển chức năng:** Xử lý logic nghiệp vụ tính toán điểm số (Data Analysis).
2.  **Kiểm thử tự động:** Viết test case bao phủ các trường hợp bằng JUnit 5.
3.  **Ứng dụng AI:** Sử dụng AI để hỗ trợ sinh dữ liệu test và review code.

## Công nghệ sử dụng
* **Ngôn ngữ:** Java (JDK 17+)
* **Build Tool:** Maven
* **Testing Framework:** JUnit 5 (Jupiter)
* **IDE:** IntelliJ IDEA

## Các chức năng chính

| Tên hàm | Mô tả |
| :--- | :--- |
| `countExcellentStudents` | Đếm số học sinh giỏi (Điểm >= 8.0). Bỏ qua điểm không hợp lệ (<0 hoặc >10). |
| `calculateValidAverage` | Tính điểm trung bình cộng của các điểm hợp lệ. Trả về 0 nếu danh sách rỗng. |

## Chiến lược kiểm thử (Test Strategy)
Các test case được thiết kế để bao phủ toàn diện các tình huống sau:

* **Happy Path (Trường hợp thường):**
    * Danh sách chứa điểm hợp lệ, hỗn hợp điểm giỏi/khá/trung bình.
* **Boundary Testing (Kiểm thử biên):**
    * Biên dưới: `0.0`
    * Biên trên: `10.0`
    * Ngưỡng giỏi: `8.0`, `7.99`
* **Invalid Data (Dữ liệu lỗi):**
    * Điểm âm (ví dụ: `-1.0`, `-50.0`)
    * Điểm lớn hơn 10 (ví dụ: `10.1`, `100.0`)
* **Edge Cases (Trường hợp ngoại lệ):**
    * Danh sách rỗng (`empty list`).
    * Danh sách toàn điểm sai (không có điểm nào hợp lệ).

## kết quả thực hiện
Dưới đây là kết quả chạy test:
<img width="1606" height="956" alt="image" src="https://github.com/user-attachments/assets/90fb3a22-9ec9-46f8-93af-90b652d1208b" />

## Cấu trúc dự án
```text
src
├── main
│   └── java/com/example
│       └── StudentAnalyzer.java      # Logic chính
└── test
    └── java/com/example
        └── StudentAnalyzerTest.java  # Các ca kiểm thử (Unit Tests)
