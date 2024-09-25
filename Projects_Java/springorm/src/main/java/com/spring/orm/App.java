package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.entities.Student;
import com.spring.orm.dao.StudentDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Started......!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
		/*
		 * Student student = new Student(2324,"Dhruv Pandey","lucknow"); 
		 * int i = studentDao.insert(student);
		 * System.out.println();
		 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean go = true;
        while(go) {
        	System.out.println("PRESS 1 for add new student");
        	System.out.println("PRESS 2 for display all students");
        	System.out.println("PRESS 3 for get detail of single student");
        	System.out.println("PRESS 4 for delete students");
        	System.out.println("PRESS 5 for update student");
        	System.out.println("PRESS 6 for exit");
        	
        	try {
        	int input = Integer.parseInt(br.readLine());
        	switch (input) {
			case 1:
				//add new student 
				// taking inputs 
				System.out.println("Enter user id: "); 
				int uId = Integer.parseInt(br.readLine());
				System.out.println("Enter user name:");
				String uName = br.readLine();
				System.out.println("Enter user city: ");
				String uCity = br.readLine();
				// creating student object and setting objects
				Student s=new Student();
				s.setStudentId(uId);
				s.setStudentName (uName);
				s.setStudentCity(uCity); 
				
				// saving student object to database by calling insert of studentDao
				int r = studentDao.insert(s);
				System.out.println(r);
				System.out.println(r+" student added");
				System.out.println("******************************************");
				System.out.println();
				break;
			case 2:
				//display all the student
				System.out.println("******************************************");
				List<Student> allStudents=studentDao.getAllStudents();
				for(Student st: allStudents) {
					System.out.println("Id: "+st.getStudentId());
					System.out.println("Name: "+st.getStudentName());
					System.out.println("City: "+st.getStudentCity());
					System.out.println("________________________________________________");
				}
				break;
			case 3:
				// get single students data 
				System.out.println("Enter user id: ");
				int userId = Integer.parseInt(br.readLine());
				Student st = studentDao.getStudent(userId);
				System.out.println("Id: "+st.getStudentId());
				System.out.println("Name: "+st.getStudentName());
				System.out.println("City: "+st.getStudentCity());
				System.out.println("________________________________________________");
				break;
			case 4:
				// delete student
				
				System.out.println("Enter user id; ");
				int id = Integer.parseInt(br.readLine());
				studentDao.deleteStudent(id);
				System.out.println("Student deleted...");
				break;
			case 5:
				// update the student
				System.out.println("Enter user id: "); 
				int sId = Integer.parseInt(br.readLine());
				System.out.println("Enter user name:");
				String sName = br.readLine();
				System.out.println("Enter user city: ");
				String sCity = br.readLine();
				// creating student object and setting objects
				Student stud=new Student();
				stud.setStudentId(sId);
				stud.setStudentName (sName);
				stud.setStudentCity(sCity); 
				studentDao.updateStudent(stud);
				System.out.println("student details updated..");
				break;
			case 6:
				// exit
				go=false;
				break;
			}
        	}catch (Exception e) {
				System.out.println("invalid input try again");
				e.printStackTrace();
			}
        }
    }
}
