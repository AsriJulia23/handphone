package com.example.spesipikasihandphone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView txtnamaProduk,txtram,txtinternalMemory,harga;
    private ImageView imageView;
    private ApiInterface apiInterface;
    private ApiClient apiClient;
    private List <Handphone>handphones;
    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;
    HpAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView=(RecyclerView)findViewById(R.id.hpku);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Handphone>>call=apiInterface.getHandphone();
        call.enqueue(new Callback<List<Handphone>>() {
            @Override
            public void onResponse(Call<List<Handphone>> call, Response<List<Handphone>> response) {
                handphones=response.body();
                adapter=new HpAdapter(handphones,MainActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Handphone>> call, Throwable t) {

            }
        });
    }
}
