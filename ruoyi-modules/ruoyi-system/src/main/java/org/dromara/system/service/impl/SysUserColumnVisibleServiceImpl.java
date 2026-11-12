package org.dromara.system.service.impl;

import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.satoken.utils.LoginHelper;
import org.dromara.system.domain.SysUserColumnVisible;
import org.dromara.system.domain.bo.SysUserColumnVisibleBo;
import org.dromara.system.domain.vo.SysUserColumnVisibleVo;
import org.dromara.system.mapper.SysUserColumnVisibleMapper;
import org.dromara.system.service.ISysUserColumnVisibleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SysUserColumnVisibleServiceImpl extends ServiceImpl<SysUserColumnVisibleMapper, SysUserColumnVisible> implements ISysUserColumnVisibleService {
    private static final String DEFAULT_COLUMN_VISIBLE_STR = "{}";

    private final SysUserColumnVisibleMapper mapper;

    @Override
    public String getSetting(String tableKey) {
        List<SysUserColumnVisibleVo> list = mapper.lambda()
            .eq(SysUserColumnVisible::getUserId, LoginHelper.getUserId())
            .eq(SysUserColumnVisible::getTableKey, tableKey)
            .voList();

        String res;
        if (list == null || list.isEmpty()) {
            res = DEFAULT_COLUMN_VISIBLE_STR;
        } else if (list.size() > 1) {
            SysUserColumnVisibleVo vo = list.removeLast();
            mapper.deleteByIds(list.stream().map(SysUserColumnVisibleVo::getId).toList());
            res = vo.getColumnVisibility();
        } else {
            res = list.getLast().getColumnVisibility();
        }
        return res;
    }

    @Override
    public void updateSetting(SysUserColumnVisibleBo bo) {
        if (bo.getColumnVisibility() == null) {
            bo.setColumnVisibility(DEFAULT_COLUMN_VISIBLE_STR);
        }
        List<SysUserColumnVisibleVo> list = mapper.lambda()
            .eq(SysUserColumnVisible::getUserId, LoginHelper.getUserId())
            .eq(SysUserColumnVisible::getTableKey, bo.getTableKey())
            .voList();
        SysUserColumnVisible convert = MapstructUtils.convert(bo, SysUserColumnVisible.class);
        if (list == null || list.isEmpty() || list.size() > 2) {
            mapper.lambdaUpdate()
                .eq(SysUserColumnVisible::getUserId, LoginHelper.getUserId())
                .eq(SysUserColumnVisible::getTableKey, bo.getTableKey())
                .remove();
            mapper.insert(convert);
        } else {
            mapper.lambdaUpdate()
                .eq(SysUserColumnVisible::getUserId, LoginHelper.getUserId())
                .eq(SysUserColumnVisible::getTableKey, bo.getTableKey())
                .set(SysUserColumnVisible::getColumnVisibility, bo.getColumnVisibility());
        }
    }
}
