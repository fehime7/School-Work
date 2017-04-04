package com.example.fggi.medlockapp;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class UpdateRequest extends StringRequest {

    private static final String UPDATE_REQUEST_URL = "http://fehime.comxa.com/Update.php";
    private Map<String, String> params;

    public UpdateRequest(String surgery, String medicine, String doctorname, String conditions, String notes, String mail, Response.Listener<String> listener){
        super(Method.POST, UPDATE_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("p_surgery", surgery);
        params.put("p_medicine", medicine);
        params.put("p_doctorname", doctorname);
        params.put("p_conditions", conditions);
        params.put("p_notes", notes);
        params.put("p_mail", mail);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

