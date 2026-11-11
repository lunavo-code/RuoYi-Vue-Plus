package org.dromara.common.enums;

/**
 * 提供业务编码、描述和排序值的枚举约定。
 */
public interface BaseEnum {

    /**
     * @return 业务编码
     */
    Integer getCode();

    /**
     * @return 枚举项描述
     */
    String getDesc();

    /**
     * @return 枚举项排序值
     */
    int getOrder();
}
