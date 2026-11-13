package org.dromara.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.dromara.common.mybatis.core.domain.BaseEntity;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user_column_visible")
public class SysUserColumnVisible extends BaseEntity {
    private Long id;
    private Long userId;
    private String tableKey;
    private Long columnVisibility;
}
