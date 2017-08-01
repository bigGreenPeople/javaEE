public class BeanHandler implements ResultSetHandler {
	private Class clazz;
	public BeanHandler(Class clazz) {
		this.clazz = clazz;
	}
	public Object handle(ResultSet rs) {
		// 不知道有几列数据，不知道列名，不知道封装到什么样的bean
		// 表的列明和javabean的字段名一致
		try {
			if(rs.next()) {
				// 创建bean
				Object bean = clazz.newInstance();
				// 封装数据
				// 获得结果集的元数据
				ResultSetMetaData metaData = rs.getMetaData();
				int count = metaData.getColumnCount();
				// 迭代取每一列的数据
				for(int i=1; i<=count; i++) {
					// 获得列名  username
					String columnName = metaData.getColumnName(i);
					// 获得数据 ddd
					Object value = rs.getObject(columnName);
					// 根据列名反射出映射的属性 username
					Field field = clazz.getDeclaredField(columnName);
					// 为属性赋值
					field.setAccessible(true);
					field.set(bean, value);
				}
				return bean;
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
