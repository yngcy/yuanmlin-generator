package com.yocy.web.service;

import com.yocy.web.model.entity.Generator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 */
@SpringBootTest
public class GeneratorServiceTest {
    
    @Resource
    private GeneratorService generatorService;
    
    @Test
    public void testInsert() {
        Generator generator = generatorService.getById(8L);
        for (int i = 0; i < 100000; i++) {
            generator.setId(null);
            generatorService.save(generator);
        }
    }
}
