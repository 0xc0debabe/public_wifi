package com.hmw.jsp.wifi;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public class Rq {
    private final HttpServletRequest req;
    private HttpServletResponse resp;

    public Rq(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;
    }

    public String getPath() {
        return req.getRequestURI();
    }

    public void setAttr(String name, Object value) {
        req.setAttribute(name, value);
    }

    public void view(String path) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/" + path + ".jsp");

        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void replace(String url, String msg) {
        if (msg != null && !msg.trim().isEmpty()) {
            println("""
                    <script>
                        alert("%s");
                        window.location.replace("http://localhost:8080%s");
                    </script>
                    """.formatted(msg, url));
            System.out.println(1);
        }

        println("""
                    <script>
                        window.location.replace("http://localhost:8080%s");
                    </script>
                    """.formatted(url));
        System.out.println(2);
    }

    public void println(String str) {
        print(str + "\n");
    }

    public void print(String str) {
        try {
            resp.getWriter().append(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getParam(String paramName, String defaultValue) {
        String value = req.getParameter(paramName);

        if (value == null) {
            return defaultValue;
        }

        return value;
    }
}
