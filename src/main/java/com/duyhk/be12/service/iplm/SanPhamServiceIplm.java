package com.duyhk.be12.service.iplm;

import com.duyhk.be12.dto.SanPhamDTO;
import com.duyhk.be12.entity.SanPham;
import com.duyhk.be12.enums.Constants;
import com.duyhk.be12.enums.TrangThai;
import com.duyhk.be12.repository.SanPhamRepo;
import com.duyhk.be12.service.SanPhamService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SanPhamServiceIplm implements SanPhamService {

    @Autowired
    private SanPhamRepo sanPhamRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<SanPhamDTO> getAll(Integer page, Integer pageSize) {
        Page<SanPham> pageEntity = sanPhamRepo.findAll(PageRequest.of(page,pageSize));
        List<SanPhamDTO> result = pageEntity.getContent().stream()
                .map(entity -> modelMapper.map(entity,SanPhamDTO.class))
                .collect(Collectors.toList());
        return new PageImpl<>(result,pageEntity.getPageable(),pageEntity.getTotalElements());
    }

    @Override
    public void create(SanPhamDTO dto) throws IOException {
        SanPham entity = modelMapper.map(dto, SanPham.class);
        processFileSaveToServer(entity, dto.getFiles());
        entity.setSoLuongDaBan(0l);
        entity.setSoLuongTonKho(0l);
        entity.setGia(0l);
        sanPhamRepo.save(entity);
    }

    @Override
    public void update(SanPhamDTO dto, Long id) throws IOException {
        SanPham entity = modelMapper.map(dto, SanPham.class);
        dto.setId(id);
        processFileSaveToServer(entity, dto.getFiles());
        sanPhamRepo.save(entity);
    }

    @Override
    public void delete(Long id) {
        SanPham sanPham = sanPhamRepo.findById(id).orElse(null);
        sanPham.setTrangThai(0);
        sanPhamRepo.save(sanPham);
    }

    private void processFileSaveToServer(SanPham entity, List<MultipartFile> files) throws IOException {
        if(files == null && entity.getId() == null){
            throw new RuntimeException(Constants.MESSAGE.VALIDATION_ERROR);
        }
        List<String> listPath = new ArrayList<>();
        for (MultipartFile file : files) {
            String tenFile = file.getOriginalFilename();
            String pathFolder = "D:\\workspace_learning\\be12\\images";
            File folder = new File(pathFolder);
            /** Kiem tra va tạo folder */
            if(!folder.exists()) folder.mkdirs();

            File fileUpload = new File(pathFolder + "\\" + tenFile);
            file.transferTo(fileUpload);
            listPath.add(pathFolder + "\\" + tenFile);
        }

        entity.setAnhSanPhamUrl(listPath);
    }
}
/*
    Ví dụ: 1 sản phẩn: quần âu nam hàn quốc  30 29


    Phân loại 1: Đen   M 15 14
    Phân loại 2: Trắng M 15
 */
