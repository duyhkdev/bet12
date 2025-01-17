package com.duyhk.be12.controller;

import com.duyhk.be12.dto.MauSacDTO;
import com.duyhk.be12.dto.ResponseDTO;
import com.duyhk.be12.enums.Constants;
import com.duyhk.be12.service.MauSacService;
import com.duyhk.be12.service.iplm.MauSacServiceIplm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mau-sac")
//@Controller // mvc
public class MauSacController {

    @Autowired
    private MauSacService mauSacService;

    @GetMapping
    public ResponseDTO<List<MauSacDTO>> getAll(@RequestParam Integer page, // trang hiện tại
                              @RequestParam Integer pageSize // số bản ghi trên 1 trang
    ){

        Page<MauSacDTO> pageDto = mauSacService.getAll(page, pageSize);
        return ResponseDTO.<List<MauSacDTO>>builder()
                .data(pageDto.getContent())
                .totalElement(pageDto.getTotalElements())
                .totalPages(pageDto.getTotalPages())
                .statusCode(Constants.STATUS.SUCCESS)
                .message(Constants.MESSAGE.GET_SUCCESS)
                .build();
    }

    @PostMapping
    public ResponseDTO<Void> create(@RequestBody MauSacDTO dto){
        mauSacService.create(dto);
        return  ResponseDTO.<Void>builder()
                .statusCode(Constants.STATUS.SUCCESS)
                .message(Constants.MESSAGE.CREATE_SUCCESS)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseDTO<Void> update(
            @PathVariable Long id,
            @RequestBody MauSacDTO dto){
        mauSacService.update(dto, id);
        return  ResponseDTO.<Void>builder()
                .statusCode(Constants.STATUS.SUCCESS)
                .message(Constants.MESSAGE.UPDATE_SUCCESS)
                .build();
    }
    @DeleteMapping("/{id}")
    public ResponseDTO<Void> delete(@PathVariable Long id){
        mauSacService.delete(id);
        return  ResponseDTO.<Void>builder()
                .statusCode(Constants.STATUS.SUCCESS)
                .message(Constants.MESSAGE.DELETE_SUCCESS)
               .build();
    }
}
