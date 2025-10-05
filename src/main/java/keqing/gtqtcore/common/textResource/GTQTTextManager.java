package keqing.gtqtcore.common.textResource;

/**
 * 文本资源管理器单例
 */
public class GTQTTextManager {

    private static TextResourceManager<TextType> instance;

    public static TextResourceManager<TextType> getInstance() {
        if (instance == null) {
            instance = new TextResourceManager<>(
                    "gtqtcore",
                    "update",
                    TextType.class
            );
        }
        return instance;
    }

    /**
     * 初始化并预加载所有文本
     */
    public static void init() {
        getInstance().preloadAll();
        System.out.println(getInstance().getLoadStatusReport());
    }

    /**
     * 便捷方法：获取特定类型的文本
     */
    public static String getText(TextType textType) {
        return getInstance().getText(textType);
    }

    /**
     * 便捷方法：获取特定类型的文本，带默认值
     */
    public static String getText(TextType textType, String defaultValue) {
        return getInstance().getText(textType, defaultValue);
    }
}