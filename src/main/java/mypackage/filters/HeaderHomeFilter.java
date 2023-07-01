package mypackage.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class HeaderHomeFilter implements Filter {

    public void init(FilterConfig fConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        // Check if the session is null or invalid
        if (session == null || session.isNew()) {
            // Redirect to index.jsp unless it is already the requested page
            String requestedPage = httpRequest.getRequestURI();
            if (!requestedPage.endsWith("index.jsp")) {
                httpResponse.sendRedirect("index.jsp");
                return;
            }
        }

        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}
