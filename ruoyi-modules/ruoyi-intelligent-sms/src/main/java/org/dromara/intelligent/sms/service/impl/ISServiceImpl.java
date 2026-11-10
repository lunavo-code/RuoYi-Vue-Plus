package org.dromara.intelligent.sms.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import org.dromara.intelligent.sms.domain.IntelligentSms;
import org.dromara.intelligent.sms.mapper.ISMapper;
import org.dromara.intelligent.sms.service.IISService;
import org.springframework.stereotype.Service;

@Service
@DS("sharding")
public class ISServiceImpl extends ServiceImpl<ISMapper, IntelligentSms> implements IISService {
}
