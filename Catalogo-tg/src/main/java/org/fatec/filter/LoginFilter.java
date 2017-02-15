package org.fatec.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fatec.model.Usuario;



public class LoginFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest servletRequest = (HttpServletRequest) request;
		@SuppressWarnings("unused")
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();
		String uri = ((HttpServletRequest) request).getRequestURI();
		Usuario user = (Usuario) session.getAttribute("info_user");
		try {
			if ((user == null)) {
				String url = "/index.xhtml";
				request.getRequestDispatcher(url).forward(request, response);
				System.out.println(user.toString());
				return;
			}else{
				HttpSession sess = ((HttpServletRequest) request).getSession(true);

				String newCurrentPage = ((HttpServletRequest) request).getServletPath();

				if (sess.getAttribute("currentPage") == null) {
					sess.setAttribute("lastPage", newCurrentPage);
					sess.setAttribute("currentPage", newCurrentPage);
				} else {

					String oldCurrentPage = sess.getAttribute("currentPage").toString();
					if (!oldCurrentPage.equals(newCurrentPage)) {
						sess.setAttribute("lastPage", oldCurrentPage);
						sess.setAttribute("currentPage", newCurrentPage);
					}
				}
				System.out.println(sess.getAttribute("lastPage"));
				request.setCharacterEncoding("UTF-8");
				chain.doFilter(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setCharacterEncoding("UTF-8");
			chain.doFilter(request, response);
		}

		

	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}