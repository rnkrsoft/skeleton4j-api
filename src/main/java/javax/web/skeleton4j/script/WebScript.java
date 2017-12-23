package javax.web.skeleton4j.script;


import java.util.List;

/**
 * Created by devops4j on 2017/10/12.
 * 脚本包装
 */
public interface WebScript {

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

    List<ReferenceWebScript> getDependencies();

    boolean isAsync();

    void setAsync(boolean async);

    /**
     * 是否有内容
     *
     * @return
     */
    boolean hasContent();

}
