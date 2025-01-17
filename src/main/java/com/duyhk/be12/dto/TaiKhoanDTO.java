package com.duyhk.be12.dto;

import com.duyhk.be12.enums.Constants;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaiKhoanDTO {
    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$",
     message = Constants.MESSAGE.INVALID_PHONE_NUMBER)
    private String soDienThoai;
    public String matKhau;
}
