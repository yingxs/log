package com.yingxs.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义逻辑返回需要导入的组件
 * @author admin
 *
 */
public class MyImportSelector implements  ImportSelector {

	// 返回值就是要导入到容器中的组件全类名
	//AnnotationMetadata :当前标注@Import注解的类的所有注解信息
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		
		return new String[]{"com.yingxs.bean.Yellow","com.yingxs.bean.Blue"};
	}
}
