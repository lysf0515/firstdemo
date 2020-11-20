package com.util;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * VO/ENTITY双向转换工具类
 * @author 16477
 */
public class PojoUtil {

    /**
     * 对象copy
     * 将源对象的同名属性copy目标对象
     * @param source    目标对象
     * @param tClass    返回值类型参数
     * @param <S>       目标资源类型
     * @param <T>       返回值类型
     * @return
     */
    public static <S,T> T copyObject(S source,Class<T> tClass){
        try {
            //通过类类型创建对象
            T target = tClass.newInstance();
            //将vo的属性拷贝到entity中
            BeanUtils.copyProperties(source,target);
            return target;
        } catch (Exception e) {
            //抛出运行时异常，执行回滚操作
            throw new RuntimeException(e);
        }
    }


    /**
     * 将源列表的属性，copy到目标列表上
     * @param sourceList    源列表参数
     * @param tClass    返回值列表泛型参数
     * @param <T>   返回值列表的类型
     * @param <S>   源列表的类型
     * @return
     */
    public static <T,S> List<T> copyList(List<S> sourceList,Class<T> tClass ){
        return sourceList.stream()
                .map(entity ->copyObject(entity,tClass))
                .collect(Collectors.toList());
    }
}
