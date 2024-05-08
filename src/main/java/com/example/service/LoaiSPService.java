package com.example.service;

import com.example.model.LoaiSanPham;
import com.example.repositorie.ILoaiSPRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiSPService implements ILoaiSPService {
    @Autowired
    private ILoaiSPRepositorie iLoaiSPRepositorie;
    @Override
    public List<LoaiSanPham> getAll() {
        return iLoaiSPRepositorie.findAll();
    }
}
