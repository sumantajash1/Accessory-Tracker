package com.Sumanta.AccessoryTracker.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.Sumanta.AccessoryTracker.DAO.ProductDAO;
import com.Sumanta.AccessoryTracker.Entity.Product;
import com.Sumanta.AccessoryTracker.Service.UserService;

@Controller
public class ProductController {
	
	@Autowired
	private Product product;
	@Autowired
	private UserService service;
	
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
		List<Product> result = service.fetch(product);
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
		List<Product> allProducts = service.FetchAll();
		model.addAttribute("products", allProducts);
		System.out.println("Fetch all entered");
		System.out.println(allProducts);
		return "result";
	}

	@PostMapping("AddProduct")
	public String AddProduct(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("type") String type, @RequestParam("place") String place, @RequestParam("warranty") String warranty, Model model) {
		product.setId(id);
		product.setName(name);
		product.setPlace(place);
		product.setType(type);
		product.setWarranty(warranty);
		service.add(product);
		model.addAttribute("message", "Product Added, Want to add anything else ?");
		return "adder";
	}

	@GetMapping("UpdateProductPage")
	public String UpdateProductPage() {
		return "updateproduct";
	}

	@PostMapping("UpdateProduct")
	public void UpdateProduct(@RequestParam("id") String id ,@RequestParam(value="updatedWarranty", required = false) String updatedWarranty, @RequestParam(value="updatedPlace", required = false) String updatedPlace) {
		if(updatedWarranty != null) {
			service.updateWarranty(id, updatedWarranty);
		}
		System.out.println(updatedWarranty);
		System.out.println(updatedPlace);
		System.out.println(id);

		if(updatedPlace != null) {
			service.updatePlace(id, updatedPlace);
		}
	}

	@GetMapping("DeleteProductPage")
	public String DeleteProductPage() {
		return "deleteproduct";
	}

	@PostMapping("DeleteProduct")
	public void DeleteProduct(@RequestParam("id") String id) {
		service.deleteProduct(id);
	}

}
