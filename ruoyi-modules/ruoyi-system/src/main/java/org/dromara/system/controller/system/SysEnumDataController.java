package org.dromara.system.controller.system;

import lombok.RequiredArgsConstructor;
import org.dromara.common.core.domain.R;
import org.dromara.common.enums.domain.EnumInfo;
import org.dromara.common.enums.service.FrontendEnumService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/enum/data")
public class SysEnumDataController {
    private final FrontendEnumService frontendEnumService;

    /**
     * @return 当前用户可见的前端枚举组
     */
    @GetMapping("/list")
    public R<Map<String, EnumInfo>> enums() {
        return R.ok(frontendEnumService.getOptions());
    }

    @GetMapping("/type/{key}")
    public R<EnumInfo> enumInfo(@PathVariable String key) {
        EnumInfo option = frontendEnumService.getOption(key);
        return R.ok(option);
    }

    @GetMapping("/map")
    public R<Map<String, String>> enumsMap() {
        Map<String, String> map = frontendEnumService.keyMap();
        return R.ok(map);
    }
}
