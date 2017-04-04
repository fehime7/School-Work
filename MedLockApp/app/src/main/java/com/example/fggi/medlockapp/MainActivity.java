package com.example.fggi.medlockapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etMail=(EditText) findViewById(R.id.et_u_mail);
        final EditText etPassword=(EditText) findViewById(R.id.et_u_password);
        final Button   bLogin=(Button) findViewById(R.id.bLogin);


        if (bLogin != null) {
            bLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String mail=etMail.getText().toString();
                    final String password = etPassword.getText().toString();

                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");

                                if(success){

                                    String name = jsonResponse.getString("name");


                                    Intent intent = new Intent(MainActivity.this, QRReader.class);
                                    intent.putExtra("name", name);

                                    MainActivity.this.startActivity(intent);



                                }else{
                                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                    builder.setMessage("Register failed")
                                            .setNegativeButton("Retry",null)
                                            .create()
                                            .show();

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    };
                    LoginRequest loginRequest = new LoginRequest(mail, password, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                    queue.add(loginRequest);


                }
            });
        }


    }
}
