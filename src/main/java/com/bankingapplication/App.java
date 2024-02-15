package com.bankingapplication;

import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main( String[] args )
    {
       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
       BankingOperations bankingOperation = context.getBean("bankingOperations", BankingOperations.class);
     TransactionOperation transactionOperation = context.getBean("transactionOperation", TransactionOperation.class);
    
      
       Scanner sc = new Scanner(System.in);
      
       Integer choice;
       
       do {
    	   System.out.println("please enter 1 for signup");
    	   System.out.println("please enter 2 for signin");
    	   System.out.println("please enter 3 for signout");
    	   System.out.println("please enter 1-3choice");
    	  choice = sc.nextInt();
    	  switch(choice) {
    	  case 1:
    		  System.out.println("signup");
    		  System.out.println("please enter the user Details");
    		  System.out.println("please enter name, email, password, phone number,balance");
    		  String signupName = sc.next();
   		   String signupEmail = sc.next();
   		   String signupPassword = sc.next();
   		   Integer userPhoneNumber = sc.nextInt();
   		   sc.nextLine();
   		  double currentBalance = sc.nextDouble();
   		  sc.nextLine();
   		if(bankingOperation.signUp(new UserDetails(signupName, signupEmail, signupPassword,userPhoneNumber, currentBalance))==1)
   			   System.out.println("User added successfully");
   		else
   			System.out.println("User already registered");
   		break;
    	  case 2:
    		  System.out.println("you are signing-in");
    		  System.out.println("please enter email and password to sign-in");
    		  String signInEmail=sc.next();
    		  String signInPassword=sc.next();
    		  if(bankingOperation.signIn(signInEmail,signInPassword)) {
    			  System.out.println("you are logged in successfully");
    			  transactionOperation.multipleTransactionOpeartion(signInEmail);
    			  
    		  }else {
    			  System.out.println("please enter valid details");
    		  }
    		  break;
    	  case 3:
    		  System.out.println("you are going to signout from the application");
    		  break;
  
//    	  case 4:
//    		  System.out.println("please enter the userid and deposit amount");
//    		  Integer userId=sc.nextInt();
//    		  sc.nextLine();
//    		  double depositAmount = sc.nextDouble();
//    		  sc.nextLine();
//    		 bankingOperation.depoistMoney(userId, depositAmount);
//    		 break;
//    	  case 5:
//    		  System.out.println("please enter user id and amount to with draw");
//    		  Integer userIdToWithDraw = sc.nextInt();
//    		  sc.nextLine();
//    		  double withDrawAmount = sc.nextDouble();
//    		  sc.nextLine();
//    		  bankingOperation.withdrawAmount(userIdToWithDraw,withDrawAmount );
//    	  case 6:
//    		  System.out.println("To deposit amount please enter transactiondate,transactionamount,transactioncategor ");
//    		  String transactionDate = sc.next();
//    		  int transactionAmount = sc.nextInt();
//    		  sc.nextLine();
//    		  String transactionCategory = sc.next();
//    		  Integer userTransactionId = sc.nextInt();
//    		  sc.nextLine();
//    		  Integer userTransactionParties = sc.nextInt();
//    		  bankingOperation.transactionAmount(new TransactionDeatils(transactionDate,
//    				  transactionAmount,transactionCategory,userTransactionId,userTransactionParties));
//    		  break;
//    	  case 7:
//    		  System.out.println("To know total balance please enter user id");
//    		  Integer userIdForTotalBalance = sc.nextInt();
//    		  sc.nextLine();
//    		  bankingOperation.checkBalance(userIdForTotalBalance);
    	  }
    	  
			System.out.println("enter true");
       }while(sc.nextBoolean()==true);
    }
}
