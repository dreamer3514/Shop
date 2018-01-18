package com.controller;

import com.model.Product;
import com.service.ProductService;
import com.utils.Page;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    private HttpServletRequest request;
    @Autowired
    public void setProductService(ProductService productService)
    {
        this.productService=productService;
    }

    @RequestMapping(value="/toProductList.html")
    public  ModelAndView ProductsPage()
    {
        String p = request.getParameter("page");
        int pageNum=1;
        if(p!=null)
        {
            pageNum = Integer.valueOf(p);
        }else {
            pageNum = 1;
        }
        Page<Product> page = productService.getAll(pageNum);

//        List<Product> pList = productService.getAll();
//        System.out.println(pList);
//        for(Product product:pList)
//            System.out.println(product.getProductName());
//        for(Product product:page.getList())
//            System.out.println(product.getProductName());
        return new ModelAndView("productList","page",page);
    }

    @RequestMapping(value="/productType.html")
    public  ModelAndView ProductType()
    {

        System.out.println("进入方法");
        int typeId = Integer.valueOf(request.getParameter("typeId"));
        int p = Integer.valueOf(request.getParameter("page"));

        System.out.println("typeId: "+typeId);
        System.out.println("p: "+p);

        Page<Product> page= productService.getProductsByTypeId(typeId,p);

        ModelAndView modelAndView = new ModelAndView("productList");
        modelAndView.addObject("page",page);
        modelAndView.addObject("typeId",typeId);


        return modelAndView;
    }

    @RequestMapping(value="/findByKeyword.html")
    public  ModelAndView findByKeyword()
    {

        System.out.println("进入find方法");

        String key = request.getParameter("key");
//        int p = Integer.valueOf(request.getParameter("page"));
        int p=1;
        Page<Product> page= productService.getProductsByKeyWord(key,p);

        ModelAndView modelAndView = new ModelAndView("productList");
        modelAndView.addObject("page",page);
        modelAndView.addObject("key",key);
        return modelAndView;
    }

    @RequestMapping(value = "/addNewProduct")
    public void addNewProduct(Product product)
    {
        productService.addNewProduct(product);
    }

    @RequestMapping(value = "/delete.html")
    public void  delete(int productId)
    {
        productService.delete(productId);
    }

    @RequestMapping(value = "/update.html")
    public void update(Product product)
    {
        productService.update(product);
    }

}
