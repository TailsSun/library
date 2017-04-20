package servlet;

import dbService.DBService;
import dbService.workBD.BDExchange;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by DNS on 31.03.2017.
 */
public class AllUserServlet extends HttpServlet {
    private final DBService dbService;

    public AllUserServlet(DBService dbService) {
        this.dbService = dbService;
    }
    BDExchange bdexchange = new BDExchange();
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String result = request.getParameter("inf");
        if (result.equals("1")){
            try {
                response.setContentType("text/html;charset=utf-8");
                for(Object q: bdexchange.getAllUser()){
                    response.setStatus(HttpServletResponse.SC_OK);
                    response.getWriter().println(q);
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        /*if (result.equals("2")){
            try {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().println(bdexchange.getNalBook());
                response.setStatus(HttpServletResponse.SC_OK);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (result.equals("3")){
            try {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().println(bdexchange.getNulBook());
                response.setStatus(HttpServletResponse.SC_OK);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
    }
}

