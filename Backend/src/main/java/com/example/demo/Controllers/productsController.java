package com.example.demo.Controllers;

import com.example.demo.Entities.Product;
import com.example.demo.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;


//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@CrossOrigin("*")
public class productsController {
    @Autowired
    productRepository productRepository;

    @PostMapping("/add-product")

    public Product addProduct( @RequestParam("pic")  MultipartFile multipartFile, @RequestParam("name")String name, @RequestParam("category")String category, @RequestParam("price")double price)throws Exception {
//        System.out.println(multipartFile.getOriginalFilename()+name+category+price);
        String path="C:\\Users\\Bhatti\\Desktop\\final_projects\\demo\\src\\main\\resources\\static\\images";
        File file=new File(path+File.separator+multipartFile.getOriginalFilename());
        multipartFile.transferTo(file);
        Product product=new Product();
        product.setPrice(price);
        product.setCategory(category);
        product.setName(name);
        product.setPic(multipartFile.getOriginalFilename());
        Product object=this.productRepository.save(product);
        return object ;
    }

    @DeleteMapping("/delete-product/{id}")

    public String delete(@PathVariable int id) {
       String previous_pic=this.productRepository.findById(id).get().getPic();
        String path="C:\\Users\\Bhatti\\Desktop\\final_projects\\demo\\src\\main\\resources\\static\\images";
        this.productRepository.delete(this.productRepository.findById(id).get());
        File file1=new File(path+File.separator+previous_pic);
        file1.delete();
        return "data has been deleted with id " + id;
    }

    @GetMapping("/view-all-product")

    public List<Product> viewAllProduct() {
        return this.productRepository.findAll();
    }


    @GetMapping("/get-product-by-id/{id}")

    public Product viewProductById(@PathVariable int id) {
        return this.productRepository.findById(id).get();
    }
  @GetMapping("/get-product-by-name/{query}")
    public List<Product> viewProductByName(@PathVariable String  query) {
        return this.productRepository.search(query);
    }

    @PutMapping("/update-product/{id}")

    public Product viewProductById(@PathVariable int id,@RequestParam(name="pic", required=false) MultipartFile multipartFile, @RequestParam("name")String name, @RequestParam("category")String category, @RequestParam("price")double price) {
        Product obj = this.productRepository.findById(id).get();
        String previous_pic=obj.getPic();
        if(multipartFile!=null)
        {
            System.out.println(multipartFile.getOriginalFilename());
        }
        else
            System.out.println("file is null"+multipartFile);
//        System.out.println("form post request "+id+multipartFile.getOriginalFilename()+name+category+price);
//        System.out.println("form post request called"+multipartFile.getSize());
        if(multipartFile!=null&&multipartFile.getSize()!=0)
        {
//            System.out.println("in if");
            String path="C:\\Users\\Bhatti\\Desktop\\final_projects\\demo\\src\\main\\resources\\static\\images";
            File file=new File(path+File.separator+multipartFile.getOriginalFilename());
            try
            {

                multipartFile.transferTo(file);
                System.out.println(file.getName()+file.length()+file.getAbsolutePath());
                obj.setPic(multipartFile.getOriginalFilename());
                File file1=new File(path+File.separator+previous_pic);
                file1.delete();
//                        if(file1.delete())
//                        {
////                            System.out.println("file deleted");
//                        }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        else
        {
//            System.out.println("in else");
            obj.setPic(previous_pic);
        }
        obj.setCategory(category);
        obj.setId(id);
        obj.setName(name);
        obj.setPrice(price);
//        System.out.println("form db "+obj);
        this.productRepository.save(obj);
        return obj;
    }

    @RequestMapping(value = "/patchtodo/{id}", method = RequestMethod.PATCH)

    public String patchtodo(@PathVariable("id") int id, @RequestBody Map<Object, Object> field) {
        Optional<Product> product_obj = this.productRepository.findById(id);
        Product product = product_obj.get();
        field.forEach((k, v) -> {
            Field myfield = ReflectionUtils.findField(Product.class, String.valueOf(k));
            myfield.setAccessible(true);
            ReflectionUtils.setField(myfield, product, v);
        });
        this.productRepository.save(product);

        return "patch update work succesfully....";
    }
}