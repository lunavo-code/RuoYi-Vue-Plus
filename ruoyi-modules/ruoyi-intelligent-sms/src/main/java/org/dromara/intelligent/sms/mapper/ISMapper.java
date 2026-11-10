package org.dromara.intelligent.sms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.dromara.intelligent.sms.domain.IntelligentSms;

@Mapper
public interface ISMapper extends BaseMapper<IntelligentSms> {
}
