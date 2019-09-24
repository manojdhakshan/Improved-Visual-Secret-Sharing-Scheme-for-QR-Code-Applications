/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import algorithm.CipherHelper;
import com.google.zxing.EncodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.imageio.ImageIO;

import dbServices.DB;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mail.mail;
import pack.QRCode;

/**
 *
 * @author DLK-F2
 */
public class Merge extends HttpServlet {

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
            ServletContext sc=request.getSession().getServletContext();
            HttpSession session=request.getSession();
//        String key=request.getParameter("skey");
           String email=(String)session.getAttribute("email");
            String name=request.getParameter("name");
            
            Connection con=new DB().fun();
            PreparedStatement query1=con.prepareStatement("SELECT * FROM msg where rname='"+name+"'  ");
            ResultSet rs=query1.executeQuery();
            System.out.println("select * from msg where rname='"+name+"'");
            QRCode qr=new QRCode();
            String content="";
            String skey="";
            while(rs.next())
            {
                String userid=rs.getString("uid");
                String username=rs.getString("name");
                String txt=rs.getString("txt");
                String enc=rs.getString("enc");
                 skey=rs.getString("skey");
                 System.out.println("skey bfr email "+skey);
                String iname=rs.getString("iname");
                
                File savedFile = new File(sc.getRealPath("images")+"\\" + iname+".png");
                System.out.println(sc.getRealPath("images")+"\\" + iname+".png");
                String charset = "UTF-8"; // or "ISO-8859-1" 000000000000000233333
                Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<>();
                hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
                String path=sc.getRealPath("images")+"\\"+ iname+".png";
                System.out.println("Path  "+path);
                content+=qr.readQRCode(path, charset, hintMap).trim();
                System.out.println(content);
            }
            CipherHelper c=new CipherHelper();
            String original=c.decipher("12345678", content).trim();
            System.out.println("Decipher "+original);
            File savedFile = new File(sc.getRealPath("images")+"/" + name);
            qr.qr(original, sc.getRealPath("images")+"\\"+name+".png");
                String em[]= new String[1];
		session.setAttribute("key",skey);
                String subject="Your Secret key";
                String message="User Name  :"+name+"\nUser Key  :"+skey;
                System.out.println("Message "+message);
                String fr="otpmessenger";   //with out @gmail.com
                String pw="qawsedrftg";		      // sender password
                em[0]=email;
                mail mmm=new mail();
                mmm.sendFromGMail(fr, pw, em, subject, message);
            out.println("<script>"
                        +"alert('Merged Successfully')"
                        +"</script>");
            
            
                RequestDispatcher rd = request.getRequestDispatcher("Merge.jsp");
                rd.include(request, response);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Merge.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Merge.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (WriterException ex) {
            Logger.getLogger(Merge.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFoundException ex) {
            Logger.getLogger(Merge.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Merge.class.getName()).log(Level.SEVERE, null, ex);
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
