
package control;
//importa estas librerias
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Servicio;

@WebServlet(name = "SumaServlet", urlPatterns = {"/SumaServlet"})
public class SumaServlet extends HttpServlet {

   
    //recibe en el objeto request los datos
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        /*
        //extraer los datos recibidos del cliente web
        String dato1=request.getParameter("num1");//se extrae siempre en string
        String dato2=request.getParameter("num2");
        //se convierte a entero
        int a=Integer.parseInt(dato1);
        int b=Integer.parseInt(dato2);
        //invocar al modelo
        Servicio serv= new Servicio();
        int c= serv.sumar(a, b);*/
        //muestro el resultado
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SumaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SumaServlet at " + request.getContextPath() + "</h1>");
           /* out.println("suma="+c+"<br>");//para mostrar el resultado*/
            out.println("</body>");
            out.println("</html>");
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
            //borro esta llamada
            //processRequest(request, response);
            response.setContentType("text/html;charset=UTF-8");//para identificar el html
            PrintWriter out=response.getWriter();
            out.println("metodo doGet()");
            //se extrae siempre en string
            String dato1=request.getParameter("num1");
            String dato2=request.getParameter("num2");
            String oper=request.getParameter("operacion");
            //se convierte a entero
            int a=Integer.parseInt(dato1);
            int b=Integer.parseInt(dato2);
            char op=oper.charAt(0);//extrae un parametro de una cadena
            //invocar al modelo
            Servicio serv= new Servicio();
            double c= serv.operacion(a, b, op);
            out.println("<table border=1><tr><td>");
            out.println("resultado="+c);
            out.println("</table></tr></td>");
            out.println("<a href='index.html'>Regresar</a><br>");//para un enlace de retorno 
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
            //borro esta llamada
            //processRequest(request, response);
            PrintWriter out=response.getWriter();
            out.println("metodo doPost()");
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
