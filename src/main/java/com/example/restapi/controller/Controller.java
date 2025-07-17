package com.example.restapi.controller;

import com.example.restapi.entity.Product;
import com.example.restapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class Controller {

    @Autowired
    private ProductService productService;

   @GetMapping(value = "/oauth-error", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
//    @RequestMapping(value = "/oauth-error",method = RequestMethod.GET)
    public String getXMLres(){
        return "<oauth>\n" +
                "<error_description>Access token expired: </error_description>\n" +
                "<error>invalid_token</error>\n" +
                "</oauth>";

    }

    @GetMapping("/message")
    public String displayMsg(){
       return "Congrats! Your app deployed successfully in Azure!";
    }
    @GetMapping()
    public List<Product> getallProduct(){
        return productService.getallProduct();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping()
    public Product CreateProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,@RequestBody Product productDetails){
        return productService.updateProduct(id,productDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id){
        productService.deleteProduct(id);
    }

    @GetMapping("/search")
    public List<Product> searchProdeuct(@RequestParam String name){
       return productService.getProductByName(name);
    }


}
