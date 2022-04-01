package com.demo.vm;

import com.demo.vm.model.ProductModel;
import com.demo.vm.model.UserModel;
import com.demo.vm.repository.ProductRepo;
import com.demo.vm.repository.UserRepo;
import com.demo.vm.service.ProductService;
import com.demo.vm.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VmApplicationTests {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private UserService userService;

	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private ProductService productService;

	@Test
	@Tag("GET")
	@Order(1)
	@DisplayName("Get All Users")
	void GetAllUsersTest(){
		when(userRepo.findAll()).thenReturn(new LinkedList<>(Arrays.asList(
				new UserModel(),
				new UserModel(),
				new UserModel()
		)));

		List<UserModel> expected = userRepo.findAll();
		List<UserModel> actual = userService.getAll();

		Assertions.assertEquals (expected, actual,
				"User lists should be identical!");
	}

	@Test
	@Tag("POST")
	@Order(2)
	@DisplayName("Add User")
	void addUserTest(){
		when(userRepo.save(any(UserModel.class))).thenReturn(
				new UserModel()
		);

		UserModel expected = userRepo.save(new UserModel());
		UserModel actual = userService.addUser(new UserModel());

		Assertions.assertEquals (expected, actual,
				"Users should be identical!");
	}

	@Test
	@Tag("GET")
	@Order(3)
	@DisplayName("Get All Products")
	void GetAllProductsTest(){
		when(productRepo.findAll()).thenReturn(new LinkedList<>(Arrays.asList(
				new ProductModel(),
				new ProductModel(),
				new ProductModel()
		)));

		List<ProductModel> expected = productRepo.findAll();
		List<ProductModel> actual = productService.getAllProducts();

		Assertions.assertEquals (expected, actual,
				"User lists should be identical!");
	}

	@Test
	@Tag("POST")
	@Order(4)
	@DisplayName("Add Product")
	void addProductTest(){
		when(productRepo.save(any(ProductModel.class))).thenReturn(
				new ProductModel()
		);

		ProductModel expected = productRepo.save(new ProductModel());
		ProductModel actual = productService.addProduct(new ProductModel());

		Assertions.assertEquals (expected, actual,
				"Products should be identical!");
	}



}
