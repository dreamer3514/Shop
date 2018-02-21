package com.controller;

import com.model.Product;
import com.service.ProductService;
import com.utils.Page;
import net.sf.json.JSONObject;
import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import net.sf.json.JSONArray;

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
//        JSONArray jsonArray = JSONArray.fromObject(page.getList());
//
//        System.out.println(jsonArray.toString());
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

    @RequestMapping(value = "/addNewProduct.html")
    public ModelAndView addNewProduct(Product product,HttpServletRequest request)
    {
        System.out.println(product.getProductName());
        System.out.println(product.getPrice());
        product.setDate(new Date());
        productService.addNewProduct(product);
        return new ModelAndView("manage");
    }

    @RequestMapping(value = "/deleteProduct.html")
    public ModelAndView deleteProduct()
    {
        String pid = request.getParameter("pid");
        System.out.println(pid);
        productService.delete(Integer.valueOf(pid));
        return new ModelAndView("deleteProduct");
    }

    @RequestMapping(value = "/updateProduct.html")
    public ModelAndView updateProduct(Product product,HttpServletRequest request)
    {
        product.setDate(new Date());
        productService.update(product);
        return new ModelAndView("updateProduct");
    }



    @RequestMapping(value="/toPublishProduct.html")
    public ModelAndView toPublishProduct()
    {
        return new ModelAndView("publishProduct");
    }

    @RequestMapping(value = "/toDeleteProduct.html")
    public ModelAndView toDeleteProduct()
    {
        int p = Integer.valueOf(request.getParameter("page"));
        Page<Product> page = productService.getAll(p);
        ModelAndView modelAndView = new ModelAndView("deleteProduct");
        modelAndView.addObject("page",page);
        return  modelAndView;
    }

    @RequestMapping(value = "/toUpdateProduct.html")
    public ModelAndView toUpdateProduct()
    {
        int p = Integer.valueOf(request.getParameter("page"));
        Page<Product> page = productService.getAll(p);
        ModelAndView modelAndView = new ModelAndView("updateProduct");
        modelAndView.addObject("page",page);
        return  modelAndView;
    }

}
