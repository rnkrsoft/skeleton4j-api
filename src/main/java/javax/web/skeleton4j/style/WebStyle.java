package javax.web.skeleton4j.style;


import java.util.List;

/**
 * Created by devops4j on 2017/10/12.
 */
public interface WebStyle {

    String getAlias();

    void setAlias(String alias);

    String getSource();

    void setSource(String source);

    String getContent();

    void setContent(String content);

    String getVersion();

    void setVersion(String version);

    boolean isInline();

    void setInline(boolean inline);

    String getServerUrl();

    void setServerUrl(String serverUrl);

    String getProviderClass();

    void setProviderClass(String providerClass);

    List<ReferenceWebStyle> getDependencies();

    /**
     * 是否有内容
     *
     * @return
     */
    boolean hasContent();
}
