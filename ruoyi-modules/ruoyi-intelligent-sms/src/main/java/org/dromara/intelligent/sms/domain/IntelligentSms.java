package org.dromara.intelligent.sms.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class IntelligentSms extends BaseEntity {
    private Long id;
    private String phone;
    private Integer status;
    private String content;
}
