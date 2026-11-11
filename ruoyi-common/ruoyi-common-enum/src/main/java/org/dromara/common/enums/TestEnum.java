package org.dromara.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dromara.common.enums.anno.FrontendEnum;

@AllArgsConstructor
@Getter
@FrontendEnum(value = "test_enum", description = "测试枚举交互", permission = "s.s.s")
public enum TestEnum implements BaseEnum {

    A(1, "测试1", 1),
    B(2, "测试2", 2),
    C(3, "测试3", 3),
    D(4, "测试4", 4);

    private final Integer code;
    private final String desc;
    private final int order;
}
