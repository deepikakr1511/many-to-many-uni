package com.ty.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Subject;
import com.ty.dto.Teacher;

public class InsertByFindDriver1 {

	public static void main(String[] args) {
		Teacher t=new Teacher();
		t.setName("john");
		t.setGender("male");
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vikas");
		EntityManager em=emf.createEntityManager();
		
		Subject s=em.find(Subject.class, 1);
		Subject s1=em.find(Subject.class, 2);
		
		List<Subject> l=new ArrayList();
		l.add(s);
		l.add(s1);
		
		t.setSub(l);
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(t);
		em.persist(s);
		em.persist(s1);
		et.commit(); 
		
		
		
		
		
	}

}
