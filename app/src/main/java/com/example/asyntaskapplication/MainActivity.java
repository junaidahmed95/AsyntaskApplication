package com.example.asyntaskapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.asyntaskapplication.Adapter.asynTaskAdapter;
import com.example.asyntaskapplication.Model.AsynList;
import com.example.asyntaskapplication.Model.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

import android.os.AsyncTask;

public class MainActivity extends AppCompatActivity {

    private List<AsynList> lists;

    private asynTaskAdapter adapter;
    private RecyclerView recyclerView;
    private Button mbutton;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        mbutton = findViewById(R.id.button);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAsynTask myAsynTask = new MyAsynTask();
                myAsynTask.execute();

            }
        });


    }


    private void FeaturedStore() {
        retrofit2.Call<List<AsynList>> done = RetrofitClient.getmInstance().getApi()
                .list();
        done.enqueue(new Callback<List<AsynList>>() {
            @Override
            public void onResponse(retrofit2.Call<List<AsynList>> call, retrofit2.Response<List<AsynList>> response) {


               response.body();


            }

            @Override
            public void onFailure(retrofit2.Call<List<AsynList>> call, Throwable t) {


            }
        });


    }


    class MyAsynTask extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Please Wait");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }


        @Override
        protected String doInBackground(String... strings) {
            FeaturedStore();

            return null;
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            adapter = new asynTaskAdapter(, MainActivity.this);
            recyclerView.setAdapter(adapter);
            recyclerView.setVisibility(View.VISIBLE);
            mbutton.setVisibility(View.GONE);
            progressDialog.dismiss();
            adapter.notifyDataSetChanged();

        }
    }

}



