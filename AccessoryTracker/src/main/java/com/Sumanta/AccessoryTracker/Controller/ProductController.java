package com.Sumanta.AccessoryTracker.Controller;

import java.util.List;

import com.Sumanta.AccessoryTracker.Service.ReqLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.Sumanta.AccessoryTracker.Entity.Product;
import com.Sumanta.AccessoryTracker.Service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private Product product;
	@Autowired
	private ProductService productService;
	@Autowired
	private ReqLogService reqLogService;

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("TrackPage")
	public String TrackPage() {
		return "tracker";
	}
	
	@RequestMapping("AddPage")
	public String AddPage() {
		return "adder";
	}
	
	@RequestMapping("TrackProduct")
	public String TrackProduct(@RequestParam(value = "id", required = false) String id, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "type", required = false) String type, @RequestParam(value = "place", required = false) String place, @RequestParam(value = "warranty", required = false) String warranty, Model model) {
		product.setId(id);
		product.setName(name);
		product.setPlace(place);
		product.setType(type);
		product.setWarranty(warranty);
		List<Product> result = productService.fetch(product);
		if(result.isEmpty()) {
			model.addAttribute("message", "No Accessory found");
			return "Result";
		}
		model.addAttribute("products",result);
		System.out.println(result);
		return "result";
	}

	@GetMapping("FetchAll")
	public String FetchAll(Model model) {
		List<Product> allProducts = productService.FetchAll();
		model.addAttribute("products", allProducts);
		System.out.println("Fetch all entered");
		System.out.println(allProducts);
		return "result";
	}

	@PostMapping("AddProduct")
	public String AddProduct(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("type") String type, @RequestParam("place") String place, @RequestParam("warranty") String warranty, Model model) {
		if(productService.isIdExists(id)) {
			model.addAttribute("message", "Id already in use, use different id");
			System.out.println("already exists");
			return "adder";
		}
		product.setId(id);
		product.setName(name);
		product.setPlace(place);
		product.setType(type);
		product.setWarranty(warranty);
		productService.add(product);
		model.addAttribute("message", "Product Added, Want to add anything else ?");
		return "adder";
	}

	@GetMapping("UpdateProductPage")
	public String UpdateProductPage() {
		return "updateproduct";
	}

	@PostMapping("UpdateProduct")
	public String UpdateProduct(@RequestParam("productId") String productId ,@RequestParam("employeeId") String employeeId ,@RequestParam(value="updatedWarranty", required = false) String updatedWarranty, @RequestParam(value="updatedPlace", required = false) String updatedPlace, Model model
	) {
		if(!productService.isIdExists(productId)) {
			model.addAttribute("message", "Invalid Product Id");
			return "UpdateProductPage";
		}
		if(updatedWarranty != null) {
			productService.updateWarranty(productId, updatedWarranty);
			reqLogService.logUpdate(productId, employeeId, updatedPlace);
		}
		if(updatedPlace != null) {
			productService.updatePlace(productId, updatedPlace);
			reqLogService.logUpdate(productId, employeeId, updatedPlace);
		}
		model.addAttribute("message", "Want to update anything else ?");
		return "updateproduct";
	}

	@GetMapping("DeleteProductPage")
	public String DeleteProductPage() {
		return "deleteproduct";
	}

	@PostMapping("DeleteProduct")
	public void DeleteProduct(@RequestParam("id") String id) {
		productService.deleteProduct(id);
	}


}
