package com.ty.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Subject;
import com.ty.dto.Teacher;

public class InsertDriver1 {

	public static void main(String[] args) {
		Teacher t=new Teacher();
		t.setName("adam");
		t.setGender("male");
		Subject s=new Subject();
		s.setName("java");
		s.setDuration(30);
		
		Subject s1=new Subject();
		s1.setName("python");
		s1.setDuration(25);
		
		List<Subject> sub=new ArrayList();
		sub.add(s);
		sub.add(s1);
		
		t.setSub(sub);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vikas");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(t);
		em.persist(s);
		em.persist(s1);
		et.commit();
	}

}
