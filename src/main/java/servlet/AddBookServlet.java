package servlet;


import dbService.DBService;
import dbService.workBD.BDExchange;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by DNS on 25.02.2017.
 */
public class AddBookServlet extends HttpServlet {
    private final DBService dbService;

    public AddBookServlet(DBService dbService) {
        this.dbService = dbService;
    }
    BDExchange bdexchange  = new BDExchange();

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String book = request.getParameter("book");


        if (book.isEmpty()) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Добавить книгу  не возможно, поля пусты");
            return;
        }
        else {

            try {
                long bookId = bdexchange.addBook(book);
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().println("Вы успешно добавили Книгу");
                response.getWriter().println(" ID: " + bookId);
                response.setStatus(HttpServletResponse.SC_OK);
            } catch (Exception e) {
                response.setContentType("text/html;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println("Такая книга уже есть");
                e.printStackTrace();
                return;
            }
        }
    }
}