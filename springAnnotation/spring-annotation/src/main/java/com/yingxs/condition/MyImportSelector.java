package com.yingxs.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector {

    /**
     * 返回值就是导入到容器中的组件全类名
     * @param annotationMetadata 当前标注Import注解的类的所有注解信息
     * @return
     */
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.yingxs.bean.Blue","com.yingxs.bean.Yellow"};
    }
}
