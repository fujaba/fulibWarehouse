package org.fulib.service;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import org.fulib.scenarios.MockupTools;
import webapp.WebApp;

import java.io.IOException;
import java.io.StringWriter;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Service
{
   private HttpServer server;
   private ExecutorService executor;
   private WebApp webApp;


   public static void main(String[] args)
   {
      new Service().start();

   }

   private void start()
   {
      try
      {
         webApp = new WebApp().init();

         server = HttpServer.create(new InetSocketAddress(6677), 0);
         executor = Executors.newSingleThreadExecutor();
         server.setExecutor(executor);

         HttpContext doContext = server.createContext("/");
         doContext.setHandler(x -> handleRoot(x));

//         HttpContext getEventsContext = server.createContext("/get");
//         getEventsContext.setHandler(x -> handleGet(x));
//
//         HttpContext pingContext = server.createContext("/ping");
//         pingContext.setHandler(x -> handleShopPing(x));

//         builder.getStockUpdateChannel().createContext(server);

         server.start();
         System.out.println("Server is listening on port 6677" );
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }



   private void handleRoot(HttpExchange x)
   {
      try
      {
         StringWriter stringWriter = new StringWriter();
         MockupTools.htmlTool().dumpScreen(stringWriter, webApp);
         String page = stringWriter.toString();
         byte[] bytes = page.getBytes();
         x.sendResponseHeaders(200, bytes.length);
         x.getResponseBody().write(bytes);
         x.getResponseBody().close();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }
}
