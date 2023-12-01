package cn.xd.learn.configuration;
import ch.qos.logback.classic.helpers.MDCInsertingServletFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class FilterConfig {
    /**
     * MDCInsertingServletFilter往mdc中添加了如下key
     * req.remoteHost	as returned by the getRemoteHost() method
     * req.xForwardedFor	value of the "X-Forwarded-For" header
     * req.method	as returned by getMethod() method
     * req.requestURI	as returned by getRequestURI() method
     * req.requestURL	as returned by getRequestURL() method
     * req.queryString	as returned by getQueryString() method
     * req.userAgent	value of the "User-Agent" header
     * @return
     */
    @Bean
    public FilterRegistrationBean<MDCInsertingServletFilter> requestTimingFilter() {
        FilterRegistrationBean<MDCInsertingServletFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new MDCInsertingServletFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}

