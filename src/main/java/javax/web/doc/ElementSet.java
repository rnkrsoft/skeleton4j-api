package javax.web.doc;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by devops4j on 2017/12/7.
 */
public class ElementSet {
    /**
     * 类对象
     */
    @Getter
    Class<?> elementClass;
    /**
     * 是否允许分页
     * 只要实现分页接口，则有分页功能
     */
    @Getter
    @Setter
    boolean pageable;
    /**
     * dot分割的全名称
     */
    @Getter
    final Map<String, ElementInfo> fullNameElements = new HashMap();
    /**
     * 非分页字段
     */
    @Getter
    final List<ElementInfo> elements = new ArrayList();
    /**
     * 分页字段
     */
    @Getter
    final List<ElementInfo> pageables = new ArrayList();

    /**
     * 新建一个元素集合
     *
     * @param elementClass
     */
    ElementSet(Class<?> elementClass) {
        this.elementClass = elementClass;
    }

    /**
     * 获取所有字段元素
     *
     * @return 字段元素列表
     */
    public List<ElementInfo> getAllElements() {
        List<ElementInfo> list = new ArrayList();
        for (ElementInfo e : elements) {
            list.add(e);
        }
        for (ElementInfo e : pageables) {
            list.add(e);
        }
        return list;
    }


    /**
     * 根据字段完整名称查询
     *
     * @param fullName 完整名称
     * @return 字段信息
     */
    public ElementInfo lookupFullName(String fullName) {
        return fullNameElements.get(fullName);
    }

    /**
     * 根据关键字模糊查找字段
     *
     * @param keyword 关键字
     * @return 结果
     */
    public List<ElementInfo> lookupFuzzy(String keyword) {
        List<ElementInfo> list = new ArrayList();
        for (String key : fullNameElements.keySet()) {
            if (key.contains(keyword)) {
                list.add(fullNameElements.get(key));
            }
        }
        return list;
    }
}
