package umn.ac.id;

import java.util.ArrayList;

import retrofit2.http.GET;
import retrofit2.Call;


public interface DataRetriever {
    @GET("posts")
    Call<ArrayList<Data>> getAllData();
}