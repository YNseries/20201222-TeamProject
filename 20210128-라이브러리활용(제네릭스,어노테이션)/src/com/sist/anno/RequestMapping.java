package com.sist.anno;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
/*
 *     class A
 *     {
 *         @RequestinMapping("aaa")
 *         public void aaa(){}
 *         @RequestMapping
 *         public void bbb(){}
 *         public void ccc(){}
 *     }
 */
// @RequestMapping("구분문자")  // 구분문자는 반드시 넣고, 다 달라야 함
@Retention(RUNTIME)
@Target(METHOD)
public @interface RequestMapping {
	public String value();

}
