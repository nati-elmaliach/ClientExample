package com.hit;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {

            // responseFromServer -> the response i will send you back
            BufferedReader responseFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // requestFromServer -> the request that you formatted as json
            PrintWriter requestFromServer = new PrintWriter(socket.getOutputStream(), true);

            String response;

            // Create a request object for every request
            /*
            *
            * simple get request
              Request request = new Request("get");

              get request for id
              Request request = new Request("get" , "id" , 5);
            *
            *
            * get request for rating result will be rating >= intParameter
              Request request = new Request("get", "rating", 2);

            * get request by author , notice that im not gonig to validate your string , consider adding dropdown menu
            * Request request = new Request("get", "author", "Henry Ford" );

            * */



            Request request = new Request("delete", "id", 1 );


            // an external library to format objects to json, see the link -> https://github.com/google/gson
            Gson gson = new Gson();

            // convert the request to json
            String jsonRequest = gson.toJson(request);

            // println -> send the request to the server
            requestFromServer.println(jsonRequest);

            // you are getting the response here
            response = responseFromServer.readLine();
            System.out.println(response);

        } catch (IOException e) {
            e.getMessage();
        }
    }
}
