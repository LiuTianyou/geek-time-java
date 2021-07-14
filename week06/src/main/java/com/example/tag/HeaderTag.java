package com.example.tag;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class HeaderTag extends SimpleTagSupport {
  private String cacheControl;
  private String pragma;
  private Integer expires;

  @Override
  public void doTag() throws JspException, IOException {
    ServletRequestAttributes attributes = (ServletRequestAttributes) (RequestContextHolder
        .getRequestAttributes());
    HttpServletResponse response = attributes.getResponse();
    response.setHeader("Cache-Control", cacheControl);
    response.setHeader("Pragma", pragma);
    response.setDateHeader("Expires", expires);
  }

  public String getCacheControl() {
    return cacheControl;
  }

  public void setCacheControl(String cacheControl) {
    this.cacheControl = cacheControl;
  }

  public String getPragma() {
    return pragma;
  }

  public void setPragma(String pragma) {
    this.pragma = pragma;
  }

  public Integer getExpires() {
    return expires;
  }

  public void setExpires(Integer expires) {
    this.expires = expires;
  }
}
