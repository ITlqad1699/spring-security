package com.eazybytes.entity.generator;

import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: DaLQA
 * @Date: 2024-04-14 15:50
 */
public class ContactIdGenerator implements IdentifierGenerator {
	
	private static final int START_ID = 10000000;
	
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		
		String prefix = "SR";
		
		try {
			JdbcConnectionAccess jdbcConnectionAccess = session.getJdbcConnectionAccess();
			Connection connection = jdbcConnectionAccess.obtainConnection();
			Statement statement = connection.createStatement();
			String query = "select count(contact_id) as Id from eazybank.contact_messages";
			
			ResultSet resultSet = statement.executeQuery(query);
			
			if (resultSet.next()) {
				long id = START_ID + resultSet.getInt(1);
				return prefix + id;
			}
			
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
