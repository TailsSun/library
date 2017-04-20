package servlet;

import dbService.DBService;
import dbService.workBD.BDExchange;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by DNS on 30.03.2017.
 */
public class FaindBookServlet {

    private final DBService dbService;
    BDExchange bdexchange = new BDExchange();

    public FaindBookServlet(DBService dbService) {
        this.dbService = dbService;
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String book = request.getParameter("book");


        if (book.isEmpty()) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Невозможно найти книгу, поля пусты");
            return;
        } else {
            try {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().println("Ваши книга: ");

                response.setStatus(HttpServletResponse.SC_OK);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}