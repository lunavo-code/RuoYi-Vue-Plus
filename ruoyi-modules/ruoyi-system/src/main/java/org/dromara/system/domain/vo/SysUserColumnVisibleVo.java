package org.dromara.system.domain.vo;

import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.system.domain.SysUserColumnVisible;

import java.io.Serial;
import java.io.Serializable;

@Data
@AutoMapper(target = SysUserColumnVisible.class)
public class SysUserColumnVisibleVo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long userId;
    private String tableKey;
    private String columnVisibility;
}
