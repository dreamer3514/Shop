package test.daoTest;

import com.model.CartItem;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@ContextConfiguration("classpath:com/config/applicationContext.xml")
public class CartDaoTeat extends AbstractTransactionalTestNGSpringContextTests{

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

    @Test
    public void find()
    {
        String sql = "SELECT * FROM t_cartitems WHERE user_id=? ";
        // Cart cart = new Cart();
        List<CartItem> list = new LinkedList<>();
        jdbcTemplate.query(sql, new Object[]{1}, new RowCallbackHandler() {
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
        for (CartItem c:list)
        {
            System.out.println(c.getProductId());
        }
    }
}
