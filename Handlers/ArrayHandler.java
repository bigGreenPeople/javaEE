// 取出第一行的所有记录存入一个Object数组
public class ArrayHandler implements ResultSetHandler {

	public Object handle(ResultSet rs) {
		try {
			if (rs.next()) {
				// 指向了第一行的记录
				// 获得元数据
				ResultSetMetaData metaData = rs.getMetaData();
				// 获得列数
				int count = metaData.getColumnCount();
				// 创建数组
				Object[] arr = new Object[count];
				// 迭代所有列的值，存入数组
				for(int i=1; i<=count; i++) {
					Object value = rs.getObject(i);	// 获得指定列的值
					arr[i-1] = value;
				}
				return arr;
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
