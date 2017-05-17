package dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


public class BaseDao<T> {
	/**
	 * T的简单字节码
	 */
	private String T_name;
	
	{
		//获取T
		 Type type=this.getClass().getGenericSuperclass();	//type:BaseDao<Food>
		 ParameterizedType parameterizedType=(ParameterizedType) type;
		 Type[] types = parameterizedType.getActualTypeArguments();	//数组里是泛型的实际类型
		 Class<?> clazz=(Class<?>) types[0];
		 T_name=clazz.getSimpleName();
	}
	public void findById(int id){
		System.out.println(T_name);
		
	}
}
