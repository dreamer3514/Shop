package com.dao;

import com.model.CartItem;
import com.model.Product;
import com.service.ProductService;
import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Repository
public class CartDao {

    private JdbcTemplate jdbcTemplate;
    private ProductService productService;
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CartItem> find(int userId)
    {
        String sql = "SELECT * FROM t_cartitems WHERE user_id=? ";
       // Cart cart = new Cart();
       List<CartItem> list = new LinkedList<>();
        jdbcTemplate.query(sql, new Object[]{userId}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException
            {
                CartItem cartItem = new CartItem();
                cartItem.setProductId(resultSet.getInt("product_id"));
                cartItem.setProduct(productService.getProductById(resultSet.getInt("product_id")));
                cartItem.setCount(resultSet.getInt("count"));
                list.add(cartItem);
            }
        });
        return list;
    }
    public int findCount(int userId,int productId)
    {
        String sql = "SELECT count FROM t_cartitems WHERE user_id=? and product_id=?";
        return jdbcTemplate.queryForObject(sql,new Object[]{userId,productId},Integer.class);
    }
    public void add(CartItem cartItem)
    {
        System.out.println("进入add方法"+cartItem.getProductId());
        String find = "SELECT count(*) FROM t_cartitems WHERE user_id=? and product_id=?";
        String insert ="INSERT INTO t_cartitems (user_id,product_id,count) VALUES(?,?,?) ";
        CartItem item ;
        int old = jdbcTemplate.queryForObject(find,new Object[]{cartItem.getUserId(),cartItem.getProductId()},Integer.class);
        System.out.println("old:"+old);
        if(old==0)
        {
            System.out.println("插入新商品");
            System.out.println("user_id:"+cartItem.getUserId());
            System.out.println("product_id:"+cartItem.getProductId());
            System.out.println("count:"+cartItem.getCount());
            jdbcTemplate.update(insert,new Object[]{cartItem.getUserId(),cartItem.getProductId(),cartItem.getCount()});

        }else {
            int temp = findCount(cartItem.getUserId(),cartItem.getProductId());
            String update = "UPDATE t_cartitems SET count=? WHERE user_id=? and product_id=?";
            jdbcTemplate.update(update,new Object[]{temp+cartItem.getCount(),cartItem.getUserId(),cartItem.getProductId()});
            System.out.println("旧商品");

        }
    }
    public void delece(int pid,int uid)
    {
        System.out.println("删除");
        System.out.println("uid"+uid);
        System.out.println("pid"+pid);
        String sql = "DELETE FROM t_cartitems WHERE product_id=? and user_id=?";
        jdbcTemplate.update(sql,new Object[]{pid,uid});
        System.out.println("离开cartDao");
    }
}
