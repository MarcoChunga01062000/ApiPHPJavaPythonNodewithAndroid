package com.jackrutorial.androidretrofit2crud.remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import upeu.edu.pe.rest2018.Usuario;

public interface UserService {
    @GET("users")
    Call<List<Usuario>> getUsers();

    @POST("add/")
    Call<Usuario> addUser(@Body Usuario user);

    @PUT("update")
    Call<Usuario> updateUser(@Path("id") int id, @Body Usuario user);

    @DELETE("delete")
    Call<Usuario> deleteUser(@Path("id") int id);
}
