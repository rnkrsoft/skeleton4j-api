package javax.web.doc;

import lombok.Getter;
import lombok.Setter;

import javax.web.doc.enums.ElementSetType;
import java.util.*;

/**
 * Created by rnkrsoft.com on 2017/12/7.
 */
public class ElementSet {
    @Getter
    ElementSetType elementSetType;
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
    final List<ElementInfo> elements = new ArrayList();
    /**
     * 分页字段
     */
    final List<ElementInfo> pageables = new ArrayList();

    /**
     * 新建一个元素集合
     *
     * @param elementClass
     */
    ElementSet(Class<?> elementClass, ElementSetType elementSetType) {
        this.elementClass = elementClass;
        this.elementSetType = elementSetType;
    }

    public List<ElementInfo> getElements() {
        return elements;
    }

    public List<ElementInfo> getPageables() {
        return pageables;
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
     * @param keyword 关键字 接受%查询
     * @return 结果
     */
    public List<ElementInfo> lookupFuzzy(String keyword) {
        List<ElementInfo> list = new ArrayList();
        for (String key : fullNameElements.keySet()) {
           if(keyword.startsWith("%") && keyword.endsWith("%")){
                if (key.contains(keyword.substring(1, keyword.length() -1))) {
                    list.add(fullNameElements.get(key));
                }
           }else if (keyword.startsWith("%")){
                if (key.endsWith(keyword.substring(1))) {
                    list.add(fullNameElements.get(key));
                }
            }else  if (keyword.endsWith("%")){
                if (key.startsWith(keyword.substring(0, keyword.length() - 1))) {
                    list.add(fullNameElements.get(key));
                }
            }else{
                if (key.contains(keyword)) {
                    list.add(fullNameElements.get(key));
                }
            }
        }
        return list;
    }
}
