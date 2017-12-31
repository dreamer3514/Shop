package com.controller;

import com.dao.CartDao;
import com.dao.ProductDao;
import com.model.CartItem;
import com.model.Product;
import com.model.User;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CartController {
    private CartDao cartDao;
    private ProductDao productDao;
    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Autowired
    private HttpServletRequest request;
    @Autowired
    public void setCartDao(CartDao cartDao) {
        this.cartDao = cartDao;
    }
    @RequestMapping(value="/toCart.html")
    public ModelAndView cartPage()
    {

        User user = (User)request.getSession().getAttribute("user");
        List<CartItem> list = cartDao.find(user.getUserId());
//        System.out.println(list.size());
//        for (CartItem cartItem:list)
//        {
//            Product product = productDao.getProductById(cartItem.getProductId());
//            System.out.println(product.getProductName()+":"+cartItem.getCount());
//        }
       // System.out.println(map.values());
        ModelAndView view = new ModelAndView("cart","list",list);
       // view.addObject("map",map);
        return view;
    }

    @RequestMapping(value="/addToCart.html")
    public void add()
    {
        String pid = request.getParameter("pid");
        System.out.println(pid);
        String uid = request.getParameter("uid");
        System.out.println(uid);

        Product product = productDao.getProductById(Integer.valueOf(pid));
        CartItem cartItem = new CartItem(product.getProductId(),1,Integer.valueOf(uid),product);
        cartDao.add(cartItem);
    }
    @RequestMapping(value="/delFromCart.html")
    public void delect()
    {
        String pid = request.getParameter("pid");
        System.out.println("pid"+pid);
        String uid = request.getParameter("uid");
        System.out.println("uid"+uid);
        cartDao.delece(Integer.valueOf(pid),Integer.valueOf(uid));

        List<CartItem> list = cartDao.find(Integer.valueOf(uid));

        System.out.println("size:"+list.size());
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(1,"s");
        jsonArray.add(2,"d");
//        for (CartItem cartItem:list) {
//           // jsonArray.add(cartItem.getProductId());
//            System.out.println(cartItem.getProductId());
//        }
        System.out.println(jsonArray.toString());

    }
}
