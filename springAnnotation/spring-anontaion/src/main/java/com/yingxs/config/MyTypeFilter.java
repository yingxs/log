package com.yingxs.config;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class MyTypeFilter implements TypeFilter {

	/**
	 * metadataReader 读取到当前正在扫描的类的信息
	 * MetadataReaderFactory 可以获取到其他任何类的信息
	 */
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		// 获取当前类注解的信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		// 获取当前正在扫描的类的类信息
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		 // 获取当前类资源(类路径)
		Resource resource = metadataReader.getResource();
		
		String className = classMetadata.getClassName();
		System.out.println("--->"+className);
		if (className.contains("er") ) {
			return true;
		}
		
		/**
		 * 该方法会扫描到该方法下所有的类，并通过自定义规则来决定是否加入容器
		 */
		
		
		return false;
	}

}
