package com.yocy.web.common;

import java.io.Serializable;
import lombok.Data;

/**
 * 删除请求
 *
 * @author <a href="https://github.com/yngcy">YounGCY</a>
 */
@Data
public class DeleteRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}