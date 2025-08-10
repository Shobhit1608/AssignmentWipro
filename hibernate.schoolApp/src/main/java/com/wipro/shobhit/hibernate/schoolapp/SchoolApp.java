package com.wipro.shobhit.hibernate.schoolapp;

import com.wipro.shobhit.hibernate.schoolapp.entity.Gender;
import com.wipro.shobhit.hibernate.schoolapp.entity.SchoolUser;
import com.wipro.shobhit.hibernate.schoolapp.util.SchoolAppUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import java.time.LocalDate;

public class SchoolApp {

    public static void main(String[] args) {

        System.out.println("Starting SchoolApp...");

        try {
            // Initial creation and insertion
            Session session = SchoolAppUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            // Generate a unique username to avoid the ConstraintViolationException
            String uniqueUsername = "Rajesh" + System.currentTimeMillis();
            
            SchoolUser user = new SchoolUser();
            user.setFirstname("Rajesh");
            user.setLastname("Kumar");
            user.setUsername(uniqueUsername);
            user.setGender(Gender.MALE);
            user.setAddress("Delhi");
            user.setDob(LocalDate.of(2000, 8, 30));
            	
            session.persist(user);
            tx.commit();
            session.close();

            System.out.println("User inserted into Database: " + user);

            // Fetch the user from the database
            session = SchoolAppUtil.getSessionFactory().openSession();
            SchoolUser userData = session.get(SchoolUser.class, user.getRollno());
            System.out.println("User fetched from Database: " + userData);
            session.close();

            // Update the user
//            session = SchoolAppUtil.getSessionFactory().openSession();
//            tx = session.beginTransaction();
//            userData.setFirstname("Raj"); // Change the name
//            session.merge(userData); 
//            tx.commit();
//            session.close();
//            System.out.println("User updated: " + userData);
//            
//            // Delete the user
            session = SchoolAppUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.remove(session.merge(userData));
            tx.commit();
            session.close();

            System.out.println("User with rollno " + userData.getRollno() + " deleted successfully.");
            System.out.println("Fetching user to confirm deletion...");
            

        } catch (ConstraintViolationException e) {
            System.err.println("Error: A unique constraint was violated. This usually happens when trying to insert a user that already exists.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}