package org.dromara.common.enums.util;

import cn.hutool.core.util.EnumUtil;
import lombok.experimental.UtilityClass;
import org.dromara.common.enums.BaseEnum;

/**
 * 按业务编码或常量名查找枚举项。
 */
@UtilityClass
public class EnumUtils {

    /**
     * 按区分大小写的枚举常量名查找枚举项。
     *
     * @param enumClass 枚举类型
     * @param name      枚举常量名
     * @param <E>       枚举类型
     * @return 匹配的枚举项，名称为空或无匹配时返回 {@code null}
     */
    public static <E extends Enum<E>> E getByName(Class<E> enumClass, String name) {
        return name == null ? null : EnumUtil.fromStringQuietly(enumClass, name);
    }

    /**
     * 按声明顺序查找首个业务编码匹配的枚举项。
     *
     * @param enumClass 枚举类型
     * @param code      业务编码
     * @param <E>       实现 {@link BaseEnum} 的枚举类型
     * @return 匹配的枚举项，编码为空或无匹配时返回 {@code null}
     */
    public static <E extends Enum<E> & BaseEnum> E getByCode(Class<E> enumClass, Integer code) {
        if (code == null) {
            return null;
        }
        return EnumUtil.getBy(enumClass, item -> code.equals(item.getCode()));
    }

    /**
     * 判断业务编码是否对应枚举项。
     *
     * @param enumClass 枚举类型
     * @param name      枚举名称
     * @param <E>       实现 {@link BaseEnum} 的枚举类型
     * @return 存在匹配项时返回 {@code true}，名称为空或无匹配时返回 {@code false}
     */
    public static <E extends Enum<E> & BaseEnum> boolean containsName(Class<E> enumClass, String name) {
        return getByName(enumClass, name) != null;
    }

    /**
     * 按业务编码获取必须存在的枚举项。
     *
     * @param enumClass 枚举类型
     * @param name      枚举名称
     * @param <E>       实现 {@link BaseEnum} 的枚举类型
     * @return 匹配的枚举项
     * @throws IllegalArgumentException 编码为空或无匹配时抛出
     */
    public static <E extends Enum<E> & BaseEnum> E requireByName(Class<E> enumClass, String name) {
        E item = getByName(enumClass, name);
        if (item == null) {
            throw new IllegalArgumentException("No enum constant in " + enumClass.getName() + " for name " + name);
        }
        return item;
    }

    /**
     * 判断业务编码是否对应枚举项。
     *
     * @param enumClass 枚举类型
     * @param code      业务编码
     * @param <E>       实现 {@link BaseEnum} 的枚举类型
     * @return 存在匹配项时返回 {@code true}，编码为空或无匹配时返回 {@code false}
     */
    public static <E extends Enum<E> & BaseEnum> boolean containsCode(Class<E> enumClass, Integer code) {
        return getByCode(enumClass, code) != null;
    }

    /**
     * 按业务编码获取必须存在的枚举项。
     *
     * @param enumClass 枚举类型
     * @param code      业务编码
     * @param <E>       实现 {@link BaseEnum} 的枚举类型
     * @return 匹配的枚举项
     * @throws IllegalArgumentException 编码为空或无匹配时抛出
     */
    public static <E extends Enum<E> & BaseEnum> E requireByCode(Class<E> enumClass, Integer code) {
        E item = getByCode(enumClass, code);
        if (item == null) {
            throw new IllegalArgumentException("No enum constant in " + enumClass.getName() + " for code " + code);
        }
        return item;
    }
}
