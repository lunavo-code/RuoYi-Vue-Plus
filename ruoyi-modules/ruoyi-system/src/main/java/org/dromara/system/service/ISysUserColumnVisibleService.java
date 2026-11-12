package org.dromara.system.service;

import com.baomidou.mybatisplus.spring.service.IService;
import org.dromara.system.domain.SysUserColumnVisible;
import org.dromara.system.domain.bo.SysUserColumnVisibleBo;
import org.dromara.system.domain.vo.SysUserColumnVisibleVo;

public interface ISysUserColumnVisibleService extends IService<SysUserColumnVisible> {
    String getSetting(String tableKey);

    void updateSetting(SysUserColumnVisibleBo bo);
}
