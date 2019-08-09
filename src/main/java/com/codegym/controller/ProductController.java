package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")

public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/home")
    public ModelAndView findAll(Pageable pageable){
        Page<Product> products = productService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products",products);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("product") Product product){
        ModelAndView modelAndView = new ModelAndView("/product/create");
        productService.save(product);
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }
    @GetMapping({"/delete/{id}"})
    public ModelAndView showDeleteform(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("/product/delete");
        modelAndView.addObject("product",productService.findById(id));
        return modelAndView;
    }
    @PostMapping("/delete")
    public ModelAndView delete(@ModelAttribute("product") Product product){
        ModelAndView modelAndView = new ModelAndView("/product/list");
        productService.delete(product.getId());
        modelAndView.addObject("products",productService.findAll(new PageRequest(10,10)));
        modelAndView.addObject("message","deleted!");
        return modelAndView;
    }
    @GetMapping({"/view/{id}"})
    public ModelAndView view(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("/product/view");
        modelAndView.addObject("product",productService.findById(id));
        return modelAndView;
    }
}
