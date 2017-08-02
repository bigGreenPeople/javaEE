package com.fj.CommonUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;

import com.fj.domain.User;

public class CommonUtils {
	
	//返回一个不重复的32位uuid值
	public static String uuid(){
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}
	
	/** 
     *  
     * @param bean   
     * @param map 
     * @return map --> bean: 将Map转换为Bean 
     * @throws Exception  
     * 此方法用于把表单的map封装成我们的对象
     * 但是有时我们的表单可能会有一些不是对象属性的值，这个时候就会抛出异常
     * 而少了属性不会影响我们封装
     * 所有我们在这里应该把原来map表单的对象属性拿出来
     * 创建成一个新的map
     */  
    public static <T ,K, V> T toBean(Class<T> bean, Map<String, V> map) throws Exception {        
    	//创建一个新的map这个map 存放bean的属性
    	Map<String, V> beanMap = new HashMap<String, V>();
    	
    	//创建一个bean对象
        T t = bean.newInstance();
        //得到所有的属性
        Field[] fields = bean.getDeclaredFields();
        
        //得到map的所有key
        Set<String> set = map.keySet();
        
        //循环迭代出我们所有方法的名字
        for(Field f:fields){
        	//得到属性的名称
        	String name = f.getName();
        	//如果map中有我们需要的属性就把它保存在新的map中
        	if(set.contains(name)){
        		//放到我们新的map中去
        		beanMap.put(name, map.get(name));
        	}
        }
        BeanUtils.populate(t, beanMap);  
        return t;  
       
    }  
/*	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", "fujie");
		map.put("password", "fujie123");
		map.put("passworsd", "fujie123");
		
		try {
			User user = toBean(User.class, map);
			System.out.println("username:"+user.getUsername()+"\npassword:"+user.getPassword());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
}
