package org.dromara.system.service;

import com.baomidou.mybatisplus.spring.service.IService;
import org.dromara.system.domain.SysUserColumnVisible;
import org.dromara.system.domain.bo.SysUserColumnVisibleBo;

public interface ISysUserColumnVisibleService extends IService<SysUserColumnVisible> {
    Long getSetting(String tableKey);

    boolean updateSetting(SysUserColumnVisibleBo bo);
}
