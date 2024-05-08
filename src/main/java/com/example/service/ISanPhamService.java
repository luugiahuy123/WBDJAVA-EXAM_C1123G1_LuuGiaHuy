package com.example.service;

import com.example.model.SanPham;

import java.util.List;

public interface ISanPhamService {
    List<SanPham> getAll();

    void saveSanPham(SanPham sanPham);

    

    SanPham findByid(Integer id);

    void deleteSanPham(Integer id);
}
