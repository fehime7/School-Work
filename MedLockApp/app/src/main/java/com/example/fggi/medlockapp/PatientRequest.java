package com.example.fggi.medlockapp;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class PatientRequest extends StringRequest {
    private static final String PATIENT_REQUEST_URL = "http://fehime.comxa.com/Patient.php";
    private Map<String, String > params;

    public PatientRequest(String p_mail, Response.Listener<String> listener){
        super(Request.Method.POST, PATIENT_REQUEST_URL, listener, null);
        //String p_id=id+"";
        params = new HashMap<>();
        params.put("p_mail", p_mail);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
