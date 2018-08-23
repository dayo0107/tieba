package com.wong.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Hibernate;
import com.wong.utils.HibernateUtils;
import org.hibernate.Session;


/**
 * @author DayoWong
 */
public class TransactionFilter implements Filter {

    public void destroy() {
        // TODO Auto-generated method stub
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Session session  = HibernateUtils.getCurrentSession();

        session.beginTransaction();//开始事务 扩大事务范围

        try {
            chain.doFilter(request, response);

            if(session!=null && session.isOpen()){
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if(session!=null && session.isOpen()){
                session.getTransaction().rollback();
            }
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

}

