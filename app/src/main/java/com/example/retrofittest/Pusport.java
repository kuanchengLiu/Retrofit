package com.example.retrofittest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pusport {


    @SerializedName("account")
    @Expose
    private String account;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("code")
    @Expose
    private String code;

    public Pusport(String account, String password, String code) {
        this.account = account;
        this.password = password;
        this.code = code;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getCode() {
        return code;
    }

}
