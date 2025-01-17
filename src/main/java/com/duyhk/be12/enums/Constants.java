package com.duyhk.be12.enums;

public class Constants {
    public static class STATUS {
        public static final int SUCCESS = 200;
        public static final int NOT_FOUND = 404;
    }

    public static class MESSAGE {
        public static final String GET_SUCCESS = "Lấy dữ liệu thành công!";
        public static final String CREATE_SUCCESS = "Tạo mới dữ liệu thành công!";
        public static final String UPDATE_SUCCESS = "Cập nhật dữ liệu thành công!";
        public static final String DELETE_SUCCESS = "Xóa dữ liệu thành công!";
        public static final String NOT_FOUND = "Không tìm thấy dữ liệu!";
        public static final String VALIDATION_ERROR = "Dữ liệu không hợp lệ!";
        public static final String VALIDATE_TEN = "Vui lòng nhập tên!";
        public static final String ERROR_GIA_IS_NULL = "Vui lòng nhập giá!";
        public static final String ERROR_GIA_LESS_THAN_MIN = "Vui lòng nhập giá lớn hơn 10000!";
        public static final String INVALID_PHONE_NUMBER = "Số điện thoại không hợp lệ!";
    }
}
