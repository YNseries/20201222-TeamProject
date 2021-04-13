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
// @RequestMapping("���й���")  // ���й��ڴ� �ݵ�� �ְ�, �� �޶�� ��
@Retention(RUNTIME)
@Target(METHOD)
public @interface RequestMapping {
	public String value();

}
