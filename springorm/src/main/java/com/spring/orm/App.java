package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;


public class App 
{
    public static void main( String[] args )
    {
        
    	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    	StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
    	
//    	Student s1 = new Student();
//    	s1.setStudentId(1);
//    	s1.setStudentName("Bishnu");
//    	s1.setStudentCity("Balasore");
//    	
//    	int result = studentDao.insert(s1);
//    	System.out.println("Data inserted "+ result);
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    	boolean go =true;
    	while(go) {
    		System.out.println("PRESS 1 for add new student.");
        	System.out.println("PRESS 2 for display all students.");
        	System.out.println("PRESS 3 for get detail of single student.");
        	System.out.println("PRESS 4 for delete students.");
        	System.out.println("PRESS 5 for update student.");
        	System.out.println("PRESS 6 for exit.");
        	
        	try {
        		
        		int input = Integer.parseInt(br.readLine());
        		
        		switch(input) {
        		
        		case 1: 
        			
        			// add a new student
        			
        			System.out.println("Enter user id:");
        			int uid = Integer.parseInt(br.readLine());
        			
        			System.out.println("Enter your name : ");
        			String uName = br.readLine();
        			
        			System.out.println("Enter your name : ");
        			String uCity = br.readLine();
        			
        			// creating student object and setting values
        			Student s = new Student();
        			s.setStudentId(uid);
        			s.setStudentName(uName);
        			s.setStudentCity(uCity);
        			
        			// saving student
        			int r= studentDao.insert(s);
        			
        			System.out.println(r+ "Student added ");
        			System.out.println("********************************************************");
        			System.out.println();
        			
        			
        			break;
        			
        		case 2:
        			
        			// display all student
        			
        			List<Student> allstudents = studentDao.getAllStudents();
        			
        			for(Student st:allstudents) {
        				System.out.println(st.getStudentId()+" "+st.getStudentName()+" "+st.getStudentCity());
        				System.out.println("******************************************************");
        			}
        			
        			break;
        			
        		case 3:
        			
        			// get single student data
        			
        			System.out.println("Enter user id:");
        			int userid = Integer.parseInt(br.readLine());
        			
        			Student onestudent = studentDao.getStudent(userid);
        			
        			System.out.println(onestudent.getStudentId()+" "+onestudent.getStudentName()+" "+onestudent.getStudentCity());
    				System.out.println("******************************************************");
        			
        			break;
        			
        		case 4:
        			
        			// delete student data
        			
        			System.out.println("Enter user id:");
        			int deleteid = Integer.parseInt(br.readLine());
        			
        			studentDao.deleteStudent(deleteid);
        			
        			System.out.println(deleteid+" ");
        			break;
        		case 5:
        			
        			// update student
        			
        			System.out.println("Enter user id:");
        			int updateid = Integer.parseInt(br.readLine());
        			
        			System.out.println("Enter your name : ");
        			String updateName = br.readLine();
        			
        			System.out.println("Enter your name : ");
        			String updateCity = br.readLine();
        			
        			// creating student object and setting values
        			Student updates = new Student();
        			updates.setStudentId(updateid);
        			updates.setStudentName(updateName);
        			updates.setStudentCity(updateCity);
        			
        			// saving student
        			studentDao.updateStudent(updates);
        			
        			System.out.println("Student updated succefully ");
        			System.out.println("********************************************************");
        			System.out.println();
        			
        			
        			
        			break;
        		case 6:
        			go = false;
        			break;
        		}
        		
        	}catch(Exception e) {
        		
        		System.out.println("Invalid Input try with another one");
        		System.out.println(e.getLocalizedMessage());
        		
        	}
    	}
    	
    	
    	System.out.println("Thank you for using my application :)");
    	System.out.println("See you soon !!");
    	
    	
    	
    }
}
