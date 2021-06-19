package com.example.listener;

import java.sql.Connection;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

/**
 * @author Liutianyou
 * @date 2021/6/19 6:52 下午
 */
public class ApplicationListener implements ServletContextListener {


  @Override
  public void contextInitialized(ServletContextEvent sce) {
    Context initContext;
    try{
      initContext = new InitialContext();
      Context envContext = (Context) initContext.lookup("java:/comp/env");
      DataSource dataSource = (DataSource) envContext.lookup("jdbc/datasource");
      Connection connection = dataSource.getConnection();
      if(connection!=null)
      {
        System.out.println("JNDI获取数据库连接!");
      }
    }catch (Exception e){
      e.printStackTrace();
    }

  }


}
