package com.analemma.vaadin_seo;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * @author Ondrej Kvasnovsky
 */
@WebFilter(urlPatterns = "/*")
public class SeoFilter implements Filter {

  @Override
  public void init(final FilterConfig filterConfig) throws ServletException {}

  @Override
  public void doFilter(final ServletRequest request, final ServletResponse response,
      final FilterChain chain) throws IOException, ServletException {
    final Object searchEngineFlag = request.getParameter("_escaped_fragment_");
    if (searchEngineFlag != null) {
      final InputStream in = getClass().getResourceAsStream("index_for_seo.html");
      final ServletOutputStream out = response.getOutputStream();
      final byte[] buffer = new byte[1024];
      int len;
      while ((len = in.read(buffer)) != -1) {
        out.write(buffer, 0, len);
      }
      in.close();
    } else {
      chain.doFilter(request, response);
    }
  }

  @Override
  public void destroy() {}
}
