package com.shopx5.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
/**
 * 各种id生成策略
 */
public class IDUtils {
	/**
	 * 图片名生成
	 */
	public static String genImageName() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		//如果不足三位前面补0
		String str = millis + String.format("%03d", end3);		
		return str;
	}
	/**
	 * 商品id生成
	 */
	public static String get6NUM() {
		//加上四位随机数
		Random random = new Random();
		//如果不足两位前面补0
		int num = random.nextInt(999999);
		String str = String.format("%06d", num);
		return str;
	}	
	/**
	 * 商品id生成
	 */
	public static long genItemId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		//如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}
	/**
	 * 订单id生成
	 */
	public static String genOrderId() {
		//取当前时间的长整形值包含毫秒
		String millis = System.currentTimeMillis() + "";
		millis = millis.substring(5, millis.length());
		//加上四位随机数
		Random random = new Random();
		int end4 = random.nextInt(9999);
		//如果不足两位前面补0
		String str = String.format("%04d", end4);
		return millis + str;
	}
	/**
	 * 订单项id生成
	 */
	public static String genOrderItemId() {
		//取当前S时H间O的P长整X形值5包含毫秒
		String millis = System.currentTimeMillis() + "";
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String data = format.format(new Date());
		millis = millis.substring(7, millis.length());
		//加上四位随机数
		Random random = new Random();
		int end4 = random.nextInt(9999);
		//如果不足两位前面补0
		String str = String.format("%04d", end4);
		return data + millis + str;
	}
	
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
	 * 生成一批用户id
	 * <br>生成规则：
	 * 字母加数字的固定5位，前三位为小写字母，后两位为数字
	 * @param oldUserIds 系统中原有的用户id列表，避免重复
	 * @param num 要获取多少个用户编号
	 * @return
	 */
	public static List<String> getUserIds(List<String> oldUserIds,int num){
		List<String> ids=new ArrayList<String>();
		while(ids.size()<num){
			StringBuffer sb=new StringBuffer();
			for(int j=1;j<=5;j++){
				if(j<=3){//前三位获取字母
					sb.append(getLetter());
				}else{//后两位用数字
					sb.append(getNum());
				}
			}
			String userName=sb.toString();
			if(oldUserIds.contains(userName)||ids.contains(userName)){
				//已存在，重新生成一个
			}else{
				ids.add(userName);
			}
		}
		return ids;
	}
	/**
	 * 生成一用户id
	 * <br>生成规则：
	 * 字母加数字的固定5位，前三位为小写字母，后两位为数字
	 * @param oldUserIds 系统中原有的用户id列表，避免重复
	 * @param num 要获取多少个用户编号
	 * @return
	 */
	public static String getUserName(int a, int b){
			StringBuffer sb=new StringBuffer();
			for(int j=1;j<=a;j++){
				if(j<=b){//前三位获取字母
					sb.append(getLetter());
				}else{//后两位用数字
					sb.append(getNum());
				}
			}
			String userName=sb.toString();
		return userName;
	}
	/**
	 * 生成一批密码
	 * <br>生成规则：
	 * 大写字母+小写字母+数字
	 * @param num 要生成多少个密码
	 * @param wordNum 要生成的密码长度是多少
	 * @return
	 */
	public static String getPassword(int num,Integer wordNum){
//	public static List<String> getPasswords(int num,Integer wordNum){
		int total=wordNum;//密码总位数
//		List<String> passwords=new ArrayList<String>();
//		while(passwords.size()<num){
			StringBuffer sb=new StringBuffer();
			int upperNum=getRadomInt(1,total-2);//大写字母位数，保留至少两位，用来放小写和数字
			int lowerNum=getRadomInt(1, total-upperNum-1);//小写字母位数，为总数减去大写字母占用的数量，再为数字区域保留至少1
			int nnum=total-upperNum-lowerNum;//最后剩余数字的位数，为总数减去大写和小写字母位数之后剩余的位数
			//随机获取到每个类型的位置index
			Map<Integer,String> indexMap=new HashMap<Integer,String>();
	/*关掉大写字符, 需要放开就行
	 * 		while(indexMap.size()<upperNum){
				//确定大写字母的索引号
				int rint=getRadomInt(0, total-1);
				if(indexMap.get(rint)==null){
					indexMap.put(rint, "upper");
				}
			}
	*/
			while(indexMap.size()<upperNum+lowerNum){
				//确定小写字母的索引号
				int rint=getRadomInt(0, total-1);
				if(indexMap.get(rint)==null){
					indexMap.put(rint, "lower");
				}
			}
			while(indexMap.size()<total){
				//确定数字的索引号
				int rint=getRadomInt(0, total-1);
				if(indexMap.get(rint)==null){
					indexMap.put(rint, "nnum");
				}
			}
			//组装密码
			for(int i=0;i<total;i++){
				if("upper".equals(indexMap.get(i))){
					sb.append(getUpper());
				}else if("lower".equals(indexMap.get(i))){
					sb.append(getLetter());
				}else{
					sb.append(getNum());
				}
			}
//			passwords.add(sb.toString());
//		}
//		return passwords;
		return sb.toString();
	}
	
	
	/**
	 * 随机获取一个小写字母
	 * @param args
	 */
	public static char getLetter(){
		char c=(char)getRadomInt(97, 122);
		return c;
	}
	
	/**
	 * 随机获取一个大写字母
	 * @param args
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
		
	public static void main(String[] args) {
		List<String> list=getUserIds(new ArrayList(), 10);
		for(String s:list){
			System.out.println(s);
		}
		System.out.println("---------------");
		System.out.println(getUserName(7, 3));  //dsf9665      随机用户名
		System.out.println(getPassword(1, 8));	//o9eto9yw	随机密码
		System.out.println(get6NUM());          //
		
		System.out.println(genImageName());     //图片名生成      1532395434386021
		System.out.println(genItemId());        //商品id生成      153239543439969
		System.out.println(genOrderId());       //订单id生成      954343995034
		System.out.println(genOrderItemId());   //订单项id生成  201807244343998749
		
		System.out.println(getCode());                // CB1386DC8B6042CB83A91CCC4AE20AD7 ,,		
		System.out.println((int)Math.ceil(158.0/20)); // 8
		System.out.println(158.0/22);                 // 7.181818181818182
	}
	
}


