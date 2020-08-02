package com.ww.hystrix;

import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

public class MyHystrix extends HystrixCommand {

    private RestTemplate restTemplate;
    private String url;

    public MyHystrix(Setter setter,RestTemplate restTemplate,String url) {
        super(setter);
        this.restTemplate=restTemplate;
        this.url=url;
    }

    /**
     * spring会自动调用这个方法来访问服务提供者
     * */
    @Override
    protected Object run() throws Exception {
        return restTemplate.getForObject(url,Object.class);
    }

    /**
     * 服务降级方法，当spring自动调用run方法之后，
     * 如果服务出现了异常则自动调用这个服务来进行异常的熔断
     * */
    @Override
    protected Object getFallback() {
        System.out.println(super.getFailedExecutionException().getClass());
        System.out.println(super.getFailedExecutionException().getMessage());

        return "自定义异常熔断器";
    }
}
