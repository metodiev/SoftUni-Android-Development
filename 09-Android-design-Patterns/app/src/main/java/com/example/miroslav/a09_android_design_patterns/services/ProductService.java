package com.example.miroslav.a09_android_design_patterns.services;

import com.example.miroslav.a09_android_design_patterns.entities.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ProductService {

    @GET("search/{keyword}")
    Call<List<Product>> search(@Path("keyword") String keyword);
}
