package com.codegym.controller;

import com.codegym.model.MyCart;
import com.codegym.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("myCart")
public class CartController {
    @ModelAttribute("myCart")
    public MyCart setUpMyCart(){
        return new MyCart();
    }
    @PostMapping("/add-to-cart")
    public ModelAndView getCart(@ModelAttribute("myCart") MyCart myCart, @ModelAttribute("product")Product product){
        ModelAndView modelAndView = new ModelAndView("/cart/list");
        myCart.addToCart(product);
        return modelAndView;
    }
}
