package com.example.repositorie;

import com.example.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public interface ISanPhamRepositorie extends JpaRepository<SanPham,Integer> {

    List<SanPham> findSanPhamsByNameContaining(String search);
}
