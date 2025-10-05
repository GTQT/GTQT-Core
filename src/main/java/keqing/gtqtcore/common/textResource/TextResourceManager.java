package keqing.gtqtcore.common.textResource;

import com.google.common.collect.Maps;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IResource;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 泛型文本资源管理器
 * 用于加载和存储 resources/assets/gtqtcore/update/ 下的文本文件
 */
public class TextResourceManager<T extends Enum<T>> {

    private final String domain;
    private final String basePath;
    private final Class<T> textTypeClass;
    private final Map<T, String> textCache;
    private final Map<T, Boolean> loadStatus;

    public TextResourceManager(String domain, String basePath, Class<T> textTypeClass) {
        this.domain = domain;
        this.basePath = basePath.endsWith("/") ? basePath : basePath + "/";
        this.textTypeClass = textTypeClass;
        this.textCache = new ConcurrentHashMap<>();
        this.loadStatus = new ConcurrentHashMap<>();
    }

    /**
     * 预加载所有文本资源
     */
    public void preloadAll() {
        for (T textType : textTypeClass.getEnumConstants()) {
            loadTextResource(textType);
        }
    }

    /**
     * 加载指定类型的文本资源
     */
    public boolean loadTextResource(T textType) {
        String fileName = textType.name().toLowerCase() + ".txt";
        ResourceLocation resourceLocation = new ResourceLocation(domain, basePath + fileName);

        try {
            // 尝试使用Minecraft的资源管理器
            IResource resource = Minecraft.getMinecraft().getResourceManager().getResource(resourceLocation);
            InputStream inputStream = resource.getInputStream();

            String content = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            textCache.put(textType, content);
            loadStatus.put(textType, true);

            inputStream.close();
            return true;

        } catch (IOException e) {
            System.err.println("无法加载文本资源: " + resourceLocation);
            System.err.println("错误: " + e.getMessage());

            // 标记为加载失败
            loadStatus.put(textType, false);
            return false;
        }
    }

    /**
     * 获取文本内容
     */
    public String getText(T textType) {
        if (!textCache.containsKey(textType)) {
            loadTextResource(textType);
        }
        return textCache.getOrDefault(textType, "文本加载失败: " + textType.name());
    }

    /**
     * 获取文本内容，带默认值
     */
    public String getText(T textType, String defaultValue) {
        if (!textCache.containsKey(textType) && !loadTextResource(textType)) {
            return defaultValue;
        }
        return textCache.getOrDefault(textType, defaultValue);
    }

    /**
     * 检查文本是否已加载
     */
    public boolean isLoaded(T textType) {
        return loadStatus.getOrDefault(textType, false);
    }

    /**
     * 重新加载所有文本
     */
    public void reloadAll() {
        textCache.clear();
        loadStatus.clear();
        preloadAll();
    }

    /**
     * 获取所有已加载的文本类型
     */
    public Map<T, String> getAllLoadedTexts() {
        return Maps.newHashMap(textCache);
    }

    /**
     * 获取加载状态报告
     */
    public String getLoadStatusReport() {
        StringBuilder report = new StringBuilder("文本资源加载状态:\n");
        for (T textType : textTypeClass.getEnumConstants()) {
            String status = loadStatus.getOrDefault(textType, false) ? "✓" : "✗";
            report.append(String.format("  %s %s: %s\n", status, textType.name(),
                    loadStatus.getOrDefault(textType, false) ? "已加载" : "未加载"));
        }
        return report.toString();
    }
}