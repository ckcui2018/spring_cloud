package api.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class TokenFilter extends ZuulFilter {


    public TokenFilter() {
        System.out.println("TokenFilter start");
    }

    @Override
    public String filterType() {
         return "pre"; //定义filter的类型，有pre、route、post、error四种;
    }

    @Override
    public int filterOrder() {
        return 10;//定义filter的顺序，数字越小表示顺序越高，越先执行
    }

    @Override
    public boolean shouldFilter() {
        return true;//表示是否需要执行该filter，true表示执行，false表示不执行
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();


        System.out.println("--->>> TokenFilter {},{} "+request.getMethod() + request.getRequestURL().toString());

        String token = request.getParameter("token");// 获取请求的参数

        if (StringUtils.isNotBlank(token)) {
            ctx.setSendZuulResponse(true); //对请求进行路由
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);

           /* System.out.println(String.format("%s AccessTokenFilter request to %s", request.getMethod(),
                    request.getRequestURL().toString()));

            ctx.setResponseBody("{\"token\":\""+ token +"\"}");// 输出最终结果*/

            return null;
        } else {
            ctx.setSendZuulResponse(false); //不对其进行路由
            ctx.setResponseStatusCode(400);
            ctx.setResponseBody("token is empty");
            ctx.set("isSuccess", false);
            return null;
        }
    }

    /**
     * 将TokenFilter加入到请求拦截队列
     * @return
     */
//    @Bean
//    public TokenFilter tokenFilter() {
//        return new TokenFilter();
//    }
}
