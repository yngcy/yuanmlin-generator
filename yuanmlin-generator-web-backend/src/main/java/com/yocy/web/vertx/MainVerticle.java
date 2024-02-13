package com.yocy.web.vertx;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yocy.web.common.ResultUtils;
import com.yocy.web.controller.GeneratorController;
import com.yocy.web.manager.CacheManager;
import com.yocy.web.model.dto.generator.GeneratorQueryRequest;
import com.yocy.web.model.vo.GeneratorVO;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerResponse;

/**
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
public class MainVerticle extends AbstractVerticle {
    
    private CacheManager cacheManager;
    
    public MainVerticle(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Override
    public void start() throws Exception {
        
        vertx.createHttpServer()
                .requestHandler(
                        req -> {
                            HttpMethod httpMethod = req.method();
                            String path = req.path();
                            // 分页获取生成器
                            if (HttpMethod.POST.equals(httpMethod) && "/generator/page".equals(path)) {
                                // 处理请求体处理器
                                req.handler(buffer -> {
                                    // 获取请求体中的 JSOn 数据
                                    String requestBody = buffer.toString();
                                    GeneratorQueryRequest generatorQueryRequest = JSONUtil.toBean(requestBody, GeneratorQueryRequest.class);
                                    
                                    // 处理 JSON 数据
                                    // 在实际应用中，这里可以解析 JSON、执行业务逻辑等
                                    String cacheKey = GeneratorController.getPageCacheKey(generatorQueryRequest);
                                    
                                    // 设置响应头
                                    HttpServerResponse response = req.response();
                                    response.putHeader("content-type", "application/json");
                                    
                                    // 本地缓存
                                    Object cacheValue = cacheManager.get(cacheKey);
                                    if (cacheValue != null) {
                                        // 返回 JSON 响应
                                        response.end(JSONUtil.toJsonStr(ResultUtils.success((Page<GeneratorVO>)cacheValue)));
                                        return;
                                    }
                                    
                                    response.end("");
                                });
                                        
                            }
                        })
                .listen(8888)
                .onSuccess(server -> {
                    System.out.println(
                            "Http server port started on port " + server.actualPort()
                    );
                });
    }
    
}
