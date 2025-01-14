# Báo Cáo Kiểm Thử Tính Năng Đăng Nhập

## 1. Mục đích báo cáo

Mục tiêu của báo cáo này là mô tả quy trình và kết quả thử nghiệm đối với tính năng đăng nhập trong ứng dụng web. Các bài kiểm tra được thực hiện để đảm bảo rằng hệ thống xử lý đúng các trường hợp đăng nhập hợp lệ và không hợp lệ, bao gồm cả việc kiểm tra thông báo lỗi khi người dùng nhập sai thông tin hoặc để trống các trường.

## 2. Phạm vi kiểm thử

- Kiểm thử chức năng đăng nhập của trang web.
- Kiểm tra tính năng hiển thị thông báo lỗi khi:
  - Đăng nhập thành công.
  - Nhập thông tin sai.
  - Để trống trường tên người dùng và mật khẩu.

## 3. Các trường hợp kiểm thử

### Kiểm tra đăng nhập thành công (`testSuccessfulLogin`)
- **Mô tả**: Kiểm tra xem hệ thống có cho phép đăng nhập khi người dùng nhập đúng tên người dùng và mật khẩu.
- **Dữ liệu đầu vào**:
  - Tên người dùng: `admin`
  - Mật khẩu: `admin123`
- **Kết quả mong đợi**: Không hiển thị thông báo lỗi. Đăng nhập thành công.
- **Kết quả thực tế**: Sau khi nhập thông tin và nhấn nút đăng nhập, hệ thống không hiển thị thông báo lỗi, chứng tỏ đăng nhập thành công.

### Kiểm tra đăng nhập không thành công với mật khẩu sai (`testInvalidLogin`)
- **Mô tả**: Kiểm tra xem hệ thống có hiển thị thông báo lỗi khi người dùng nhập sai mật khẩu.
- **Dữ liệu đầu vào**:
  - Tên người dùng: `admin`
  - Mật khẩu: `wrongpass`
- **Kết quả mong đợi**: Hiển thị thông báo lỗi "Tên người dùng hoặc mật khẩu không đúng".
- **Kết quả thực tế**: Sau khi nhập thông tin và nhấn nút đăng nhập, hệ thống hiển thị thông báo lỗi đúng như mong đợi.

### Kiểm tra đăng nhập khi để trống trường (`testEmptyFields`)
- **Mô tả**: Kiểm tra xem hệ thống có hiển thị thông báo lỗi khi người dùng không nhập tên người dùng và mật khẩu.
- **Dữ liệu đầu vào**:
  - Tên người dùng: `""`
  - Mật khẩu: `""`
- **Kết quả mong đợi**: Hiển thị thông báo lỗi "Vui lòng nhập tên người dùng và mật khẩu".
- **Kết quả thực tế**: Sau khi để trống thông tin và nhấn nút đăng nhập, hệ thống hiển thị thông báo lỗi yêu cầu nhập tên người dùng và mật khẩu.

## 4. Các bước thực hiện kiểm thử

1. **Bước 1**: Mở trang web và đi đến phần đăng nhập.
2. **Bước 2**: Thực hiện các bài kiểm tra sau:
   - Nhập thông tin hợp lệ (admin, admin123) và nhấn nút đăng nhập.
   - Nhập thông tin không hợp lệ (admin, wrongpass) và nhấn nút đăng nhập.
   - Để trống các trường thông tin và nhấn nút đăng nhập.
3. **Bước 3**: Kiểm tra các thông báo lỗi hiển thị (nếu có).
4. **Bước 4**: Đảm bảo không có lỗi phát sinh trong quá trình thử nghiệm.

## 5. Công cụ sử dụng

- **Selenium WebDriver**: Để tự động hóa trình duyệt và thực hiện các bài kiểm tra chức năng.
- **JUnit**: Để viết và thực hiện các bài kiểm tra đơn vị (unit test).
- **WebDriverWait**: Để chờ và kiểm tra sự xuất hiện của các thông báo lỗi.

## 6. Kết quả kiểm thử

- **Test Successful Login**: Đã thực hiện thành công. Không hiển thị thông báo lỗi khi thông tin đăng nhập đúng.
- **Test Invalid Login**: Đã thực hiện thành công. Hệ thống hiển thị thông báo lỗi "Tên người dùng hoặc mật khẩu không đúng" khi mật khẩu sai.
- **Test Empty Fields**: Đã thực hiện thành công. Hệ thống yêu cầu người dùng nhập tên người dùng và mật khẩu nếu trường thông tin bị bỏ trống.

## 7. Phân tích và đánh giá

- Hệ thống hoạt động chính xác theo các kịch bản kiểm thử đã đề ra. Các thông báo lỗi được hiển thị đúng cách khi người dùng nhập sai thông tin hoặc để trống các trường.
- Không có lỗi phát sinh trong quá trình kiểm thử. Hệ thống đảm bảo tính bảo mật và chính xác trong việc xử lý thông tin đăng nhập.

## 8. Kết luận

Các bài kiểm thử đăng nhập đã được thực hiện thành công và đạt được kết quả như mong đợi. Tất cả các trường hợp kiểm thử (đăng nhập thành công, đăng nhập không hợp lệ và để trống các trường) đều được xử lý đúng đắn. Do đó, tính năng đăng nhập của hệ thống đã sẵn sàng để triển khai trong môi trường sản xuất.

---

## 9. Đề xuất cải tiến

- Cần thêm kiểm thử cho các trường hợp khác, như đăng nhập với tài khoản bị khóa hoặc mật khẩu không hợp lệ trong cơ sở dữ liệu.
- Thực hiện kiểm thử tự động trên nhiều trình duyệt khác nhau để đảm bảo tính tương thích.

## 10. Phụ lục

- **Mã nguồn kiểm thử**: Đã được đính kèm ở phần đầu báo cáo.
- **Môi trường kiểm thử**: Selenium WebDriver, JUnit, trình duyệt Chrome, hệ điều hành Windows.

---

**Ký tên**  
Người kiểm thử: [Tên người kiểm thử]  
Ngày: [Ngày kiểm thử]
