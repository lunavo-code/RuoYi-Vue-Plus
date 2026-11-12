package org.dromara.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dromara.common.mybatis.core.mapper.BaseMapperPlus;
import org.dromara.system.domain.SysUserColumnVisible;
import org.dromara.system.domain.vo.SysUserColumnVisibleVo;

@Mapper
public interface SysUserColumnVisibleMapper extends BaseMapperPlus<SysUserColumnVisible, SysUserColumnVisibleVo> {
}
