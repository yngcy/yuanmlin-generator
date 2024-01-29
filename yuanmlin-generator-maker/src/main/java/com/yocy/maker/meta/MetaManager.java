package com.yocy.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

/**
 * @author <a href="https://github.com/ygncy">YounGCY</a>
 * @description
 */
public class MetaManager {
    
    private static volatile Meta meta;
    
    private MetaManager() {}
    
    public static Meta getMetaObject() {
        if (meta == null) {
            synchronized (MetaManager.class) {
                if (meta == null) {
                    meta = initMeta();
                }
            }
        }
        return meta;
    }
    
    private static Meta initMeta() {
        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        Meta newMeta = JSONUtil.toBean(metaJson, Meta.class);
        Meta.FileConfig fileConfig = newMeta.getFileConfig();
        // todo 校验和处理默认值
        return newMeta;
    }
}