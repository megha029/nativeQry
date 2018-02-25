package com.scp.nativequery;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;



public class NativeQ {

	
	@SuppressWarnings({ "unused", "unchecked", "deprecation" })
	public static void main(String[] args) {
		Student s1 = new Student(101,"Megha");
		Student s2 = new Student(102,"Saru");
		Student s3 = new Student(103,"nav");
		
		
		SessionFactory sFactory = HibernateUtils.getSessionFactory();
		Session session = sFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(s1);
		session.save(s2);
		session.save(s3);
		
		session.flush();
		tr.commit();
		
	/*	Query sqlQueryGetStudById = session.getNamedQuery("sqlfindStudWithGivenId");
		sqlQueryGetStudById.setInteger("sid",102);
		List<Student> listOfObjectsSQLID  = sqlQueryGetStudById.list();
		System.out.println("SQL By ID -- "+listOfObjectsSQLID);
		
		Query sqlQueryGetStudByName = session.getNamedQuery("sqlfindStudWithGivenName");
		sqlQueryGetStudByName.setString("sname","niki");
		List<Student> listOfObjectsSQLName  = sqlQueryGetStudByName.list();
		System.out.println("SQL By Name -- "+listOfObjectsSQLName);*/

		/*Query hqlQueryGetStudById  = session.getNamedQuery("hqlfindStudkWithGivenId");
		hqlQueryGetStudById.setInteger("sid",102);
		List<Student> listOfObjectsHQLId  = hqlQueryGetStudById .list();
		System.out.println("HQL By Id -- "+listOfObjectsHQLId);
*/

		Query hqlQueryGetStudByName = session.getNamedQuery("hqlfindStudWithGivenName");
		hqlQueryGetStudByName.setString("sname","niki");
		List<Student> listOfObjectsHQLName  = hqlQueryGetStudByName.list();
		System.out.println("HQL By Name -- "+listOfObjectsHQLName);

	}
	}

	 
	/*@NamedNativeQueries(
			{
			@NamedNativeQuery(
			name = "sqlfindStudWithGivenId",
			query = "select * from Student_info  where student_id = :sid",
		        resultClass = Student.class
			),
			@NamedNativeQuery(
					name = "sqlfindStudWithGivenName",
					query = "select * from student_info  where student_name = :sname",
				        resultClass = Student.class
					)
		})*/
	
	@NamedQueries({ @NamedQuery(name = "hqlfindStudkWithGivenId", 
	query = "from Student where studId = :sid"),

	@NamedQuery(name = "hqlfindStudWithGivenName", 
	query = "from Student where studName = :sname")
	})
	
	@Entity
	@Table(name="student_info1")
	
	class Student{
		@Id
		//@GeneratedValue(strategy=GenerationType.TABLE)
		@Column(name="student_id")
		private int studId;
		
		@Column(name="student_name")
		private String studName;

		public int getStudId() {
			return studId;
		}

		public void setStudId(int studId) {
			this.studId = studId;
		}

		public String getStudName() {
			return studName;
		}

		public void setStudName(String studName) {
			this.studName = studName;
		}

		public Student(int studId, String studName) {
			super();
			this.studId = studId;
			this.studName = studName;
		}

		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Student [studId=" + studId + ", studName=" + studName + "]";
		}

	}	
		