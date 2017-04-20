import dbService.DBService;
import servlet.*;
import dbService.workBD.BDExchange;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


/**
 * Created by DNS on 29.03.2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        DBService dbService = new DBService();
        BDExchange bdexchange  = new BDExchange();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new AddUserServlet(dbService)), "/adduser");
        context.addServlet(new ServletHolder(new AddBookServlet(dbService)), "/addbook");
        context.addServlet(new ServletHolder(new AllBookServlet(dbService)), "/allbok");
        context.addServlet(new ServletHolder(new GetHomeBookServlet(dbService)), "/getbook");
        context.addServlet(new ServletHolder(new ReturnBookToLib(dbService)), "/returnbook");
        context.addServlet(new ServletHolder(new AllUserServlet(dbService)), "/alluser");


        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setResourceBase("public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});

        Server server = new Server(8080);
        server.setHandler(handlers);

/*        try {
            System.out.println(bdexchange.getUser("dsf"));
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        server.start();
        server.join();

    }
}
