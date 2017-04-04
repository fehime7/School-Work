package com.example.fggi.medlockapp;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://fehime.comxa.com/User.php";
    private Map<String, String > params;

    public LoginRequest(String mail, String password, Response.Listener<String> listener){
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        //String sid=id+"";
        params = new HashMap<>();
        params.put("mail",mail);
        params.put("password", password);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

