package com.ww.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
@Component
public class MyZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //请求上下文
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //token,身份令牌用于验证请求身份是否合法
        String token = request.getParameter("token");
        //实际开发应访问数据库得到123
        if(token==null||!"123".equals(token)){
            //表示请求不继续执行
            requestContext.setSendZuulResponse(false);
            //401表示权限不足
            requestContext.setResponseStatusCode(401);
            //设置响应
            requestContext.addZuulResponseHeader("content-type","text/html;charset=utf-8");
            requestContext.setResponseBody("非法请求");
        }else{
            System.out.println("正在转发请求，请稍等..." );
        }
        return null;
    }
}
