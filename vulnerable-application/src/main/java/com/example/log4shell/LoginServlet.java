package com.example.log4shell;

import java.io.*;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@WebServlet(name = "loginServlet", value = "/pwnme")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body><pre>");
        Logger logger = LogManager.getLogger(com.example.log4shell.log4j.class);
       Enumeration enumeration = req.getHeaderNames();
        while (enumeration.hasMoreElements()) 
        {
             String header = (String) enumeration.nextElement();
             out.println(header + ": " + req.getHeader(header) + "\n");
                 logger.info(header + ": " + req.getHeader(header) + "\n" );
                 logger.error(req.getHeader(header));
        }
        out.println("</pre>");
        out.println("<code>did it work?</code>");
    }

    public void destroy() {
    }
}
