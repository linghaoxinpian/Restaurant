package factory;

import java.util.ResourceBundle;

/**
 * 创建Dao层和Service层对象
 * @author linghaoxinpian
 *
 */
public class BeanFactory {
//	private static BeanFactory instance;
//	private BeanFactory(){}
//	public static BeanFactory getInstance(){
//		if(instance==null){
//			synchronized (BeanFactory.class) {
//				if(instance==null){
//					instance=new BeanFactory();
//				}
//			}
//		}
//		return instance;
//	}
//	
	
	//加载配置文件
	private static ResourceBundle bundle;
	static{
		bundle=ResourceBundle.getBundle("instance");
	}
	
	/**
	 * 根据指定的key，读取配置文件获取类的全路径； 创建对象
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getInstance(Class<T> clazz){		
		String className=bundle.getString(clazz.getSimpleName().substring(1));
		try {			
			return (T)Class.forName(className).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
