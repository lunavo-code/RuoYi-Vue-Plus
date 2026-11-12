package org.dromara.system.domain.bo;

import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dromara.system.domain.SysUserColumnVisible;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AutoMapper(target = SysUserColumnVisible.class, reverseConvertGenerate = false)
public class SysUserColumnVisibleBo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long userId;
    private String tableKey;
    private String columnVisibility;
}
