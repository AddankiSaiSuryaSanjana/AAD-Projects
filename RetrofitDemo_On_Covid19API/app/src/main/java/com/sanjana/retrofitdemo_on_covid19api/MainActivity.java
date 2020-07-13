package com.sanjana.retrofitdemo_on_covid19api;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView activeCases, deathCases, date_text, recoveredCases, confirmedCases;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activeCases = findViewById(R.id.active_tv);
        deathCases = findViewById(R.id.death_tv);
        date_text = findViewById(R.id.date_tv);
        recoveredCases = findViewById(R.id.recovered_tv);
        confirmedCases = findViewById(R.id.confirmed_tv);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Date Fetching...... From Internet!!");
        progressDialog.setMessage("Please Wait :-) Loading........");
        EndPointInterface endPointInterface = RetrofitInstance.getInstance().create(EndPointInterface.class);
        Call<String> call = endPointInterface.getData();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                progressDialog.dismiss();
                JSONArray jsonArray = null;
                try {
                    jsonArray = new JSONArray(response.body());
                    for(int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String confirmed = jsonObject.getString("Confirmed");
                        String deaths = jsonObject.getString("Deaths");
                        String recovered = jsonObject.getString("Recovered");
                        String active = jsonObject.getString("Active");
                        String date = jsonObject.getString("Date");
                        date_text.setText("Date " + forDateFormat(date));
                        activeCases.setText("ActiveCases " + active);
                        recoveredCases.setText("recoveredCases " + recovered);
                        deathCases.setText("deathCases " + deaths);
                        confirmedCases.setText("confirmedCases " + confirmed);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Toast.makeText(MainActivity.this, "" + response.body(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something Went Wrong With The Get Data.....", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private String forDateFormat(String date) {
        String inputPattern = "yy-mm-dd";
        String outputPattern = "dd-mm-yy";
        SimpleDateFormat simpleDateInputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat simpleDateOutputFormat = new SimpleDateFormat(outputPattern);
        Date date1 = null;
        String str = null;
        try {
            date1 = simpleDateInputFormat.parse(date);
            str = simpleDateOutputFormat.format(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }
}