package com.example.retrofittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static com.example.retrofittest.RetrofitManager.getInstance;

public class MainActivity extends AppCompatActivity {

    // 1. 宣告MyAPIService
    MyAPIService myAPIService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//         2. 透過RetrofitManager取得連線基底
        myAPIService = RetrofitManager.getInstance().getAPI();

//         3. 建立連線的Call，此處設置call為myAPIService中的getAlbums()連線
        Call<Albums> call = myAPIService.getAlbums();

        // 4. 執行call
        call.enqueue(new Callback<Albums>() {
            @Override
            public void onResponse(Call<Albums> call, Response<Albums> response) {
                // 連線成功
                // 回傳的資料已轉成Albums物件，可直接用get方法取得特定欄位
                String title = response.body().getTitle();
                Log.d("{ userId  ", response.body().getUserId() + " id :  " + response.body().getId()+" title : "+ title+" }");
            }

            @Override
            public void onFailure(Call<Albums> call, Throwable t) {
                // 連線失敗
            }
        });

        final Call<Albums> call2 = myAPIService.getAlbumsById(2);

        call2.enqueue(new Callback<Albums>() {
            @Override
            public void onResponse(Call<Albums> call, Response<Albums> response) {
                String title = response.body().getTitle();
                Log.d("get{id}", title);
            }

            @Override
            public void onFailure(Call<Albums> call, Throwable t) {

            }
        });

        // 建立要POST的物件
        Albums albums = new Albums(1, 1, "Castle on the Hill");

// 將物件作為postAlbums的參數
        Call<Albums> call3 = myAPIService.postAlbums(albums);


        call3.enqueue(new Callback<Albums>() {
            @Override
            public void onResponse(Call<Albums> call, Response<Albums> response) {
                String title = response.body().getTitle();
                Log.d("post", response.body().getUserId() + "  " + response.body().getId()+"  "+ title);
            }

            @Override
            public void onFailure(Call<Albums> call, Throwable t) {

            }
        });



    }
}

