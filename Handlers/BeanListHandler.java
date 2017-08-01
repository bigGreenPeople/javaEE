	public class BeanListHandler implements ResultSetHandler {

	private Class clazz;
	public BeanListHandler(Class clazz) {
		this.clazz = clazz;
	}
	public Object handle(ResultSet rs) {
		try {
			// 取出结果集所有的记录，封装到bean，存入list返回
			List list = new ArrayList();
			while (rs.next()) {
				Object bean = clazz.newInstance();
				// 获得元数据
				ResultSetMetaData metaData = rs.getMetaData();
				// 获得列的数量
				int count = metaData.getColumnCount();
				// 遍历列
				for(int i=1; i<=count; i++) {
					// 取列名
					String columnName = metaData.getColumnName(i);
					// 取这列的值
					Object value = rs.getObject(columnName);
					// 反射出属性
					Field field = clazz.getDeclaredField(columnName);
					// 设置属性
					field.setAccessible(true);
					field.set(bean, value);
				}
				// 加入list
				list.add(bean);
			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
