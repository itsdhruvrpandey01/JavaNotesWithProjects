package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Question q1 = new Question();
        q1.setQuestionId(1);
        q1.setQuestion("what is java ? ");
        
        Answer answer = new Answer();
        answer.setAnswerId(101);
        answer.setAnswer("Java is a programming language");
        q1.setAnswer(answer);
//        session
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        
//        save 
        s.save(q1);
        s.save(answer);
        
        tx.commit();
        s.close();
        factory.close();
	}

}
