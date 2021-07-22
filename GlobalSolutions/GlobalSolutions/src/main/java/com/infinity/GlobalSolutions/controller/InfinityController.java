package com.infinity.GlobalSolutions.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.infinity.GlobalSolutions.model.InfinityCustomer;
import com.infinity.GlobalSolutions.model.InfinityOrder;
import com.infinity.GlobalSolutions.model.InfinityProduct;
import com.infinity.GlobalSolutions.model.InfinityPurchasedProduct;
import com.infinity.GlobalSolutions.service.InfinityCustomerService;
import com.infinity.GlobalSolutions.service.InfinityOrderService;
import com.infinity.GlobalSolutions.service.InfinityProductService;
import com.infinity.GlobalSolutions.service.InfinityPurchasedProductService;

@RestController
public class InfinityController {

	@Autowired
	private InfinityCustomerService custService;

	@Autowired
	private InfinityOrderService orderService;

	@Autowired
	private InfinityProductService productService;
	
	@Autowired
	private InfinityPurchasedProductService purchasedProductService;
	
	@GetMapping("/getAllProducts")
	public List<InfinityProduct> getAllProduct() {

		List<InfinityProduct> li = productService.getAllProduct();
		return li;
	}

	@GetMapping("/getProductById/{id}")
	public Optional<InfinityProduct> getProductById(@PathVariable int id) {

		return productService.getProductByID(id);
	}

	@PostMapping("/addProduct")
	public String addProduct(@RequestBody InfinityProduct newProduct) {

		productService.addProduct(newProduct);
		return "Product added successfully";
	}
	
	@PutMapping("/replaceProduct/{id}")
	public Optional<InfinityProduct> replaceProduct(@RequestBody InfinityProduct newProduct, @PathVariable int id) {	
		
		return productService.replaceProduct( id , newProduct);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id){
		
		productService.deleteProduct(id);
		return "Product with prdouctId: " + id + " deleted successfully";
		
	}

	@GetMapping("/getAllOrders")
	public List<InfinityOrder> getAllOrder() {

		List<InfinityOrder> li = orderService.getAllOrder();
		return li;
	}
	
	@GetMapping("/getOrderByID/{id}")
	public Optional<InfinityOrder> getOrderByID(@PathVariable int id ) {
		return orderService.getOrderByID(id);
	}

	//@PostMapping("/addOrder")
	@RequestMapping(
			  value = "/addOrder", 
			  method = RequestMethod.POST, 
			  headers = "Accept=application/json")
	@ResponseBody
	public String addOrder(@RequestBody InfinityOrder newOrder) {
		System.out.print("NewOrder values controller:------>"+ newOrder.getCustomerId() + " " + newOrder.getOrderType() + " " + newOrder.getProductId() + "\n");
		orderService.addOrder(newOrder);
		return "Order placed successfully" + newOrder.getOrderId();
	}
	
	@PutMapping("/replaceOrder/{id}")
	public Optional<InfinityOrder> replaceOrder(@RequestBody InfinityOrder newOrder, @PathVariable int id) {	
		
		return orderService.replaceOrder( id , newOrder);
	}
	
	@DeleteMapping("/deleteOrder/{id}")
	public String deleteOrder(@PathVariable int id){
		
		orderService.deleteOrder(id);
		return "Order with OrderId: " + id + " deleted successfully";
		
	}
	
	@GetMapping("/getOrderByCustomerId/{id}")
	public List<InfinityOrder> findOrderByCustomerId(@PathVariable int id ) {
		List<InfinityOrder> li = orderService.findOrdersByCustomerId(id);
		return li;
	}
	

	@GetMapping("/getOrderByOrderType/{orderType}")
	public List<InfinityOrder> findOrderByOrderType(@PathVariable String orderType ) {
		List<InfinityOrder> li = orderService.findOrdersByOrderType(orderType);
		return li;
	}

	@GetMapping("/getAllCustomers")
	public List<InfinityCustomer> getAllCustomer() {

		List<InfinityCustomer> li = custService.getAllCustomer();
		// System.out.println( " List of all customers: " + li );
		return li;
	}
	
	@GetMapping("/getCustomerByID/{id}")
	public Optional<InfinityCustomer> getCustomerByID(@PathVariable int id ) {

		return custService.getCustomerByID(id);
	}

	@PostMapping("/addCustomer")
	public String addCustomer(@RequestBody InfinityCustomer newCustomer) {

		custService.addCustomer(newCustomer);
		return "Customer added successfully";
	}
	
	@PutMapping("/replaceCustomer/{id}")
	public Optional<InfinityCustomer> replaceCustomer(@RequestBody InfinityCustomer newCustomer, @PathVariable int id) {	
		
		return custService.replaceCustomer( id , newCustomer);
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable int id){
		
		custService.deleteCustomer(id);
		return "Customer with customerId: " + id + " deleted successfully";
		
	}
	
	@GetMapping("/getPurchasedProductByOrderId/{id}")
	public List<InfinityPurchasedProduct> getPurchasedProductByOrderId(@PathVariable int id ) {

		return purchasedProductService.findPurchasedProductsByOrderId(id);
	}
	

}
