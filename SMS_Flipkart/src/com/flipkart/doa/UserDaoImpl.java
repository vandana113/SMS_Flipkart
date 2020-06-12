package com.flipkart.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.flipkart.exception.LoginFailException;
import com.flipkart.utils.DBUtil;
import com.sms.constant.SQLConstantQueries;

public class UserDaoImpl implements UserDao {

	Connection conn = DBUtil.getConnection();
	private static Logger logger = Logger.getLogger(UserDaoImpl.class);

	@Override
	public boolean validateLogin(String username, String password) throws LoginFailException {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(SQLConstantQueries.GET_PASSWORD);
			stmt.setString(1, username);
			logger.debug(stmt);
			ResultSet rs = stmt.executeQuery();
//			int rows = rs.getFetchSize();
//			if (rows == 0)
//				throw new LoginFailException();
			System.out.println("User Found");
			while (rs.next()) {
				// Retrieve by column name
				if (password.equals(rs.getString("password"))) {
					System.out.println("Correct username and password");
					return true;
				}
				else
					throw new LoginFailException();
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return false;
	}

}
