package com.example.fggi.medlockapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.zxing.integrator.android.IntentIntegrator;
import com.google.zxing.integrator.android.IntentResult;
import org.json.JSONException;
import org.json.JSONObject;

public class QRReader extends AppCompatActivity implements View.OnClickListener{

    EditText patientID;
    Button bqrReader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrreader);

        final TextView welcome = (TextView) findViewById(R.id.userName);
        patientID = (EditText) findViewById(R.id.patientID);
        bqrReader = (Button) findViewById(R.id.qrReader);
        final Button afterQR = (Button) findViewById(R.id.afterQRLogin);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        welcome.setText(name);

        bqrReader.setOnClickListener(this);
        afterQR.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.afterQRLogin:

                final String p_mail = patientID.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONObject jsonResponse = new JSONObject(response);

                            boolean success = jsonResponse.getBoolean("success");

                            Log.d("Succes", response.toString());

                            if (success) {

                                String p_id=jsonResponse.getString("p_id");
                                String p_name = jsonResponse.getString("p_name");
                                String p_mail = jsonResponse.getString("p_mail");
                                String p_phone = jsonResponse.getString("p_phone");
                                String p_bloodtype = jsonResponse.getString("p_bloodtype");
                                String p_surgery = jsonResponse.getString("p_surgery");
                                String p_medicine = jsonResponse.getString("p_medicine");
                                String p_doctorname = jsonResponse.getString("p_doctorname");
                                String p_conditions = jsonResponse.getString("p_conditions");
                                String p_notes = jsonResponse.getString("p_notes");


                                Intent intent = new Intent(QRReader.this, PatientInfo.class);
                                intent.putExtra("p_id", p_id);
                                intent.putExtra("p_name", p_name);
                                intent.putExtra("p_mail", p_mail);
                                intent.putExtra("p_phone", p_phone);
                                intent.putExtra("p_bloodtype", p_bloodtype);
                                intent.putExtra("p_surgery", p_surgery);
                                intent.putExtra("p_medicine", p_medicine);
                                intent.putExtra("p_doctorname", p_doctorname);
                                intent.putExtra("p_conditions", p_conditions);
                                intent.putExtra("p_notes", p_notes);


                                QRReader.this.startActivity(intent);


                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(QRReader.this);
                                builder.setMessage("Register failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                PatientRequest patientRequest = new PatientRequest(p_mail, responseListener);
                RequestQueue queue = Volley.newRequestQueue(QRReader.this);
                queue.add(patientRequest);


            case R.id.qrReader:
                IntentIntegrator scanIntegrator = new IntentIntegrator(this);
                scanIntegrator.initiateScan();



        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            //String scanFormat = scanningResult.getFormatName();
            //formatTxt.setText("FORMAT: " + scanFormat);
            patientID.setText( scanContent);

        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}


