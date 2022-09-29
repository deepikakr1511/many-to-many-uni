package com.ty.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Course;
import com.ty.dto.Student;

public class InsertByFindDriver {

	public static void main(String[] args) {
		Student s1=new Student ();
		s1.setName("deepu");
		s1.setEmail("deepu@gmail.com");
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vikas");
		EntityManager em=emf.createEntityManager();
		Course c=em.find(Course.class, 1);
		Course c1=em.find(Course.class, 2);
		List<Course> courses=new ArrayList();
		courses.add(c);
		courses.add(c1);
		s1.setCourses(courses);
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(s1);
		em.persist(c);
		em.persist(c1);
		et.commit();
		
	}

}
