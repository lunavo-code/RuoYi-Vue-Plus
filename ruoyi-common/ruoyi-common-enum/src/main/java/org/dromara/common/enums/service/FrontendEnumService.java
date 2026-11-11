package org.dromara.common.enums.service;

import cn.dev33.satoken.stp.StpUtil;
import org.dromara.common.enums.BaseEnum;
import org.dromara.common.enums.anno.FrontendEnum;
import org.dromara.common.enums.domain.EnumInfo;
import org.dromara.common.enums.domain.EnumOption;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 启动时收集项目中的前端枚举选项。
 */
@Component
public class FrontendEnumService {

    private final Map<String, EnumInfo> options;
    private final List<EnumInfo> keyList;

    public FrontendEnumService(ResourceLoader resourceLoader) {
        var scanner = new ClassPathScanningCandidateComponentProvider(false) {
            @Override
            protected boolean isCandidateComponent(AnnotatedBeanDefinition definition) {
                return definition.getMetadata().isIndependent();
            }
        };
        scanner.setResourceLoader(resourceLoader);
        scanner.addIncludeFilter(new AnnotationTypeFilter(FrontendEnum.class, false));

        Map<String, EnumInfo> registered = new TreeMap<>();
        for (var candidate : scanner.findCandidateComponents("org.dromara")) {
            String beanClassName = candidate.getBeanClassName();
            if (beanClassName == null) continue;
            Class<?> enumType = ClassUtils.resolveClassName(beanClassName, resourceLoader.getClassLoader());
            Assert.state(
                enumType.isEnum() && BaseEnum.class.isAssignableFrom(enumType),
                () -> "@FrontendEnum requires an enum implementing BaseEnum: " + enumType.getName()
            );
            FrontendEnum annotation = enumType.getAnnotation(FrontendEnum.class);
            String key = annotation.value();
            Assert.hasText(key, () -> "Empty @FrontendEnum key: " + enumType.getName());
            List<EnumOption> items = Arrays.stream((BaseEnum[]) enumType.getEnumConstants())
                .sorted(Comparator.comparingInt(BaseEnum::getOrder))
                .map(item -> new EnumOption(item.getCode(), item.getDesc(), item.getOrder()))
                .toList();
            EnumInfo enumInfo = new EnumInfo(key, annotation.description(), annotation.permission(), items);
            Assert.state(registered.putIfAbsent(key, enumInfo) == null, () -> "Duplicate @FrontendEnum key: " + key);
        }
        options = Collections.unmodifiableMap(registered);
        keyList = new ArrayList<>(options.values());
    }

    /**
     * @return 当前用户可见的枚举组
     */
    public Map<String, EnumInfo> getOptions() {
        Map<String, EnumInfo> visible = new LinkedHashMap<>();
        options.forEach((key, entry) -> {
            if (hasPermission(entry.getPermission())) {
                visible.put(key, entry);
            }
        });
        return visible;
    }

    public EnumInfo getOption(String key) {
        EnumInfo enumInfo = options.get(key);
        if (enumInfo == null) return null;
        return hasPermission(enumInfo.getPermission()) ? enumInfo : null;
    }

    public Map<String, String> keyMap() {
        return keyList.stream()
            .filter(i -> hasPermission(i.getPermission()))
            .collect(Collectors.toMap(
                EnumInfo::getKey,
                EnumInfo::getDescription
            ));
    }

    private boolean hasPermission(String permission) {
        return permission.isEmpty() || "*.*.*".equals(permission) || StpUtil.hasPermission(permission);
    }
}
