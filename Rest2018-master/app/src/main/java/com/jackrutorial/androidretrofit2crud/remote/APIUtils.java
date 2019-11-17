package com.jackrutorial.androidretrofit2crud.remote;
import com.jackrutorial.androidretrofit2crud.remote.UserService;

public class APIUtils {

    private APIUtils(){
    };

    public static final String API_URL = "http://192.168.56.86:5000/";

    public static UserService getUserService(){
        return RetrofiCliente.getClient(API_URL).create(UserService.class);
    }
}
