package com.ww.fallBack;

import com.ww.entity.User;
import com.ww.service.IndexService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class MyFallBackFactory implements FallbackFactory<IndexService> {

    @Override
    public IndexService create(Throwable throwable) {
        return new IndexService() {
            @Override
            public String test06() {
                return throwable.getMessage();
            }

            @Override
            public String test07(String name, Integer id) {
                return throwable.getMessage();
            }

            @Override
            public String test08(User user) {
                return throwable.getMessage();
            }
        };
    }
}
