/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.servlets;

import com.sv.udb.controladores.CtrlTipos;
import com.sv.udb.modelos.Tipos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author walte
 */
@WebServlet(name = "TiposServ", urlPatterns = {"/TiposServ"})
public class TiposServ extends HttpServlet {

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
        boolean esValido = request.getMethod().equals("POST");
        if(esValido)
        {
            String mens = "";
            String CRUD = request.getParameter("TipoBton");
            switch (CRUD) {
                case "Guardar":
                {
                    Tipos obje = new Tipos();
                    obje.setNombTipo(request.getParameter("nomb"));
                    mens = new CtrlTipos().guar(obje) ? "Datos guardados exitosamente" : "Datos NO guardados";
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                    break;
                }
                case "Consultar":
                {
                    //Para un objeto
                    Integer codi = Integer.parseInt(request.getParameter("codi"));
                    Tipos objeTipo = new CtrlTipos().cons(codi);
                    request.setAttribute("codi", objeTipo.getCodiTipo());
                    request.setAttribute("nomb", objeTipo.getNombTipo());
                    //Para una lista [Tablas]
                    List<Tipos> listTipo = new CtrlTipos().cons();
                    break;
                }
                case "Modificar":
                {
                    Tipos obje = new Tipos();
                    obje.setCodiTipo(Integer.parseInt(request.getParameter("codi")));
                    obje.setNombTipo(request.getParameter("nomb"));
                    mens = new CtrlTipos().edit(obje) ? "Datos editados exitosamente" : "Datos NO editados";
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                    break;
                }
                case "Eliminar":
                {
                    Tipos obje = new Tipos();
                    obje.setCodiTipo(Integer.parseInt(request.getParameter("codi")));
                    obje.setNombTipo(request.getParameter("nomb"));
                    mens = new CtrlTipos().dele(obje) ? "Datos eliminados exitosamente" : "Datos NO eliminados";
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                    break;
                }
                default:
                    break;
            }
             request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        else
        {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
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
