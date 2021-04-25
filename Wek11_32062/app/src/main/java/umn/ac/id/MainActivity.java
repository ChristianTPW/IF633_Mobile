package umn.ac.id;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        Retrofit retro = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).build();

        DataRetriever retrieve = retro.create(DataRetriever.class);


        Call<ArrayList<Data>> datas = retrieve.getAllData();


        datas.enqueue(new Callback<ArrayList<Data>>() {

            @Override
            public void onResponse(@NonNull Call<ArrayList<Data>> call, @NonNull Response<ArrayList<Data>> response) {
                Log.e("tag", String.valueOf(response.code()));

                if (response.isSuccessful()) {
                    ArrayList<Data> data = response.body();
                    recyclerView.setAdapter(new DataAdapter(data));

                } else {
                    Log.e("tag", "Unsuccesful");

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Data>> call, Throwable t) {
                Log.e("tag", String.valueOf(call));

            }


        });


    }
}