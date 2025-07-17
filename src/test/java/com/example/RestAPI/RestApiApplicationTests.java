package com.example.RestAPI;



import com.example.restapi.controller.Controller;
import com.example.restapi.entity.Product;
import com.example.restapi.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.boot.autoconfigure.AutoConfigurationPackages.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WebMvcTest(Controller.class)
class RestApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;

//	@Test
	void testGetProductById() throws Exception {
		Product p = new Product(1L,"Fan",40000);
		when(productService.getProductById(1L)).thenReturn(p);

//		mockMvc.perform(get("/api/products/1")).andExpect(status().isOk()).andExpect(jsonPath("$.name").value("Fan")).andExpect(jsonPath("$.price").value(40000));

	}

}
