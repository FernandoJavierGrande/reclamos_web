package sistema.reclamos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import sistema.reclamos.middleware.LoginMid;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginMid())
                .addPathPatterns("/**") // Aplica a todo
                .excludePathPatterns(
                "/login",
                "/denegado",
                "/logout",
                "/registro",
                "/error",
                "/css/**",
                "/js/**",
                "/img/**",
                "/webjars/**"
            ); // Excepciones
    }
}