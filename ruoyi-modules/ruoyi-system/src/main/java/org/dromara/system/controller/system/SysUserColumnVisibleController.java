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

    @GetMapping("/{tableKey}")
    public R<String> getSetting(@PathVariable String tableKey) {
        String columnVisibility = service.getSetting(tableKey);
        return R.ok(R.OK_MSG, columnVisibility);
    }

    @PutMapping("/update")
    public R<Void> update(SysUserColumnVisibleBo bo) {
        service.updateSetting(bo);
        return R.ok();
    }
}
