package socgen.iiht.userservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import socgen.iiht.userservice.MyUserDetailsService;
import socgen.iiht.userservice.util.JwtUtil;

import javax.servlet.http.HttpServletRequest;

@Component
public class Prefilter extends ZuulFilter {
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context=RequestContext.getCurrentContext();
        HttpServletRequest request=context.getRequest();
        String jwt=request.getHeader("Authorization");
        String token=jwt.substring(7);
        String username=jwtUtil.extractUsername(token);
        UserDetails userDetails= myUserDetailsService.loadUserByUsername(username);
        if(!jwtUtil.validateToken(token,userDetails)){
            context.unset();
            context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        System.out.println("pre-filter ran");
        return null;
    }
}
