package sistema.reclamos.middleware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import sistema.reclamos.entity.Usuario;

public class LoginMid implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String uri = request.getRequestURI();
        HttpSession session = request.getSession(false);

        // Rutas públicas																																		       // ver img
        if (uri.matches(".*/(login|logout|registro|error).*") || uri.contains("/login") || uri.contains("/webjars") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/img/"))  {
            return true;
        }

        Usuario usuario = (session != null) ? (Usuario) session.getAttribute("usuarioLogueado") : null;

        if (usuario == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
        
        if (uri.startsWith("/admin") && !"ADMIN".equals(usuario.getRol())) {
            response.sendRedirect(request.getContextPath() + "/denegado");
            return false;
        }

        return true;
    }
}