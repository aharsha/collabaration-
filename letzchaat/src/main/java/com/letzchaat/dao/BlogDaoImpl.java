package com.letzchaat.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.letzchaat.model.Blog;

@Transactional
@Repository
public class BlogDaoImpl implements BlogDao{

	@Autowired
	SessionFactory sessionFactory;
	public void addBlog(Blog blog) {
		Session session=sessionFactory.getCurrentSession();
		  Date date=new Date();
		 String data=date.toString();
		 blog.setDate(data);
		session.save(blog);
		
	}
	public List<Blog> viewBlogs() {
		Session session=sessionFactory.getCurrentSession();
		
		List<Blog> list=session.createCriteria(Blog.class).list();
		
		return list;
	}
	public void updateBlog(Blog blog) {
		Session session=sessionFactory.getCurrentSession();
		  Date date=new Date();
			 String data=date.toString();
			 blog.setDate(data);
		session.update(blog);
		
	}
	public void deleteBlog(int id) {
		Session session=sessionFactory.getCurrentSession();
		Blog blog=(Blog)session.get(Blog.class,new Integer(id));
		session.delete(blog);
		
	}

}
