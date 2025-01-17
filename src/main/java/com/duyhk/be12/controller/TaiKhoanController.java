package com.duyhk.be12.controller;

import com.duyhk.be12.dto.ResponseDTO;
import com.duyhk.be12.dto.TaiKhoanDTO;
import com.duyhk.be12.enums.Constants;
import com.duyhk.be12.service.iplm.TaiKhoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class TaiKhoanController {
    @Autowired
    private TaiKhoanService taiKhoanService;

    @PostMapping("/register")
    public ResponseDTO<Void> register(@RequestBody @Valid TaiKhoanDTO dto){
        taiKhoanService.register(dto);
        return ResponseDTO.<Void>builder()
                .statusCode(Constants.STATUS.SUCCESS)
                .message(Constants.MESSAGE.CREATE_SUCCESS)
                .build();
    }
}
