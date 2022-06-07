package com.clones.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CORSFilter implements Filter {
    public void init(FilterConfig filterConfig) {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
//        HttpServletRequest request = (HttpServletRequest) req;

//        String requestUri = request.getRequestURI();
//
//        // Является ли операцией авторизации
//        boolean isLoginOperation = requestUri.equals("/api/login");
//
//        // Получаем сессию
//        HttpSession session = request.getSession(false);
//
//        if(session == null) { // Если при запросе у нас не установлена сессия
//            if(!isLoginOperation) { // И это не операция авторизации
//                response.setStatus(401); // То необходимо вернуть UNAUTHORIZED
//                return;
//            }
//        }else { // Если сессия создана, то необходимо проверить данные
//            Cookie[] cookies = request.getCookies();
//            Optional<Cookie> jsId = Arrays.stream(cookies).filter(cookie -> cookie.getName().equals("JSESSIONID")).findFirst();
//            if(!jsId.isPresent()) { // Если нет идентификатора сессии в куках
//                response.setStatus(401); // То необходимо вернуть UNAUTHORIZED
//                return;
//            }else { // Если ид сессии в куках есть
//                if(!session.getId().equals(jsId.get().getValue())) {//Если ид сессии в куках и запросе не сопадают
//                    response.setStatus(401); // Необходимо вернуть UNAUTHORIZED
//                    return;
//                }
//            }
//        }

        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Authorization, Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
        chain.doFilter(req, res);
    }

    public void destroy() {
    }
}
