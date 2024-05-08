package com.example.service;

import com.example.model.SanPham;
import com.example.repositorie.ISanPhamRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamService implements ISanPhamService{
    @Autowired
    private ISanPhamRepositorie sanPhamRepositorie;
    @Override
    public List<SanPham> getAll() {
        return sanPhamRepositorie.findAll();
    }

    @Override
    public void saveSanPham(SanPham sanPham) {
        sanPhamRepositorie.save(sanPham);
    }

    @Override
    public SanPham findByid(Integer id) {
        return sanPhamRepositorie.findById(id).get();
    }

    @Override
    public void deleteSanPham(Integer id) {
        sanPhamRepositorie.deleteById(id);
    }


}
