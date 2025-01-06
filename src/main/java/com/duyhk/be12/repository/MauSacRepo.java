package com.duyhk.be12.repository;

import com.duyhk.be12.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MauSacRepo extends JpaRepository<MauSac, Long> {
    // save, update, delete, select, ...
}
