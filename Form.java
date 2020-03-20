package com.mycompany.app;
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
import java.io.BufferedReader;
import com.google.gson.Gson;
import org.json.JSONObject; 

@WebServlet(name= "/jsonformat" ,urlPatterns ="/jsonformat")
public class Form extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                BufferedReader reader = request.getReader();
                String json=reader.readLine();
                String line=null;
                try {
                    while ((line = reader.readLine()) != null){
                        json +=line; 
                  }  
                }catch (Exception e) { 
                      e.printStackTrace();
                   } 
                Gson g=new Gson();
              
                Contact pojo=g.fromJson(json, Contact.class);
                
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        
        // PrintWriter kk=response.getWriter();
        // kk.println(et);
        em.persist(pojo);
        et.commit();
        response.sendRedirect("index.jsp");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
