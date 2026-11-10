package org.dromara.intelligent.sms.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dromara.common.core.domain.R;
import org.dromara.intelligent.sms.domain.IntelligentSms;
import org.dromara.intelligent.sms.service.IISService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ss")
@Slf4j
@SaIgnore
@RequiredArgsConstructor
public class ISController {

    private final IISService service;

    @PostMapping
    public R<Void> add(@RequestBody IntelligentSms sms) {
        boolean save = service.save(sms);
        String phone = sms.getPhone();
        long l = Long.parseLong(phone);
        log.error("db: {}, table: {}", ((l / 10000) % 10000) % 6, (l % 10000) % 4);
        return save ? R.ok() : R.fail();
    }

    @GetMapping
    public R<List<IntelligentSms>> list() {
        List<IntelligentSms> list = service.list();
        return R.ok(list);
    }

    @GetMapping("{phone}")
    public R<List<IntelligentSms>> byPhone(@PathVariable String phone) {
        LambdaQueryWrapper<IntelligentSms> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(IntelligentSms::getPhone, phone);
        List<IntelligentSms> list = service.list(wrapper);
        return R.ok(list);
    }
}
