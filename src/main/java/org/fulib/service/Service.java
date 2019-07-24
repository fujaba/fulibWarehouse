package org.fulib.service;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import jdk.nashorn.internal.ir.debug.JSONWriter;
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
   private Object webApp;


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

         HttpContext doContext = server.createContext("/start");
         doContext.setHandler(x -> handleRoot(x));

         HttpContext cmdContext = server.createContext("/cmd");
         cmdContext.setHandler(x -> handleCmd(x));

         server.start();
         System.out.println("Server is listening on port 6677" );
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }

   private void handleCmd(HttpExchange x)
   {
      try
      {
         String page = "Hello from Fulib";
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
