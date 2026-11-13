package org.dromara.system.controller.system;

import lombok.RequiredArgsConstructor;
import org.dromara.common.core.domain.R;
import org.dromara.system.domain.bo.SysUserColumnVisibleBo;
import org.dromara.system.service.ISysUserColumnVisibleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system/column/visible")
@RequiredArgsConstructor
public class SysUserColumnVisibleController {
    private final ISysUserColumnVisibleService service;

    /**
     * 通过表格唯一标识查询配置
     */
    @GetMapping("/{tableKey}")
    public R<Long> getSetting(@PathVariable String tableKey) {
        Long columnVisibility = service.getSetting(tableKey);
        return R.ok(R.OK_MSG, columnVisibility);
    }

    /**
     * 更新列显隐配置
     */
    @PutMapping("/update")
    public R<Boolean> update(SysUserColumnVisibleBo bo) {
        return R.ok(service.updateSetting(bo));
    }
}
