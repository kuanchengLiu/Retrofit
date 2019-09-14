package com.example.retrofittest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

// 注意是interface而不是class哦
public interface MyAPIService {

    // 測試網站      https://jsonplaceholder.typicode.com/
    // GET網址      https://jsonplaceholder.typicode.com/albums/1
    // POST網址     https://jsonplaceholder.typicode.com/albums
    // ...typicode.com/[這裡就是API的路徑]

    @GET("albums/1")    // 設置一個GET連線，路徑為albums/1
    Call<Albums> getAlbums();    // 取得的回傳資料用Albums物件接收，連線名稱取為getAlbums

    @GET("albums/{id}") // 用{}表示路徑參數，@Path會將參數帶入至該位置
    Call<Albums> getAlbumsById(@Path("id") int id);

    @POST("albums") // 用@Body表示要傳送Body資料
    Call<Albums> postAlbums(@Body Albums albums);

//    @POST("~pusport/PUsport/index.php/API/login")
//    Call<Pusport> postAlbums(@Field("account") String account, @Field("password") String password, @Field("code") String code);
}
