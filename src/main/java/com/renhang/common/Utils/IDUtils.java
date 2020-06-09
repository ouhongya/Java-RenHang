package com.renhang.common.Utils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 各种id生成策略
 */
public class IDUtils {

	/**
	 * 随机生成UUID 小写
	 */
	public static String get32UUID() {
		return UUID.randomUUID().toString().trim().replaceAll("-", "");
	}
	/**
	 * 随机生成UUID 大写
	 */
	public static String getId(){
		return UUID.randomUUID().toString().trim().replace("-", "").toUpperCase();
	}	
	/**
	 * 生成32位随机码
	 */
	public static String getCode(){
		return getId();
	}

	private static Random rand;
	static{
		rand = new Random();
	}

	/**
	 * 随机获取一个大写字母
	 * @param
	 */
	public static char getUpper(){
		char c=(char)getRadomInt(65, 90);
		return c;
	}
	
	/**
	 * 随机获取一个0-9的数字
	 * @return
	 */
	public static int getNum(){
		return getRadomInt(0, 9);
	}
	
	/**
	 * 获取一个范围内的随机数字
	 * @return
	 */
	public static int getRadomInt(int min,int max){
		return rand.nextInt(max-min+1)+min;
	}
		

	
}


