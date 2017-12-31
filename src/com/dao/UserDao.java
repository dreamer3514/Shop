package com.dao;

import com.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

//    private HibernateTemplate hibernateTemplate;
//
//    @Autowired
//    public void setHibernateTemplate(HibernateTemplate hibernateTemplate)
//    {
//        this.hibernateTemplate = hibernateTemplate;
//    }
    //匹配相应的用户
    public int getMatchCount(String userName,String password)
    {
        String MATCH_COUNT_SQL = " SELECT count(*) FROM t_user  " +
                " WHERE user_name =? and password=? ";
        return jdbcTemplate.queryForObject(MATCH_COUNT_SQL,new Object[]{userName,password},Integer.class);
    }


    public User findUserByUserName(String userName)
    {
        String FIND_USER_SQL = " SELECT user_id,user_name,credit ,sex,email_address "+
                " FROM t_user WHERE user_name =? ";

        final User user=new User();
        jdbcTemplate.query(FIND_USER_SQL, new Object[]{userName},
                new RowCallbackHandler() {
                    @Override
                    public void processRow(ResultSet resultSet) throws SQLException {
//                        user = new User();
                        user.setUserId(resultSet.getInt("user_id"));
                        user.setUserName(resultSet.getString("user_name"));
                        user.setSex(resultSet.getInt("sex"));
                        user.setEmailAdress(resultSet.getString("email_address"));
                        user.setCredit(resultSet.getInt("credit"));
                    }
                });
        return user;
//        List<User> users =  (List<User>)hibernateTemplate.find("from com.model.User u where u.userName = ?",userName);
//
//        System.out.println(users.get(0).getUserName());
//        return users.get(0);
    }

    public boolean isExist(String userName)
    {
        String sql = " SELECT count(*) FROM t_user  " +
                " WHERE user_name =? ";
        int result = jdbcTemplate.queryForObject(sql,new Object[]{userName},Integer.class);
        return result!=0;

    }

    //登录成功后更新用户的最后登录ip和时间
    public void updateUser(User user)
    {
        String UPDATE_USER_SQL =" UPDATE t_user SET last_visit=?,last_ip=?" +
                " WHERE user_id=?";
        jdbcTemplate.update(UPDATE_USER_SQL,new Object[]{user.getLastVisit(),user.getLastIp(),user.getUserId()});
    }

    //更改密码

    //注册新用户
    public void createNewUser(User user)
    {
        String CREATE_USER_SQL = " INSERT INTO t_user(user_name,password, " +
                " sex,email_address) VALUES (?,?,?,?)";
        jdbcTemplate.update(CREATE_USER_SQL,new Object[]{user.getUserName(),user.getPassword(),user.getSex(),user.getEmailAdress()});
    }
}
