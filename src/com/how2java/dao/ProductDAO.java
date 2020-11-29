/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ProductDAO
 * Author:   苏晨宇
 * Date:     2020/11/10 21:08
 * Description: 为ProductDAO准备增，删，修改，查询，获取方法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java.dao;

import com.how2java.pojo.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈为ProductDAO准备增，删，修改，查询，获取方法〉
 *
 * @author 苏晨宇
 * @create 2020/11/10
 * @since 1.0.0
 */
public class ProductDAO {
    public void add(Product p) {
        List<Product> result = new ArrayList();

        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();

        s.save(p);

        s.getTransaction().commit();
        s.close();
        sf.close();
    }

    public Product get(int id) {
        Product result = null;

        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();

        result = (Product) s.get(Product.class, id);

        s.close();
        sf.close();
        return result;
    }

    public void delete(int id) {
        List<Product> result = new ArrayList();

        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();

        Product p = (Product) s.get(Product.class, id);

        s.delete(p);

        s.getTransaction().commit();
        s.close();
        sf.close();
    }

    public void update(Product p) {
        List<Product> result = new ArrayList();

        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();

        s.update(p);

        s.getTransaction().commit();
        s.close();
        sf.close();
    }

    public List<Product> listProduct() {
        List<Product> result = new ArrayList();

        SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();

        Query q = s.createQuery("from Product p");

        result = q.list();

        s.close();
        sf.close();
        return result;
    }
}
 
