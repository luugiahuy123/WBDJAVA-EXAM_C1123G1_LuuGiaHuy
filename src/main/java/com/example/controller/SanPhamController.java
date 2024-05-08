package com.example.controller;

import com.example.model.SanPham;
import com.example.service.ILoaiSPService;
import com.example.service.ISanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class SanPhamController {
    @Autowired
    private ISanPhamService iSanPhamService;
    @Autowired
    private ILoaiSPService iLoaiSPService;

    @GetMapping("/")
    public String showList(Model model ){
        List<SanPham> sanPhams = iSanPhamService.getAll();
        model.addAttribute("sanPham",sanPhams);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("sanPham", new SanPham());
        model.addAttribute("loai" , iLoaiSPService.getAll());
        return "create";
    }
    @PostMapping("/create")
    public String creat(@Valid @ModelAttribute("sanPham") SanPham sanPham , BindingResult bindingResult , Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("loai", iLoaiSPService.getAll());
            return "create";
        }
        iSanPhamService.saveSanPham(sanPham);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        iSanPhamService.deleteSanPham(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id") Integer id , Model model){
        SanPham sanPham = iSanPhamService.findByid(id);
        model.addAttribute("sanPham" , sanPham);
        model.addAttribute("loai",iLoaiSPService.getAll());
        return "edit";
    }
    @PostMapping("/edit")
    public String editSP(@Valid @ModelAttribute("sanPham") SanPham sanPham , BindingResult bindingResult , Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("sanPham" , sanPham);
            model.addAttribute("loai",iLoaiSPService.getAll());
            return "edit";
        }
        iSanPhamService.saveSanPham(sanPham);
        return "redirect:/";
    }
}
