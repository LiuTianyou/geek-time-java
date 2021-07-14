package com.example.config;

import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletRequest;
import org.eclipse.microprofile.config.spi.ConfigSource;

/**
 * @author Liutianyou
 * @date 2021/7/14 10:53 下午
 */
public class ServletRequestConfig extends MapBasedConfigSource {
  private final ServletRequest request;

  protected ServletRequestConfig(ServletRequest request) {
    super("servletRequestConfig",100);
    this.request = request;
  }


  @Override
  protected Map<String, String> getConfigData() {
    return super.getConfigData();
  }

  @Override
  protected void prepareConfigData(Map configData) throws Throwable {
    Enumeration<String> parameterNames = request.getParameterNames();
    while(parameterNames.hasMoreElements()){
      String name = parameterNames.nextElement();
      configData.put(name,request.getParameter(name));
    }
  }

  @Override
  public Set<String> getPropertyNames() {
    return super.getPropertyNames();
  }

  @Override
  public String getValue(String propertyName) {
    return super.getValue(propertyName);
  }
}
