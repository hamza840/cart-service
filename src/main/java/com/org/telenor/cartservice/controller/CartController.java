package com.org.telenor.cartservice.controller;


import com.org.telenor.cartservice.mapper.CartMapper;
import com.org.telenor.cartservice.model.Cart;
import com.org.telenor.cartservice.model.Comment;
import com.org.telenor.cartservice.model.Product;
import com.org.telenor.cartservice.model.Ratting;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author hamza.ahmed 26/09/19
 * Rest controller for creating api for products
 */
@RestController
@RequestMapping(value= "/cart")
public class CartController {
    @Resource
    CartMapper cartMapper;


    @GetMapping(value = "/")
    public  String msg(){
        return "Hello from Product Controller";
    }

    @GetMapping("/getAllProducts")
    public ArrayList<Product> getAllProducts(){


        return cartMapper.getAll();
    }

    @GetMapping("/getcartproducts")
    public ArrayList<Product> getCartProducts(@RequestParam("userId") String userId){


        return cartMapper.getCartDetail(userId);
    }

    @GetMapping("/getproductdetail")
    public Product getAllProductDetail(@RequestParam("id") String id){
        return cartMapper.getProductDetail(id);
    }

    /**
     *
     * @param cart will take the values from the request body
     * @return will return the object to the mapper for inserting cart in database
     */
    @RequestMapping(value = "/insertproduct",method = RequestMethod.POST)
        public int insertProduct(@RequestBody Cart cart){
        return cartMapper.insert(cart);
    }

    /**
     *
     * @param comment will take the values from the request body
     * @return will return the object to the mapper for inserting comment in database
     */
    @RequestMapping(value = "/insertcomment",method = RequestMethod.POST)
    public int insertComment(@RequestBody Comment comment){
        return cartMapper.insertComment(comment);
    }

    /**
     *
     * @param ratting will take the values from the request body
     * @return will return the object to the mapper for inserting rating of product in database
     */
    @RequestMapping(value = "/insertratting",method = RequestMethod.POST)
    public int insertComment(@RequestBody Ratting ratting){
        return cartMapper.insertRatting(ratting);
    }

    /**
     *
     * @param product will take the values from the request body
     * @return will return the object to the mapper for updating product in database
     */
    @RequestMapping(value = "/updateProduct",method = RequestMethod.PUT)
    public int update(@RequestBody Product product){
        return cartMapper.update(product);
    }

    /**
     *
     * @param product will take the product id from the request body
     * @return will return the object to the mapper for deleting product in database
     */
    @RequestMapping(value = "/deleteProduct",method = RequestMethod.DELETE)
    public int delete(@RequestBody Product product){
        return cartMapper.delete(product);
    }

    /**
     *
     * @param id will be used to find the product with particular id
     * @return
     */
    @RequestMapping(value = "/getProductWithId",method = RequestMethod.GET)
    public Product getWithId(@RequestParam("id") String id){
        return cartMapper.getProductWithId(id);
    }

    /**
     *
     * @param p_id will be used to find the product comment with particular product id
     * @return
     */
    @RequestMapping(value = "/getproductcomment",method = RequestMethod.GET)
    public ArrayList<Comment> getComments(@RequestParam("p_id") String p_id){
        return cartMapper.getComments(p_id);
    }

    /**
     *
     * @param p_id will be used to find the product rattings with particular product id
     * @return
     */
    @RequestMapping(value = "/getproductratting",method = RequestMethod.GET)
    public ArrayList<Ratting> getRattings(@RequestParam("p_id") String p_id){
        return cartMapper.getRatting(p_id);
    }

    /**
     *
     * @param id will be used to find products with particular category id
     * @return
     */
    @RequestMapping(value = "/getproductwithcatid",method = RequestMethod.GET)
    public ArrayList<Product> getWithCatId(@RequestParam("id") String id){
        return cartMapper.getProductWithCatId(id);
    }

    /**
     *
     * @param query will be used to search product matching with their name
     * @return
     */
    @RequestMapping(value = "/searchProduct",method = RequestMethod.GET)
    public ArrayList<Product> searchProduct(@RequestParam("query") String query){
        return cartMapper.searchProduct(query);
    }

    /**
     *
     * @return will return list of main categories
     */
    @RequestMapping(value = "/getcategories",method = RequestMethod.GET)
    public ArrayList<Product> getCategories(){
        return cartMapper.getCategories();
    }

    /**
     * will return list of child categories
     * @return
     */
    @RequestMapping(value = "/getsubcategories",method = RequestMethod.GET)
    public ArrayList<Product> getSubCategories(@RequestParam("parent_id") String parent_id){
        return cartMapper.getSubCategories(parent_id);
    }


}
