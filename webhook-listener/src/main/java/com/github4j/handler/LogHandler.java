package com.github4j.handler;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class LogHandler extends AbstractHandler {
    private static final Logger LOG = LoggerFactory.getLogger(LogHandler.class);

    @Override
    public void handle(String target, Request baseRequest,
                       HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        StringBuilder builder = new StringBuilder(request.getMethod()).append(' ').append(request.getPathInfo())
                .append(' ').append(baseRequest.getHttpVersion().toString());
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            builder.append(System.lineSeparator()).append(headerName).append(": ").append(request.getHeader(headerName));
        }
        if (request.getContentLength() > 0) {
            builder.append(System.lineSeparator()).append(System.lineSeparator());
            while (true) {
                String line = request.getReader().readLine();
                if (line == null)
                    break;
                builder.append(line).append(System.lineSeparator());
            }
        }
        LOG.info("==================\n{}\n==================", builder.toString());
    }
}
