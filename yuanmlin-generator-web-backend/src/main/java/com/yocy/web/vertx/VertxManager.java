package com.yocy.web.vertx;

import com.yocy.web.manager.CacheManager;
import io.vertx.core.Verticle;
import io.vertx.core.Vertx;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
@Component
public class VertxManager {
    
    @Resource
    private CacheManager cacheManager;
    
    @PostConstruct
    public void init() {
        Vertx vertx = Vertx.vertx();
        Verticle myVerticle = new MainVerticle(cacheManager);
        
        vertx.deployVerticle(myVerticle);
    }
}
