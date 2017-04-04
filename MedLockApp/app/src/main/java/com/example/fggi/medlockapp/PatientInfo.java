package com.example.fggi.medlockapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class PatientInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_info);

        final TextView p_id=(TextView) findViewById(R.id.p_id);
        final TextView p_name=(TextView) findViewById(R.id.p_name);
        final TextView p_mail=(TextView) findViewById(R.id.p_mail);
        final TextView p_phone=(TextView) findViewById(R.id.p_phone);
        final TextView p_bloodtype=(TextView) findViewById(R.id.p_bloodtype);
        final EditText p_surgery=(EditText) findViewById(R.id.patientSurgery);
        final EditText p_medicine=(EditText) findViewById(R.id.patientMedicine);
        final EditText p_doctor=(EditText) findViewById(R.id.patientDoctor);
        final EditText p_conditions=(EditText) findViewById(R.id.patientConditions);
        final EditText p_notes=(EditText) findViewById(R.id.patientNotes);
        final Button  afterQR=(Button) findViewById(R.id.afterQRLogin);

        Intent intent=getIntent();
        String id=intent.getStringExtra("p_id");
        p_id.setText("ID Number= "+id);

        String name=intent.getStringExtra("p_name");
        p_name.setText("Name and Surname=" +name);

        String mail=intent.getStringExtra("p_mail");
        p_mail.setText(mail);

        String phone=intent.getStringExtra("p_phone");
        p_phone.setText("Phone Number="+phone);

        String blood=intent.getStringExtra("p_bloodtype");
        p_bloodtype.setText("Blood Type="+blood);

        String surgery=intent.getStringExtra("p_surgery");
        p_surgery.setText(surgery);

        String medicine=intent.getStringExtra("p_medicine");
        p_medicine.setText(medicine);

        String doctor=intent.getStringExtra("p_doctorname");
        p_doctor.setText(doctor);

        String conditions=intent.getStringExtra("p_conditions");
        p_conditions.setText(conditions);

        String notes=intent.getStringExtra("p_notes");
        p_notes.setText(notes);


        afterQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String surgery = p_surgery.getText().toString();
                final String medicine = p_medicine.getText().toString();
                final String doctor = p_doctor.getText().toString();
                final String cond = p_conditions.getText().toString();
                final String notes = p_notes.getText().toString();
                final String mail = p_mail.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){

                                AlertDialog.Builder builder = new AlertDialog.Builder(PatientInfo.this);
                                builder.setMessage("Update Is Successfull").create().show();

                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(PatientInfo.this);
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

                UpdateRequest updateRequest = new UpdateRequest(surgery, medicine, doctor ,cond, notes, mail, responseListener );
                RequestQueue queue = Volley.newRequestQueue(PatientInfo.this);
                queue.add(updateRequest);


            }
        });







    }
}
