package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller //annotation đánh dấu đây là 1 lớp Controller
@RequestMapping("/product")
//annotation khai báo URL cho lớp Controller tương ứng
//có thể dùng cho cả lớp và phương thức
public class ProductController {

    private ProductService productService = new ProductService();
    @GetMapping
    //annotation tạo URL riêng cho tương phương thức
    //quy định về kiểu request gọi đến nó
    //chỉ dùng cho phương thức
    //POST: create; PUT: update; DELETE: delete
    public String index(HttpServletRequest request,Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "view/list";
    }

    @GetMapping("/create")
    public String create() {
        return "view/create";
    }

    @GetMapping("/update")
    public String update(HttpServletRequest request,HttpServletResponse response,Model model) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        model.addAttribute("product", productService.findById(id));
        return "view/update";
    }

    @PostMapping("/create")
    public void create(HttpServletRequest request, Model model,HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        productService.createProduct(new Product(name, price, quantity));
        //xử lý lỗi duplicate dữ liệu trong khi tạo hoặc sửa: điều hướng với Servlet tương ứng
        //đối tượng Model: dùng để gắn kèm dữ liệu gửi đi cho view
        //đối tượng Request: dùng để nhận giá trị từ đường dẫn tương ứng của JSP
        response.sendRedirect("/product");
    }

    @GetMapping ("/delete")
    public void delete(HttpServletRequest request, Model model,HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        productService.deleteProduct(id);
        response.sendRedirect("/product");
    }
    @PostMapping("/update")
    public void update(HttpServletRequest request, Model model,HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        productService.updateProduct(new Product(id, name, price, quantity));
        response.sendRedirect("/product");
        //xử lý lỗi duplicate dữ liệu trong khi tạo hoặc sửa: điều hướng với Servlet tương ứng
        //đối tượng Model: dùng để gắn kèm dữ liệu gửi đi cho view
        //đối tượng Request: dùng để nhận giá trị từ đường dẫn tương ứng của JSP

    }
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    //sử dụng RequestMapping ở mức độ method
    //value: quy định đường dẫn cho phương thức
    //method: quy định kiểu request được chấp nhận
    public String home() {
        return "view/list";
    }

//    @GetMapping
//    public ModelAndView m1() {
//        ModelAndView modelAndView = new ModelAndView("view/list");
//        //đối tượng ModelAndView: gắn kèm giá trị dự liệu và view-name
//        return modelAndView;
//    }
}
