package test.daoTest;

import com.dao.CartDao;
import com.dao.UserDao;
import com.model.CartItem;

import com.model.CartItem;
import com.service.ProductService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/test/config/applicationContext.xml")
public class CartDaoTeat extends AbstractJUnit4SpringContextTests{

    @Autowired
    private CartDao cartDao;


    @Test
    public void find()
    {
        System.out.println(cartDao);
        List<CartItem> list ;
        list = cartDao.find(1);
//        String sql = "SELECT * FROM t_cartitems WHERE user_id=? ";
//        List<CartItem> list = new LinkedList<>();
//        jdbcTemplate.query(sql, new Object[]{1}, new RowCallbackHandler() {
//            @Override
//            public void processRow(ResultSet resultSet) throws SQLException
//            {
//                CartItem cartItem = new CartItem();
//                cartItem.setProductId(resultSet.getInt("product_id"));
////                cartItem.setProduct(productService.getProductById(resultSet.getInt("product_id")));
//                cartItem.setCount(resultSet.getInt("count"));
//                list.add(cartItem);
//            }
//        });
        for (CartItem c:list)
        {
            System.out.println(c.getProductId());
        }
        System.out.println("dddd");
    }
}
