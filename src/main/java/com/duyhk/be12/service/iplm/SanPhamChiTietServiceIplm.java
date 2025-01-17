package com.duyhk.be12.service.iplm;

import com.duyhk.be12.dto.SanPhamChiTietDTO;
import com.duyhk.be12.entity.MauSac;
import com.duyhk.be12.entity.SanPham;
import com.duyhk.be12.entity.SanPhamChiTiet;
import com.duyhk.be12.enums.Constants;
import com.duyhk.be12.repository.MauSacRepo;
import com.duyhk.be12.repository.SanPhamChiTietRepo;
import com.duyhk.be12.repository.SanPhamRepo;
import com.duyhk.be12.service.SanPhamChiTietService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SanPhamChiTietServiceIplm implements SanPhamChiTietService {

    @Autowired
    private SanPhamChiTietRepo sanPhamChiTietRepo;  // inject your repository here, for example, @Autowired private SanPhamChiTietRepo sanPhamChiTietRepo;  // inject your repository here, for example, @Autowired private SanPhamChiTietRepo sanPhamChiTietRepo;  // inject your repository here, for example, @Autowired private SanPhamChiTietRepo sanPhamChiTietRepo

    @Autowired
    private SanPhamRepo sanPhamRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MauSacRepo mauSacRepo;

    @Override
    public Page<SanPhamChiTietDTO> getAll(Integer page, Integer pageSize) {
        Page<SanPhamChiTiet> pageEntity = sanPhamChiTietRepo.findAll(PageRequest.of(page,pageSize));
    /** Cách 1: */
//        List<SanPhamChiTietDTO> listDto = pageEntity.getContent().stream()
//                .map(entity -> {
//                    SanPhamChiTietDTO dto = modelMapper.map(entity, SanPhamChiTietDTO.class);
//                    dto.setSanPhamId(entity.getSanPham().getId());
//                    return dto;
//                }).collect(Collectors.toList());
    /** Cách 2 :*/
        List<SanPhamChiTietDTO> listDto = new ArrayList<>();
        for(SanPhamChiTiet entity : pageEntity.getContent()){
            SanPhamChiTietDTO dto = modelMapper.map(entity, SanPhamChiTietDTO.class);
//            SanPhamChiTietDTO dto = new SanPhamChiTietDTO();
//            dto.setId(entity.getId());
//            dto.setTen(entity.getTen());
            //...
            dto.setSanPhamId(entity.getSanPham().getId());
            listDto.add(dto);
        }
        return new PageImpl<>(listDto,pageEntity.getPageable(),pageEntity.getTotalElements());
    }

    @Override
    public SanPhamChiTietDTO getById(Long id) {
        return null;
    }

    @Override
    public void create(SanPhamChiTietDTO dto) {
        SanPhamChiTiet entity = modelMapper.map(dto, SanPhamChiTiet.class);

        SanPham sanPham = sanPhamRepo.findById(dto.getSanPhamId()).orElse(null);
        if(sanPham == null) throw new RuntimeException(Constants.MESSAGE.NOT_FOUND);

        MauSac mauSac = mauSacRepo.findById(dto.getMauSac().getId()).orElse(null);
        if(mauSac == null) throw new RuntimeException(Constants.MESSAGE.NOT_FOUND);

        // validate
        Long soLuongTonKhoSanPham = sanPham.getSoLuongTonKho() + dto.getSoLuongTonKho();
        sanPham.setSoLuongTonKho(soLuongTonKhoSanPham);
        entity.setSanPham(sanPham);
        entity.setMauSac(mauSac);
        entity.setSoLuongDaBan(0l);
        sanPhamRepo.save(sanPham);
        sanPhamChiTietRepo.save(entity);
    }

    @Override
    public void update(SanPhamChiTietDTO dto, Long id) {
        SanPhamChiTiet sanPhamChiTiet = sanPhamChiTietRepo.findById(id).orElse(null);
        if(sanPhamChiTiet != null){
            SanPhamChiTiet entity = modelMapper.map(dto, SanPhamChiTiet.class);
            entity.setId(id);
            // update entity properties
            SanPham sanPham = sanPhamRepo.findById(dto.getSanPhamId()).orElse(null);
            if(sanPham == null) throw new RuntimeException(Constants.MESSAGE.NOT_FOUND);

            Long soLuongTonKhoSanPham = sanPham.getSoLuongTonKho() - sanPhamChiTiet.getSoLuongTonKho() + dto.getSoLuongTonKho();
            sanPham.setSoLuongTonKho(soLuongTonKhoSanPham);
            entity.setSanPham(sanPham);

            sanPhamRepo.save(sanPham);
            sanPhamChiTietRepo.save(entity);
        }
    }

    /*
        sp A: 56 <=> 56 - 32 + 16 => 40

        phân loai 1: 24
        phân loai 2: 32 -> 16
     */

    /*
        Sp B: 50 -> 20
        PL1: 20
        PL2: 30 // xoa bo
     */
    @Override
    public void delete(Long id) {
//        sanPhamChiTietRepo.deleteById(id);
        SanPhamChiTiet sanPhamChiTiet = sanPhamChiTietRepo.findById(id).orElse(null);
        if(sanPhamChiTiet!= null){
            SanPham sanPham = sanPhamRepo.findById(sanPhamChiTiet.getSanPham().getId()).orElse(null);
            if(sanPham == null) throw new RuntimeException(Constants.MESSAGE.NOT_FOUND);

            Long soLuongTonKhoSanPham = sanPham.getSoLuongTonKho() - sanPhamChiTiet.getSoLuongTonKho();
            sanPham.setSoLuongTonKho(soLuongTonKhoSanPham);
            sanPhamChiTiet.setTrangThai(0);
            sanPhamRepo.save(sanPham);
            sanPhamChiTietRepo.deleteById(id);
        }
    }
}
