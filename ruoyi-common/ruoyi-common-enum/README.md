注解如果没有地方引用，会呈现灰色，通过一下方式可以将有@FrontendEnum注解的枚举类显示成有地方在使用。

在 IntelliJ IDEA 里把 @FrontendEnum 配置为 Unused declaration 检查的入口点注解。
配置一次后，以后加上这个注解的枚举都会被 IDEA 视为已使用，无需修改 Java 代码。
1. 打开设置，搜索 Unused declaration。
2. 选中 Editor → Inspections → Java → Declaration redundancy → Unused declaration。
3. 打开 Entry points → Annotations…，在 Mark as entry point if annotated by 中添加 org.dromara.common.enums.anno.FrontendEnum，然后应用设置。 
4. 如果要让团队共享这个规则，可以提交项目级 inspection profile。当前仓库会忽略 .idea/inspectionProfiles/Project_Default.xml，共享时需要为该配置文件添加 Git 忽略例外。