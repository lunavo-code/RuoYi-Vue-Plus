package org.dromara.common.enums.anno;

import org.dromara.common.enums.BaseEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 将实现 {@link BaseEnum} 的枚举注册为前端选项。
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FrontendEnum {

    /**
     * @return 前端查询使用的唯一键
     */
    String value();

    /**
     * @return 枚举描述
     */
    String description() default "";

    /**
     * @return 查看该枚举组所需的权限标识，空字符串表示登录后可见
     */
    String permission() default "";
}
