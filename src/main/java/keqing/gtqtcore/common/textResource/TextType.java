package keqing.gtqtcore.common.textResource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 文本类型枚举
 * 每个枚举值对应 resources/assets/gtqtcore/update/ 下的一个txt文件
 */
public enum TextType {
    LOG("更新日志"),           // 对应 log.txt
    NOTICE("重要通知"),        // 对应 notice.txt
    INTRODUCTION("内容介绍"),  // 对应 introduction.txt
    HELP("使用帮助"),          // 对应 help.txt
    TUTORIAL("教程指南"),      // 对应 tutorial.txt
    CREDITS("制作人员"),       // 对应 credits.txt
    LICENSE("许可证");         // 对应 license.txt

    private final String displayName;

    TextType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    /**
     * 获取所有可显示的文本类型（过滤掉一些不需要在UI中显示的类型）
     */
    public static List<TextType> getDisplayableTypes() {
        return Arrays.asList(LOG, NOTICE, INTRODUCTION, HELP, TUTORIAL,CREDITS,LICENSE);
    }

    /**
     * 根据显示名称查找枚举
     */
    public static Optional<TextType> fromDisplayName(String displayName) {
        return Arrays.stream(values())
                .filter(type -> type.getDisplayName().equals(displayName))
                .findFirst();
    }
}