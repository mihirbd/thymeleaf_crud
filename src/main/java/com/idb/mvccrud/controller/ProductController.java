package com.idb.mvccrud.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.idb.mvccrud.entity.Product;
import com.idb.mvccrud.services.ProductService;

@Controller
@RequestMapping("/")
public class ProductController{

	@Autowired
	ProductService productService;
	
	@GetMapping("/")
	public String home() {
		return "redirect:list";
	}
	
	
	 @GetMapping("list")
	  public String getProduct(Model model) { 
	  List <Product> product= productService.getProduct();
	  model.addAttribute("productList", product);
	  return "index";
	  }
	 
	 @GetMapping("productForm")
	  public String addProduct(Model model) {
	  model.addAttribute("product", new Product());
	  return "products/products"; }
	  
	  @PostMapping("save")
	  public String AddProducts(@ModelAttribute Product product, RedirectAttributes redirAttrs, @RequestParam("userPhoto") MultipartFile photoFile ) throws Exception {
	  
		  byte[] bytes = photoFile.getBytes();
			String image = Base64.getEncoder().encodeToString(bytes);
			product.setImage(image);
		  
	  productService.saveProduct(product);
	  redirAttrs.addFlashAttribute("success", "Your Product save Succsessfully");
	  return "redirect:list";
	  
	  }
	  
	  @GetMapping("edit/{productID}")
	  public String editProduct(@PathVariable("productID") Long id, Model model) { 
	  Product product= productService.getProducts(id); 
	  model.addAttribute("product", product); 
	  return "products/products";
	  }
	  
	  @GetMapping("delete/{productID}")
	  public String deleteProduct(@PathVariable("productID") Long id) {
	  productService.deleteProduct(id);
	  return "redirect:/list"; }
	
	
}
