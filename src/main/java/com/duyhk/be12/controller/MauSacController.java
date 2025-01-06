package com.duyhk.be12.controller;

import com.duyhk.be12.dto.MauSacDTO;
import com.duyhk.be12.service.MauSacService;
import com.duyhk.be12.service.iplm.MauSacServiceIplm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mau-sac")
//@Controller // mvc
public class MauSacController {

    @Autowired
    private MauSacService mauSacService;

    @GetMapping
    public List<MauSacDTO> getAll(){
        return mauSacService.getAll();
    }
}
