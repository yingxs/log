package com.yingxs.anno;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service(value="user")     //<bean id="user" class=""></bean>
@Scope(value="prototype")
public class User {
	public void add() {
		System.out.println("add.........");
	}
}
