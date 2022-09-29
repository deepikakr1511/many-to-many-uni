package com.ty.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Course;
import com.ty.dto.Student;

public class InsertDriver {

	public static void main(String[] args) {
		Student s = new Student();
		s.setName("manu");
		s.setEmail("manu@gmail.com");

		Course c = new Course();
		c.setName("maths");
		c.setCost(2345);

		Course c1 = new Course();
		c1.setName("science");
		c1.setCost(3456);

		List<Course> course = new ArrayList();
		course.add(c);
		course.add(c1);

		s.setCourses(course);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(s);
		em.persist(c);
		em.persist(c1);
		et.commit();

	}

}
