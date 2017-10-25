/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Servlet Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloWorld
*/

package com.github.pavelkv96.hw_16102017.backend;

import com.example.Configuration;
import com.google.gson.Gson;

import java.io.IOException;


import javax.servlet.http.*;

public class MyServlet extends HttpServlet {

    @Override
    public void doPost(final HttpServletRequest request,final HttpServletResponse response)
            throws IOException {
        final Integer version = Integer.valueOf(request.getParameter("version"));
        final Boolean update = Boolean.valueOf(request.getParameter("update"));
        response.setContentType("application/json");
        final Configuration result = new Configuration();
        try {
            result.setVersion(version);
            result.setUpdate(update);
        }catch (final Exception e){
            result.setError(e.toString());
        }
        new Gson().toJson(result, response.getWriter());
    }
}
