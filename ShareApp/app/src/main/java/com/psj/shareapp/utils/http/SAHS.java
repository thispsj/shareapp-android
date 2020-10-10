package com.psj.shareapp.utils.http;

import android.content.Context;
import android.util.Log;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class SAHS {
    private Context context;
    //private static List<byte[]> files;
    //private static List<String> fileName;

    public SAHS(Context context) { this.context=context;}

    public boolean startServer() throws IOException {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        final int PORT = 2000;
        final String HOST = "share.app";
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(HOST, PORT), 0);
        httpServer.createContext("/getFiles", new SAHSHttpHandler());
        httpServer.createContext("/upFile", new MyFileHandler(context));
        httpServer.start();
        httpServer.setExecutor(threadPoolExecutor);
        return true;
    }
}

class MyFileHandler extends FileDataHandler
{
    private String FileInfo;
    private byte[] FileContent;
    private Context c;
    private final String TAG="File-Writer";

    MyFileHandler(Context c) {this.c=c;}

    @Override
    public void handle(HttpExchange httpExchange, List<MultiPart> parts) throws IOException {
        FileInfo=getFileName(httpExchange);
        FileContent=parts.get(0).bytes;
        File file=new File(c.getFilesDir(),"ZapShare");
        if(!file.exists()) {file.mkdir();}
        try
        {
            File sharedFile=new File(file,FileInfo);
            FileOutputStream fos = new FileOutputStream(sharedFile);
            fos.write(FileContent);
            fos.flush();
            fos.close();
        }
        catch(Exception e)
        {
            Log.e(TAG,"Error while writing file.");
        }
        //ByteArrayInputStream bais=new ByteArrayInputStream(parts.get(0).bytes);

    }

   // public String getFileInfo(){return FileInfo;}

    //public byte[] getFileContent() { return FileContent; }

    //returns the file name and extension type from headers.(Single File)
    private String getFileName(HttpExchange exchange)
    {
        String KEYS[]={"File-Name","File-Type"};
        String fen="";
        Headers headers=exchange.getRequestHeaders();
        fen+=headers.getFirst(KEYS[0]);
        fen+=","+headers.getFirst(KEYS[1]);
        return fen;
    }

    //returns the file names from the headers.(Multiple Files.)
    /*
    private String[] getFileNames(HttpExchange httpExchange)
    {
        String KEY="File-Name";
        Headers headers=httpExchange.getRequestHeaders();
        Map<String,String> map=new HashMap<>();
        //Set<String> set=headers.keySet();
        //Iterator<String> iterator=set.iterator();
        List<String> list=headers.get(KEY);
        if (list!=null)
        {
        for(int i=0;i<headers.size();i++) {
            String Content = list.get(i);
            map.put(KEY + i, Content);
        }}
        return null;
    } */
}

class SAHSHttpHandler implements HttpHandler
{
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        //Map<String,Object> parameters=new HashMap<String, Object>();
        //InputStreamReader inputStreamReader=new InputStreamReader(exchange.getRequestBody(),"utf-8");
        //BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        //String query=bufferedReader.readLine();
        //parseQuery(query,parameters);

    }

    /*
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
                        List<String> values = new ArrayList<>();
                        values.add((String) obj);
                        values.add(value);
                        parameters.put(key, values);
                    }
                } else {
                    parameters.put(key, value);
                }
            }
        }*/
    }

