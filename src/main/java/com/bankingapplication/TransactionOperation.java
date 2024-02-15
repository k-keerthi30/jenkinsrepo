package com.bankingapplication;

import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TransactionOperation {

	
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	Scanner sc = new Scanner(System.in);
 void multipleTransactionOpeartion(String userEmail) {
		
		
		do {
			System.out.println("Doing some operations on the bank application");
			System.out.println("Enter 1 to deposit the money into self-account ");
			System.out.println("Enter 2 to with draw money from self-account ");
			System.out.println("Enter 3 to transfer money from one user to other user ");
			Integer choiceOfOperation = sc.nextInt();
			switch(choiceOfOperation) {
			case 1:
				System.out.println("please enter the deposit amount");
	    		  double depositAmount = sc.nextDouble();
	    		  sc.nextLine();
	    		depositAmount(userEmail, depositAmount);
	    		break;
			case 2:
				System.out.println("please enter the amount to with draw");
	    		  double withDrawAmount = sc.nextDouble();
	    		  sc.nextLine();
	    		withDrawAmount(userEmail, withDrawAmount);
	    		break;
			case 3:
				System.out.println("Please enter the date");
				String transferDate = sc.next();
				 System.out.println("Please enter the recipient's phone number");
                 Integer recipientPhone = sc.nextInt();
                 System.out.println("Please enter the transfer amount");
                 double transferAmount = sc.nextDouble();
                 sc.nextLine();
                 System.out.println("Please enter the transaction category");
                 String tranferCategory = sc.next();
                 System.out.println("Please enter the transaction between");
                 String transferBetween = sc.next();
                
                 TransactionDeatils transactionDetails = new TransactionDeatils(transferDate,
                		 recipientPhone, transferAmount,tranferCategory ,transferBetween);
                 transferAmount(transactionDetails, userEmail);
                 break;
			}
			System.out.println("enter yes to run the operations");
		} while (sc.next().equalsIgnoreCase("yes"));
	}
	
 
 
 
 
	void depositAmount(String userEmail, double userBalance) {
		String qry = "update userdetails set userbalance=userbalance+? where useremail=?";
		jdbcTemplate.update(qry,new Object[] {userBalance,userEmail});
		System.out.println("Deposit successfull");
	}
	
	void withDrawAmount(String userEmail, double userBalance) {
		String qry = "update userdetails set userbalance=userbalance-? where useremail=?";
		jdbcTemplate.update(qry,new Object[] {userBalance,userEmail});
		System.out.println("With Draw successfull");
	}
	
	void transferAmount(TransactionDeatils transactionDetails, String userEmail) {
        // Check if the recipient's phone number exists
        String recipientEmail = getUserEmailByPhone(transactionDetails.getRecipentPhoneNumber());
        if (recipientEmail == null) {
            System.out.println("Recipient with the given phone number not found");
            return;
        }

        // Perform the transfer
        withDrawAmount(userEmail, transactionDetails.getTransactionAmount());
        depositAmount(recipientEmail, transactionDetails.getTransactionAmount());

        // Record the transaction details
        String qry = "INSERT INTO transactiondetails (transactiondate, recipentphone, transactionamount, transactioncategory, transactionbetween) VALUES (?, ?, ?, ?, ?)";

        try {
            jdbcTemplate.update(qry, transactionDetails.getTransactionDate(), transactionDetails.getRecipentPhoneNumber(),
                    transactionDetails.getTransactionAmount(), transactionDetails.getTransactionCategory(), userEmail);
            System.out.println("Transfer successful");
        } catch (Exception e) {
            System.err.println("Error during transfer: " + e.getMessage());
        }
    }

  

    String getUserEmailByPhone(Integer userPhone) {
        String qry = "select useremail from userdetails where userphonenumber=?";
        try {
            return jdbcTemplate.queryForObject(qry, String.class, userPhone);
        } catch (Exception e) {
            return null;
        }
    }
}

