package com.example.repositorie;

import com.example.model.LoaiSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoaiSPRepositorie extends JpaRepository<LoaiSanPham,Integer> {
}
