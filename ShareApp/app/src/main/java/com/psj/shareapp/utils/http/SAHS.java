package com.psj.shareapp.utils.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class SAHS {

    public boolean startServer() throws IOException
    {
        ThreadPoolExecutor threadPoolExecutor=(ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        final int PORT=2000;
        final String HOST="share.app";
        HttpServer httpServer=HttpServer.create(new InetSocketAddress(HOST,PORT),0);
        httpServer.createContext("/getFiles",new SAHSHttpHandler());
        httpServer.start();
        httpServer.setExecutor(threadPoolExecutor);
        return true;
    }
}

class SAHSHttpHandler implements HttpHandler
{
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Map<String,Object> parameters=new HashMap<String, Object>();
        InputStreamReader inputStreamReader=new InputStreamReader(exchange.getRequestBody(),"utf-8");
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        String query=bufferedReader.readLine();
        parseQuery(query,parameters);

    }

    private static void parseQuery(String query, Map<String,
            Object> parameters) throws UnsupportedEncodingException {

        if (query != null) {
            String pairs[] = query.split("[&]");
            for (String pair : pairs) {
                String param[] = pair.split("[=]");
                String key = null;
                String value = null;
                if (param.length > 0) {
                    key = URLDecoder.decode(param[0],
                            System.getProperty("file.encoding"));
                }

                if (param.length > 1) {
                    value = URLDecoder.decode(param[1],
                            System.getProperty("file.encoding"));
                }

                if (parameters.containsKey(key)) {
                    Object obj = parameters.get(key);
                    if (obj instanceof List<?>) {
                        List<String> values = (List<String>) obj;
                        values.add(value);

                    } else if (obj instanceof String) {
                        List<String> values = new ArrayList<String>();
                        values.add((String) obj);
                        values.add(value);
                        parameters.put(key, values);
                    }
                } else {
                    parameters.put(key, value);
                }
            }
        }
    }


}
