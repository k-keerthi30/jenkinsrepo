package com.bankingapplication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class BankingOperations {

	DataSource dataSource;
	JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	int signUp(UserDetails userDetails) {
	    String qry = "INSERT INTO userdetails (username, useremail, userpassword, userphonenumber, userbalance) VALUES (?, ?, ?, ?, ?)";
	    
	    if (this.duplicateEmailChecking(userDetails.getUserEmail())) {
	        return 0;  // Return 0 to indicate that the user is not signed up
	    } else {
	        return jdbcTemplate.update(qry,
	            userDetails.getUserName(),
	            userDetails.getUserEmail(),
	            userDetails.getUserPassword(),
	            userDetails.getUserPhoneNumber(),
	            userDetails.getUserBalance()
	        );
	    }
	}


	boolean duplicateEmailChecking(String email) {
	    try {
	        String qry = "select useremail from userdetails whe dre useremail=?";
	        String existingEmail = jdbcTemplate.queryForObject(qry, String.class, new Object[]{email});
	        return existingEmail.equalsIgnoreCase(email);
	    } catch (EmptyResultDataAccessException e) {
	       //System.out.println(e.getMessage());
	        return false;
	    }
	}


	boolean signIn(String signInEmail, String signInPassword) {
		String qry = "select userpassword from userdetails where useremail=?";
		
		try{String returnedPasswordFromUserdetails = jdbcTemplate.queryForObject(qry, String.class,
				new Object[] { signInEmail });
		if (returnedPasswordFromUserdetails.equalsIgnoreCase(signInPassword))
			return true; // correct email
		else
			return false;// incorrect password
		}catch(EmptyResultDataAccessException e) {
			return false; // to enter valid details
			
		}
	}
	
//	void depositAmount(String userEmail, double userBalance) {
//		String qry = "update userdetails set balance=balance+? where useremail=?";
//		jdbcTemplate.update(qry,new Object[] {userBalance,userEmail});
//		System.out.println("Deposit successfull");
//	}
//	
//	
//	void withdrawAmount(Integer userId, double userBalance) {
//		String qry ="update userdetails set balance=balance-? where userid=?";
//		jdbcTemplate.update(qry,new Object[] {userBalance, userId});
//		System.err.println("withdraw successfull");
//	}
//
//	double transactionAmount(TransactionDeatils transactionDetails) {
//		String qry = "insert into `transactiondetails` (`transactiondate`, `transactionamount`, `transactioncategory`,`userid`,`userparties`) values(?,?,?,?,?)";
//		depoistMoney(transactionDetails.getUserParties(), transactionDetails.getTransactionAmount());
//		withdrawAmount(transactionDetails.getUserId(), transactionDetails.getTransactionAmount());
//		return jdbcTemplate.update(qry, transactionDetails.getTransactionDate(), transactionDetails.getTransactionAmount(),
//				               transactionDetails.getTransactionCategory(), transactionDetails.getUserId(), transactionDetails.getUserParties());
//		
//	}
//	
// void checkBalance(Integer userId) {
//	 String qry = "select balance from userdetails where userId=?";
//double totalBalance=jdbcTemplate.queryForObject(qry,double.class, new Object[] {userId});
//	 System.out.println("The total amount of user"+totalBalance );
// }
 
// class allTransactionMapper implements RowMapper<TransactionDeatils>{
//
//	@Override
//	public TransactionDeatils mapRow(ResultSet rs, int rowNum) throws SQLException {
//		// TODO Auto-generated method stub
//		return new TransactionDeatils(rs.getString("transactionDate"), 
//				rs.getDouble("transactionAmount"),
//				rs.getString("transactionCategory"), rs.getInt("userId"),
//				rs.getInt("userParties"));
//	}
//	 
// }
// 
// List<TransactionDeatils> allTransactionDetails(){
//	 String qry =
//	return null;
//	 
// }
}
