package servlet;

import dbService.DBService;
import dbService.workBD.BDExchange;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by DNS on 30.03.2017.
 */
public class ReturnBookToLib extends HttpServlet {

    private final DBService dbService;
    BDExchange bdexchange = new BDExchange();

    public ReturnBookToLib(DBService dbService) {
        this.dbService = dbService;
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String book = request.getParameter("book");
        response.setContentType("text/html;charset=utf-8");
        if (book.isEmpty() || name.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Что-то пошло не так, выточно заполнили оба поля?");
            return;
        } else {

            try {
                String nameResult = bdexchange.getUser(name);
            } catch (NullPointerException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println("Что-то пошло не так, Нет такого юзверя");
                return;
            }
            try {
                String bookResult = bdexchange.gotBook(book);
            } catch (NullPointerException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println("Что-то пошло не так, Нет такой книги");
                return;
            }
            response.setStatus(HttpServletResponse.SC_OK);
            String result = bdexchange.returnBookLib(name, book);
            response.getWriter().println(result);

        }
    }
}
