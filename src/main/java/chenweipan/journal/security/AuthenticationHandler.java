package chenweipan.journal.security;


import chenweipan.journal.model.Code;
import chenweipan.journal.model.CommonResult;
import chenweipan.journal.po.JournalUser;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationHandler implements AuthenticationSuccessHandler, AuthenticationFailureHandler,
        AuthenticationEntryPoint, LogoutSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationHandler.class);

    private Gson gson = new Gson();

    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        logger.info("commence ip:{} uri:{} message:{}", request.getRemoteHost(), request.getRequestURL(),
                exception.getLocalizedMessage());
        request.getSession().invalidate();
        response.setStatus(HttpServletResponse.SC_OK);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json");

        CommonResult result = new CommonResult();
        result.setCode(Code.NOT_LOGIN.name());
        result.setDetail(Code.NOT_LOGIN.getMessage());
        String resultstr = gson.toJson(result);
        response.getWriter().write(resultstr);

    }

    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        logger.info("commence ip:{} uri:{} message:{}", request.getRemoteHost(), request.getRequestURL(),
                exception.getLocalizedMessage());
        request.getSession().invalidate();
        response.setStatus(HttpServletResponse.SC_OK);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json");

        CommonResult result = new CommonResult();
        result.setCode(Code.NAME_PWD_ERROR.name());
        result.setDetail(Code.NAME_PWD_ERROR.getMessage());
        String resultstr = gson.toJson(result);
        response.getWriter().write(resultstr);

    }

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        logger.info("login success {} {}", request.getRemoteAddr(), request.getParameter("name"));
        response.setStatus(HttpServletResponse.SC_OK);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json");

        CommonResult result = new CommonResult();
        result.setCode(Code.SUCCESS.name());
        JournalUser user = (JournalUser) authentication.getPrincipal();
        result.setDetail(user.getUsername());
        String resultstr = gson.toJson(result);
        response.getWriter().write(resultstr);

    }

    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
            throws IOException, ServletException {
        logger.info("logout success {} {}", request.getRemoteAddr());

        if (auth != null) {
            response.setStatus(HttpServletResponse.SC_OK);
        }

        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");

        CommonResult result = new CommonResult();
        result.setCode(Code.SUCCESS.name());
        result.setDetail("登出成功");
        String resultstr = gson.toJson(result);
        response.getWriter().write(resultstr);

    }

}
