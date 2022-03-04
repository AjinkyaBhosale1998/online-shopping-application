package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.serviceImpl.CategoryServiceImpl;
import com.example.demo.serviceImpl.ProductServiceImpl;
import com.example.demo.services.CategoryService;

@Controller //admin controller
public class AdminController {
	public static String uploadDir=System.getProperty("user.dir")+"/src/main/resources/static/productImages";
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	@Autowired
	 private ProductServiceImpl productServiceImpl;
	@GetMapping("/admin")             //Admin product controller
	public String adminHome() 
	{
		return "adminHome";
	}
  @GetMapping("/admin/categories")
  public String getCat(Model model)     //to get category
  {
	  model.addAttribute("categories",categoryServiceImpl.getAllcategory());
	  return "categories";
  }
  
  @GetMapping("/admin/categories/add")
  public String addcategories(Model model)   // category
  {
	  model.addAttribute("category",new Category());
	  return "categoriesAdd";
  }
  @PostMapping("/admin/categories/add") //to post category
  public String postcategories(@ModelAttribute("category") Category category)
  {
	 categoryServiceImpl.addcategory(category);
	  return "redirect:/admin/categories";
  }
  @GetMapping("/admin/categories/delete/{id}") //to delete category by id
  public String deletecategory(@PathVariable int id)
  {
	  categoryServiceImpl.deletecategory(id);
	  return "redirect:/admin/categories";
  }
  @GetMapping("/admin/categories/update/{id}") //to update category by id
  public String updatecategory(@PathVariable int id,Model model)
  {
	  Optional<Category> category=categoryServiceImpl.getCategoryById(id);
	  if(category.isPresent())
	  {
		  model.addAttribute("category",category.get());
		  return "categoriesAdd";
	  }
	  else
		  return "404";
	
  }
  //Product section started
  @GetMapping("/admin/products")
  public String getallProduct(Model model)
  {
	  model.addAttribute("products",productServiceImpl.getAllProducts());
	  return "products";
  }
  @GetMapping("/admin/products/add")
  public String product(Model model)
  {
	  model.addAttribute("productDTO",new ProductDTO());
	  model.addAttribute("categories",categoryServiceImpl.getAllcategory());
	  return "productsAdd";
  }
  @PostMapping("/admin/products/add")
  public String addProduct(@ModelAttribute("productDTO") ProductDTO productDTO,
		                   @RequestParam("productImage")MultipartFile file,
		                   @RequestParam("imgName")String imgName) throws IOException
  {
	  Product product=new Product();
	  product.setId(productDTO.getId());
	  product.setName(productDTO.getName());
	  product.setCategory(categoryServiceImpl.getCategoryById(productDTO.getCategoryId()).get());
	  product.setPrice(productDTO.getPrice());
	  product.setColor(productDTO.getColor());
	  product.setSpecification(productDTO.getSpecification());
	  product.setManufacuturer(productDTO.getManufacuturer());
	  product.setQuantity(productDTO.getQuantity());
	  String imageUUID;
	  if(!file.isEmpty())
	  {
		  imageUUID=file.getOriginalFilename();
		  Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
		  Files.write(fileNameAndPath, file.getBytes());
	  }
	  else
	  {
		  imageUUID=imgName;
	  }
	  product.setImageName(imageUUID);
	  productServiceImpl.addProducts(product);
	return "redirect:/admin/products";
	  
  }
  @GetMapping("/admin/product/delete/{id}") //to delete product by id
  public String deleteproduct(@PathVariable int id)
  {
	  productServiceImpl.removeProduct(id);
     return "redirect:/admin/products";
  }
  @GetMapping("/admin/product/update/{id}") //to update product by id
  public String updateproduct(@PathVariable long id,Model model)
  {
	  Product product=productServiceImpl.getproductById(id).get();
	  ProductDTO productDTO=new ProductDTO();
	  productDTO.setId(product.getId());
	  productDTO.setCategoryId(product.getCategory().getId());
	  productDTO.setColor(product.getColor());
	  productDTO.setPrice(product.getPrice());
	  productDTO.setManufacuturer(product.getManufacuturer());
	  productDTO.setSpecification(product.getSpecification());
	  productDTO.setQuantity(product.getQuantity());
	  productDTO.setImageName(product.getImageName());
	   model.addAttribute("categories",categoryServiceImpl.getAllcategory());
		  model.addAttribute("productDTO",productDTO);
		  return "productsAdd";
	 
	
  }
}









