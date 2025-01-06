package com.duyhk.be12.service.iplm;

import com.duyhk.be12.dto.MauSacDTO;
import com.duyhk.be12.entity.MauSac;
import com.duyhk.be12.repository.MauSacRepo;
import com.duyhk.be12.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // hieu class này là 1 bean -> lưu vao spring container
public class MauSacServiceIplm implements MauSacService {
// spring core
    @Autowired
    private MauSacRepo mauSacRepo; // luu vao sc

    @Override
    public List<MauSacDTO> getAll() {
        List<MauSac> listEntity = mauSacRepo.findAll();
        List<MauSacDTO> listDto = new ArrayList<>();

        for (MauSac entity : listEntity) {

            MauSacDTO ms = new MauSacDTO(); // 1
            ms.setId(entity.getId());
            ms.setTen(entity.getTen());

            listDto.add(ms);
        }
        return listDto;
    }
}
