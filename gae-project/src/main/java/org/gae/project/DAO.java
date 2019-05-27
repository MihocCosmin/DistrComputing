package org.gae.project;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public enum DAO {

	INSTANCE;
	
	    //find all books
	    public List<Book> listBooks() {
	        EntityManager em = EMF.get().createEntityManager();
	        Query q = em.createQuery("select b from Book b");
	        List<Book> books = q.getResultList();
	        return books;
	    }
	 
	    //find books by user
	    public List<Book> getBook(String userId) {
	        EntityManager em = EMF.get().createEntityManager();
	        Query q = em.createQuery("select b from Book b where b.auth = :userId");
	        q.setParameter("userId", userId);
	        List<Book> books = q.getResultList();
	        return books;
	    }

	    //add new book
	    public void addBook(String userId, String title, String author, String description) {
	        synchronized (this) {
	            EntityManager em = EMF.get().createEntityManager();
	            Book book = new Book(userId, title, author, description);
	            em.persist(book);
	            em.close();
	        }
	    }

	    //delete book
	    public void removeBook(long id) {
	        EntityManager em = EMF.get().createEntityManager();
	        try {
	            Book book = em.find(Book.class, id);
	            em.remove(book);
	        } finally {
	            em.close();
	        }
	    }
}
