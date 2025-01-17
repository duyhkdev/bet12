package com.duyhk.be12.service.iplm;

import com.duyhk.be12.dto.MauSacDTO;
import com.duyhk.be12.entity.MauSac;
import com.duyhk.be12.repository.MauSacRepo;
import com.duyhk.be12.service.MauSacService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service // hieu class này là 1 bean -> lưu vao spring container
public class MauSacServiceIplm implements MauSacService {
// spring core
    @Autowired
    private MauSacRepo mauSacRepo; // luu vao sc

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<MauSacDTO> getAll(Integer page, Integer pageSize) { // 1 , 3
        Page<MauSac> pageEntity = mauSacRepo.findAll(PageRequest.of(page,pageSize));
        List<MauSacDTO> listDto = pageEntity.getContent().stream()
                .map(entity -> modelMapper.map(entity, MauSacDTO.class))
                .collect(Collectors.toList());
        return new PageImpl<>(listDto, pageEntity.getPageable(), pageEntity.getTotalElements());
    }

    @Override
    public void create(MauSacDTO dto) {
        mauSacRepo.save(modelMapper.map(dto, MauSac.class));
    }

    @Override
    public void update(MauSacDTO dto, Long id) {
        MauSac entity = modelMapper.map(dto, MauSac.class);
        entity.setId(id);
        mauSacRepo.save(entity);
    }

    @Override
    public void delete(Long id) {
        mauSacRepo.deleteById(id);
    }
}
