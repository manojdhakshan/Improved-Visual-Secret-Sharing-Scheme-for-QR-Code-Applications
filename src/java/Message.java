/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import algorithm.AES128Cipher;
import algorithm.CipherHelper;
import algorithm.Division_Algorithm;
import dbServices.DB;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pack.QRCode;

/**
 *
 * @author DLK-F2
 */
public class Message extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            HttpSession session=request.getSession();
            String name=(String)session.getAttribute("name");
            String id=(String)session.getAttribute("iid");
            Connection con=new DB().fun();
            PreparedStatement pst=con.prepareStatement("truncate table msg");
            pst.executeUpdate();
            String text=request.getParameter("text").trim();
            AES128Cipher aes=new AES128Cipher();
            CipherHelper c=new CipherHelper();
            Division_Algorithm d=new Division_Algorithm();
            d.set_Values(text, 9);
            String val[]=d.Get_Process();
            Random r=new Random();
            int key=r.nextInt(10000);
            String skey=Integer.toString(key);
            int size=val.length;
            QRCode qr=new QRCode();
            int i=0;
            for (String val1 : val)
            {
                i++;
                System.out.println(val1);
                String enc=c.cipher("12345678", val1);
                System.out.println("Encrypted text "+enc);
                String iname=skey+"img"+i;
                ServletContext sc=request.getSession().getServletContext();
                File savedFile = new File(sc.getRealPath("images")+"/" + iname);
                qr.qr(enc, sc.getRealPath("images")+"\\"+iname+".png");
                PreparedStatement ps=con.prepareStatement("insert into msg(name,uid,txt,enc,skey,iname)values('"+name+"','"+id+"','"+val1+"','"+enc+"','"+skey+"','"+iname+"')");
                ps.executeUpdate();
                
            }
            
            out.println("<script type=\"text/javascript\">"); 			
            out.println("alert(\"Succesfully Splitted and Encrypted\")");
            out.println("</script>");
            RequestDispatcher rd=request.getRequestDispatcher("Message1.jsp");   
            rd.include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
