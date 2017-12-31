package com.dao;

import com.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Repository
public class ProductDao {

    private JdbcTemplate jdbcTemplate;
//    private HibernateTemplate hibernateTemplate;

//    public List<Product> get(String name)
//    {
//        return (List<Product>)hibernateTemplate.find("FROM  p where p.name like ?","%"+name+"%");
//    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate=jdbcTemplate;
    }

    public void intset(Product product)
    {
        String sql = "INSERT INTO t_products(product_name,price,description,img_url,type_id,superType_id,date) " +
                " VALUES (?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{product.getProductName(),product.getPrice(),
                product.getDescription(),product.getImageUrl(),product.getTypeId(),product.getSuperTypeId(),new Date()});
    }

    public void upDate(Product product)
    {
        String sql = "UPDATE t_products SET product_name=?,price=?,description=?,img_url=?,type_id=?,superType_id=?,date=? " +
                "WHERE product_id=?";
        jdbcTemplate.update(sql,new Object[]{product.getProductName(),product.getPrice(),
                product.getDescription(),product.getImageUrl(),product.getTypeId(),product.getSuperTypeId(),new Date(),product.getProductId()});
    }

    public Product getProductById(int id)
    {
        String sql="SELECT * FROM t_products WHERE product_id=?";
        final Product product = new Product();
        jdbcTemplate.query(sql, new Object[]{id},
                new RowCallbackHandler() {
                    @Override
                    public void processRow(ResultSet resultSet) throws SQLException {
                        product.setProductId(id);
                        product.setProductName(resultSet.getString("product_name"));
                        product.setPrice(resultSet.getDouble("price"));
                        product.setDescription(resultSet.getString("description"));
                        product.setImageUrl(resultSet.getString("image_url"));
                        product.setTypeId(resultSet.getInt("type_id"));
                        product.setSuperTypeId(resultSet.getInt("superType_id"));
                        product.setDate(resultSet.getDate("date"));
                    }
                });
        return product;
    }

    public Product getProductByName(String name)
    {

        String sql="SELECT * FROM t_products WHERE product_name=?";
        Product product = new Product();
        jdbcTemplate.query(sql, new Object[]{name},
                new RowCallbackHandler() {
                    @Override
                    public void processRow(ResultSet resultSet) throws SQLException {
                        product.setProductId(resultSet.getInt("product_id"));
                        product.setProductName(resultSet.getString("product_name"));
                        product.setPrice(resultSet.getDouble("price"));
                        product.setDescription(resultSet.getString("description"));
                        product.setImageUrl(resultSet.getString("image_url"));
                        product.setTypeId(resultSet.getInt("type_id"));
                        product.setSuperTypeId(resultSet.getInt("superType_id"));
                        product.setDate(resultSet.getDate("date"));
                    }
                });
        return product;
    }
    public List<Product> getAll(String orderItem)
    {
        String sql;

        if(orderItem==null)
        {
            sql = "SELECT * FROM t_products";
        }else {
            sql = "SELECT * FROM t_products ORDER BY "+orderItem;
        }

        List<Product> list=new LinkedList<>();

       list = jdbcTemplate.query(sql,new ProductMapper());
        return list;

    }
    public List<Product> getProductsByKeyWord(String keyWord)
    {
//        String sql;
//        if(orderItem==null)
//        {
//            sql = "SELECT * FROM t_products WHERE product_name LIKE '%?%' ";
//        }
//        else {
//            sql= "SELECT * FROM t_products WHERE product_name LIKE '%?%' ORDER BY "+orderItem;
//        }
        System.out.println("%"+keyWord+"%");
        String sql = "SELECT * FROM t_products WHERE product_name LIKE ? ";
        List<Product> list=new LinkedList<>();
        System.out.println(keyWord);
        String key = "%"+keyWord+"%";
        list=jdbcTemplate.query(sql, new Object[]{key}, new ProductMapper());

        return list;

    }

    public List<Product> getProductsByTypeId(int typeId)
    {
//        String sql;
//        if (orderItem==null) {
//            sql = "SELECT * FROM t_products WHERE type_id=?";
//        }else {
//            sql = "SELECT * FROM t_products WHERE type_id=? ORDER BY "+orderItem;
//        }
        String sql = "SELECT * FROM t_products WHERE type_id=?";
        List<Product> list=new LinkedList<>();

        list=jdbcTemplate.query(sql, new Object[]{typeId},new ProductMapper());
        return list;
    }

    public List<Product> getProductsBySuperTypeId(int superTypeId)
    {
//        String sql;
//        if (orderitem==null) {
//            sql = "SELECT * FROM t_products WHERE superType_id=?";
//        }else {
//            sql = "SELECT * FROM t_products WHERE superType_id=? ORDER BY "+orderitem;
//        }

        String sql = "SELECT * FROM t_products WHERE superType_id=?";
        List<Product> list=new LinkedList<>();

        list=jdbcTemplate.query(sql, new Object[]{superTypeId}, new ProductMapper());
        return list;
    }

    public void delect(int productId)
    {
       String sql = "DELETE FROM t_products where product_id=?";
       jdbcTemplate.update(sql,new Object[]{productId});
    }
    private final class ProductMapper implements RowMapper<Product>
    {
        @Override
        public Product mapRow(ResultSet resultSet, int i) throws SQLException {
            Product product =new Product();
            product.setProductName(resultSet.getString("product_name"));
            product.setProductId(resultSet.getInt("product_id"));
            product.setProductName(resultSet.getString("product_name"));
            product.setPrice(resultSet.getDouble("price"));
            product.setDescription(resultSet.getString("description"));
            product.setImageUrl(resultSet.getString("image_url"));
            product.setTypeId(resultSet.getInt("type_id"));
            product.setSuperTypeId(resultSet.getInt("superType_id"));
            product.setDate(resultSet.getDate("date"));
            return product;
        }
    }
}
