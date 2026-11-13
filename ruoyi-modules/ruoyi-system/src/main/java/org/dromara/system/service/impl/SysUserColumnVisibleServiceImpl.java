package org.dromara.system.service.impl;

import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.dromara.common.satoken.utils.LoginHelper;
import org.dromara.system.domain.SysUserColumnVisible;
import org.dromara.system.domain.bo.SysUserColumnVisibleBo;
import org.dromara.system.mapper.SysUserColumnVisibleMapper;
import org.dromara.system.service.ISysUserColumnVisibleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SysUserColumnVisibleServiceImpl extends ServiceImpl<SysUserColumnVisibleMapper, SysUserColumnVisible> implements ISysUserColumnVisibleService {
    private static final long DEFAULT_COLUMN_VISIBILITY = 0L;
    private final SysUserColumnVisibleMapper mapper;

    @Override
    public Long getSetting(String tableKey) {
        List<SysUserColumnVisible> list = mapper.lambda()
            .eq(SysUserColumnVisible::getUserId, LoginHelper.getUserId())
            .eq(SysUserColumnVisible::getTableKey, tableKey)
            .list();
        Long res = DEFAULT_COLUMN_VISIBILITY;
        if (list != null && !list.isEmpty()) {
            res = list.getLast().getColumnVisibility();
        }
        return res;
    }

    @Override
    public boolean updateSetting(SysUserColumnVisibleBo bo) {
        if (bo.getColumnVisibility() == null) {
            bo.setColumnVisibility(DEFAULT_COLUMN_VISIBILITY);
        }

        mapper.lambdaUpdate()
            .eq(SysUserColumnVisible::getUserId, LoginHelper.getUserId())
            .eq(SysUserColumnVisible::getTableKey, bo.getTableKey())
            .remove();

        SysUserColumnVisible entity = new SysUserColumnVisible();
        entity.setUserId(LoginHelper.getUserId());
        entity.setTableKey(bo.getTableKey());
        entity.setColumnVisibility(bo.getColumnVisibility());
        int insert = mapper.insert(entity);
        return insert > 0;
    }
}
