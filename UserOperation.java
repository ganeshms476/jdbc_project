package jdbc_prc_userdb1;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;


import com.mysql.cj.jdbc.Driver;

public class UserOperation {
	public Connection getConnection() throws Exception {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		FileInputStream fileInputStream = new FileInputStream("db_config.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("username"), properties.getProperty("password"));
		return connection;
	}

	public void signUpUser(User user) throws Exception {
		// 2 steps over
		Connection connection = getConnection();
		// 3 step query
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT into USER(id,username,email,password,address) values(?,?,?,?,?)");
		preparedStatement.setInt(1, user.getId());
		preparedStatement.setString(2, user.getUsername());
		preparedStatement.setString(3, user.getEmail());
		preparedStatement.setString(4, user.getPassword());
		preparedStatement.setString(5, user.getAddress());

		// 4.execute query
		preparedStatement.execute();

		// 5.close connection
		connection.close();

		System.out.println("Signed up successfully");
	}

	public boolean loginUser(User user) throws Exception {
		// 2 steps over
		Connection connection = getConnection();

		// 3rd step
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from USER where email=?");
		String password = null;
		String email = null;
		preparedStatement.setString(1, user.getEmail());
		// 4th step

		ResultSet resultSet = preparedStatement.executeQuery();
		try {
			while (resultSet.next()) {
				password = resultSet.getString("password");
			}
			if (password.equals(user.getPassword())) {
				// password = user.getPassword();
				return true;
			}
		} catch (Exception e) {
			System.out.println("Invalid email");
			System.out.println();
		}
		return false;
	}

	public void insertPasswordUser(User user) throws Exception {
		// 2steps over
		Connection connection = getConnection();

		// 3rd step
		String email=null;
		PreparedStatement preparedStatement = connection.prepareStatement("Select email from user where id = ?");
		preparedStatement.setInt(1,user.getId());
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next()){
			email = resultSet.getString("email");
			System.out.println(email);
		}
		if(email.equals(user.getEmail())){
			preparedStatement = connection.prepareStatement(
					"UPDATE  USER set fbpassword=?,instapassword=?,snappassword=?,whatsapppassword=?,twitterpassword=? where id=?");
			
			preparedStatement.setString(1, user.getFbpassword());
			preparedStatement.setString(2, user.getInstapassword());
			preparedStatement.setString(3, user.getSnappassword());
			preparedStatement.setString(4, user.getWhatsapppassword());
			preparedStatement.setString(5, user.getTwitterpassword());
			preparedStatement.setInt(6, user.getId());

			// 4th step
			preparedStatement.execute();
		}
		else {
			System.out.println("Already id is present ");
		}

		// 5th step
		connection.close();
	}

	public void updateUser(User user, int choice2, String password1) throws Exception {
		Connection connection = getConnection();
		switch (choice2) {
		case 1: {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from USER where id= ?");
			preparedStatement.setInt(1, user.getId());
			String password2 = null;
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				password2 = resultSet.getString(6);
			}
			if (password1.equals(password2)) {
				preparedStatement = connection.prepareStatement("UPDATE USER set fbpassword = ? where id=?");
				preparedStatement.setString(1, user.getFbpassword());
				preparedStatement.setInt(2, user.getId());
				preparedStatement.execute();
				connection.close();
				System.out.println("Succesfully updated");
			} else {
				System.out.println("Incorrect password");
			}

		}
			break;
		case 2: {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from USER where id= ?");
			preparedStatement.setInt(1, user.getId());
			String password2 = null;
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				password2 = resultSet.getString(7);
			}
			if (password1.equals(password2)) {
				preparedStatement = connection.prepareStatement("UPDATE USER set instapassword = ? where id=?");
				preparedStatement.setString(1, user.getInstapassword());
				preparedStatement.setInt(2, user.getId());
				preparedStatement.execute();
				connection.close();
				System.out.println("Succesfully updated");
			} else {
				System.out.println("Invalid password");
			}
		}
			break;
		case 3: {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from USER where id= ?");
			preparedStatement.setInt(1, user.getId());
			String password2 = null;
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				password2 = resultSet.getString(8);
			}

			if (password1.equals(password2)) {
				preparedStatement = connection.prepareStatement("UPDATE USER set snappassword = ? where id=?");
				preparedStatement.setString(1, user.getSnappassword());
				preparedStatement.setInt(2, user.getId());
				preparedStatement.execute();
				connection.close();
				System.out.println("Succesfully updated");
			} else {
				System.out.println("Invalid password");
			}
		}
			break;
		case 4: {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from USER where id= ?");
			preparedStatement.setInt(1, user.getId());
			String password2 = null;
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				password2 = resultSet.getString(9);
			}
			if (password1.equals(password2)) {
				preparedStatement = connection.prepareStatement("UPDATE USER set whatsapppassword = ? where id=?");
				preparedStatement.setString(1, user.getWhatsapppassword());
				preparedStatement.setInt(2, user.getId());
				preparedStatement.execute();
				connection.close();
				System.out.println("Succesfully updated");
			} else {
				System.out.println("Invalid password");
			}
		}
			break;
		case 5: {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from USER where id= ?");
			preparedStatement.setInt(1, user.getId());
			String password2 = null;
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				password2 = resultSet.getString(10);
			}
			if (password1.equals(password2)) {
				preparedStatement = connection.prepareStatement("UPDATE USER set twitterpassword = ? where id=?");
				preparedStatement.setString(1, user.getTwitterpassword());
				preparedStatement.setInt(2, user.getId());
				preparedStatement.execute();
				connection.close();
				System.out.println("Succesfully updated");
			} else {
				System.out.println("Invalid password");
			}
		}
		}

		System.out.println("Updated succesfully");
	}

	public void displayUser(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(
				"SELECT fbpassword,instapassword,snappassword,whatsapppassword,twitterpassword from USER WHERE id = ? ");
		preparedStatement.setInt(1, user.getId());
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println(resultSet.getString("fbpassword"));
			System.out.println(resultSet.getString("instapassword"));
			System.out.println(resultSet.getString("snappassword"));
			System.out.println(resultSet.getString("whatsapppassword"));
			System.out.println(resultSet.getString("twitterpassword"));
		}
	}
}
