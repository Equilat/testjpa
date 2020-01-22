//package servlet;
//
//import domain.Utilisateur;
//
//import javax.persistence.*;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//@WebServlet(name = "userinfo",
//        urlPatterns = {"/UserInfo"})
//public class UserInfo extends HttpServlet {
//    public void doPost(HttpServletRequest request,
//                       HttpServletResponse response)
//            throws IOException {
//        response.setContentType("text/html");
//
//        String nom = request.getParameter("name");
//        String prenom = request.getParameter("firstname");
//        String mail = request.getParameter("mail");
//
//        EntityManagerFactory factory = Persistence
//                .createEntityManagerFactory("dev");
//        EntityManager manager = factory.createEntityManager();
//        EntityTransaction tx = manager.getTransaction();
//        tx.begin();
//        try {
//            Utilisateur utilisateur1 = new Utilisateur(mail, nom, prenom);
//            manager.persist(utilisateur1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        tx.commit();
//
//        manager.close();
//        factory.close();
//
//        PrintWriter out = response.getWriter();
//
//        out.println("<HTML>\n<BODY>\n" +
//                "<H1>Recapitulatif des informations</H1>\n" +
//                "<UL>\n" +
//                " <LI>Nom: "
//                + request.getParameter("name") + "\n" +
//                " <LI>Prenom: "
//                + request.getParameter("firstname") + "\n" +
//                " <LI>Mail: "
//                + request.getParameter("mail") + "\n" +
//                "</UL>\n" +
//                "</BODY></HTML>");
//    }
//
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String s = "SELECT e FROM Utilisateur as e ";//where e.mail=:mail";
//        EntityManagerFactory factory = Persistence
//                .createEntityManagerFactory("dev");
//        EntityManager manager = factory.createEntityManager();
//        EntityTransaction tx = manager.getTransaction();
//        Query q = manager.createQuery(s, Utilisateur.class);
////        q.setParameter("mail", "martin2@mail.com");
//        List<Utilisateur> res = q.getResultList();
//
//        PrintWriter out = response.getWriter();
//
//        out.println("Liste utilisateurs : \n");
//        out.println("Taille : " + res.size());
//
//    }
//}