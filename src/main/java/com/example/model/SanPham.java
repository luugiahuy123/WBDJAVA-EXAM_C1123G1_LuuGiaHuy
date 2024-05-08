package com.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import javax.validation.constraints.NotEmpty;


@Entity
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 5, max = 50, message = "Phải từ 5 ký tự tớ lên và ko được quá 50")
    private String name;

    @NotNull(message = "Ko được để trống")
    @Min(value = 100000 , message = "giá phải lớn hơn 100,000VND")
    private Integer price;

    @NotBlank(message = "ko được để trống")
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_loai_sp" , referencedColumnName = "id")
    private LoaiSanPham loaiSanPham;

    public SanPham() {
    }

    public SanPham(Integer id, String name, Integer price, String status, LoaiSanPham loaiSanPham) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
        this.loaiSanPham = loaiSanPham;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LoaiSanPham getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
