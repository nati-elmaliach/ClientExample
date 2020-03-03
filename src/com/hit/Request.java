package com.hit;

public class Request {
    /*  action can be one of the following ->
        1. get -> return all quotes
        2. add/delete -> adding/deleting to/from db , you will get 0 or 1
        3. sort by parameter -> you will get sorted list of quotes by parameter

        parameter can be one of the following ->
        1. get -> default Null , can be author or ratings
        2. add -> should be json
        3. delete -> should be id(int)
        4. sort ->by author , or ratings

        I'm not going to validate your actions or params , please make sure you follow the examples.
     */
    private String action;
    private String parameter;
    private String stringParameter;
    private int intParameter;

    public Request(String action , String parameter , int intParameter) {
        this.action = action;
        this.parameter = parameter;
        this.intParameter = intParameter;
    }

    public Request(String action , String parameter , String stringParameter) {
        this.action = action;
        this.parameter = parameter;
        this.stringParameter = stringParameter;
    }


    public Request(String action){
        this.action = action;
    }
}
