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
public class AddUserServlet extends HttpServlet {
    private final DBService dbService;

    public AddUserServlet(DBService dbService) {
        this.dbService = dbService;
    }
    BDExchange bdexchange  = new BDExchange();

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("user");


        if (login.isEmpty()) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Добавить человека не возможно, имя пусто");
            return;
        }
        else {

            try {
                long userId = bdexchange.addUser(login );
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().println("Вы успешно добавили Пользователя");
                response.getWriter().println("Ваш ID: " + userId);
                response.setStatus(HttpServletResponse.SC_OK);
            } catch (Exception e) {
                response.setContentType("text/html;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println("Такой человек уже есть");
                e.printStackTrace();
                return;
            }
        }
    }
}