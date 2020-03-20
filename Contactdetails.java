package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.TypedQuery;

public class Contactdetails {
    public static List<Contact> getListOfUsers() {
        List<Contact> list = new ArrayList<Contact>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        try {
            String strQuery = "SELECT c FROM Contact c";
            TypedQuery<Contact> tq = em.createQuery(strQuery, Contact.class);
            list = tq.getResultList();
            // list.forEach(cust -> System.out.println(cust.getName() + " " +
            // cust.getPhone()));

            em.getTransaction().commit();

        } catch (Exception e) {

            e.printStackTrace();
        } finally {

        }
        return list;
    }

}