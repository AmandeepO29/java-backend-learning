package in.strikes.filtersDemo.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

//@Component
public class ResponseBodyFilter implements Filter
{

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest =(HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse=(HttpServletResponse) servletResponse;

        ContentCachingResponseWrapper wrappedResponse =
                new ContentCachingResponseWrapper(httpServletResponse);

        filterChain.doFilter(servletRequest,wrappedResponse);

        byte[] originalBodyBytes= wrappedResponse.getContentAsByteArray();

        String originalBody=new String(originalBodyBytes);

        String modifiedBody= """
                {
                    "originalResponse" : %s,
                    "appName" :"Student management System"
                }
                """.formatted(originalBody);
        /*  %s is filled with the .formatted(originalBody)  , the originalBody is filled at
        * place of the %s */

        wrappedResponse.getWriter().write(modifiedBody);

        wrappedResponse.copyBodyToResponse();
    }
}
