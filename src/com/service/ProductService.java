package com.service;

import com.dao.ProductDao;
import com.model.Product;
import com.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductDao productDao;
    private final String defaultOrder="date";
    private final int limit=5;

    @Autowired
    public void setProductDao(ProductDao productDao)
    {
        this.productDao=productDao;
    }



    public Product getProductById(int id){return productDao.getProductById(id);}

    public Product getProductByName(String name){return productDao.getProductByName(name);}

    private Page<Product> setPage(List<Product> list,int page)
    {
        Page<Product> productPage = new Page<>();
        productPage.setLimit(limit);
        productPage.setCurrentPage(page);
        int totalCount = list.size();
        productPage.setTotalCount(totalCount);
        int totalPage=0;
        if(totalCount % limit==0){
            totalPage=totalCount/limit;
        }else{
            totalPage=totalCount/limit + 1;
        }
        productPage.setTotalPage(totalPage);
        if(page>totalPage)
        {
            page=1;
        }
        int start = (page-1)*limit;
        int end = start+limit;;
        if(end>list.size())
        {
            end=list.size();
        }

        productPage.setList(list.subList(start,end));
        return productPage;
    }
    public Page<Product> getAll(int page)
    {
        List<Product> list = productDao.getAll(defaultOrder);
        return setPage(list,page);
    }
    //默认按时间排序
    public Page<Product> getProductsByKeyWord(String keyWord,int page)
    {
        List<Product> list = productDao.getProductsByKeyWord(keyWord);
        return setPage(list,page);
    }
    public Page<Product> getProductsByTypeId(int typeId,int page)
    {
        List<Product> list= productDao.getProductsByTypeId(typeId);
        for (Product p:list
             ) {
            System.out.println(p.getProductName());
        }
        return setPage(list,page);
    }
    public Page<Product> getProductsBySuperTypeId(int superTypeId,int page)
    {
        List<Product> list= productDao.getProductsBySuperTypeId(superTypeId);
        return setPage(list,page);
    }

    //按名称排序
    public Page<Product> getProductsByKeyWordOrderByName(String keyWord,int page)
    {
        List<Product> list= productDao.getProductsByKeyWord(keyWord);
        return setPage(list,page);
    }
    public Page<Product> getProductsByTypeIdOrderByName(int typeId,int page)
    {
        List<Product> list= productDao.getProductsByTypeId(typeId);
        return setPage(list,page);
    }
    public Page<Product> getProductsBySuperTypeIdOrderByName(int superTypeId,int page)
    {
        List<Product> list= productDao.getProductsBySuperTypeId(superTypeId);
        return setPage(list,page);
    }

    //按价格排序
    public Page<Product> getProductsByKeyWordOrderByPrice(String keyWord,int page)
    {
        List<Product> list= productDao.getProductsByKeyWord(keyWord);
        return setPage(list,page);
    }
    public Page<Product> getProductsByTypeIdOrderByPrice(int typeId,int page)
    {
        List<Product> list= productDao.getProductsByTypeId(typeId);
        return setPage(list,page);
    }
    public Page<Product> getProductsBySuperTypeIdOrderByPrice(int superTypeId,int page)
    {
        List<Product> list= productDao.getProductsBySuperTypeId(superTypeId);
        return setPage(list,page);
    }
}
