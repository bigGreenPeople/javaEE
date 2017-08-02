package com.fj.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.fj.JDBCUtils.JdbcUtils;

/**
 * 此类用于解决连接释放的问题
 * 在这里统一的处理就可以不用在DAO层写了
 * @author BigGreenPeople
 * 
 *
 */
public class TxQueryRunner extends QueryRunner {

	@Override
	public int[] batch(String sql, Object[][] params) throws SQLException {
		// TODO Auto-generated method stub
		Connection ct = JdbcUtils.getConnection();
		int[] result = super.batch(sql, params);
		JdbcUtils.releaseConnection(ct);
		return result;
	}

	@Override
	public int execute(String sql, Object... params) throws SQLException {
		// TODO Auto-generated method stub
		Connection ct = JdbcUtils.getConnection();
		int result = super.execute(sql, params);
		JdbcUtils.releaseConnection(ct);
		return result;
	}

	@Override
	public <T> List<T> execute(String sql, ResultSetHandler<T> rsh,
			Object... params) throws SQLException {
		// TODO Auto-generated method stub
		Connection ct = JdbcUtils.getConnection();
		List<T> result = super.execute(sql, rsh, params);
		JdbcUtils.releaseConnection(ct);
		return result;
	}

	@Override
	public <T> T insert(String sql, ResultSetHandler<T> rsh, Object... params)
			throws SQLException {
		// TODO Auto-generated method stub
		Connection ct = JdbcUtils.getConnection();
		T result = super.insert(sql, rsh, params);
		JdbcUtils.releaseConnection(ct);
		return result;
	}

	@Override
	public <T> T insert(String sql, ResultSetHandler<T> rsh)
			throws SQLException {
		// TODO Auto-generated method stub
		Connection ct = JdbcUtils.getConnection();
		T result = super.insert(sql, rsh);
		JdbcUtils.releaseConnection(ct);
		return result;
	}

	@Override
	public <T> T insertBatch(String sql, ResultSetHandler<T> rsh,
			Object[][] params) throws SQLException {
		// TODO Auto-generated method stub
		Connection ct = JdbcUtils.getConnection();
		T result = super.insertBatch(sql, rsh, params);
		JdbcUtils.releaseConnection(ct);
		return result;
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params)
			throws SQLException {
		// TODO Auto-generated method stub
		Connection ct = JdbcUtils.getConnection();
		T result = super.query(sql, rsh, params);
		JdbcUtils.releaseConnection(ct);
		return result;
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
		// TODO Auto-generated method stub
		Connection ct = JdbcUtils.getConnection();
		T result = super.query(sql, rsh);
		JdbcUtils.releaseConnection(ct);
		return result;
	}

	@Override
	public int update(String sql, Object... params) throws SQLException {
		// TODO Auto-generated method stub
		Connection ct = JdbcUtils.getConnection();
		int result = super.update(sql, params);
		JdbcUtils.releaseConnection(ct);
		return result;
	}

	@Override
	public int update(String sql, Object param) throws SQLException {
		// TODO Auto-generated method stub
		Connection ct = JdbcUtils.getConnection();
		int result = super.update(sql, param);
		JdbcUtils.releaseConnection(ct);
		return result;
	}

	@Override
	public int update(String sql) throws SQLException {
		// TODO Auto-generated method stub
		Connection ct = JdbcUtils.getConnection();
		int result = super.update(sql);
		JdbcUtils.releaseConnection(ct);
		return result;
	}
	
}
