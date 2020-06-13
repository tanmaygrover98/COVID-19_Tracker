package com.example.covid_19tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;

import org.eazegraph.lib.models.PieModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AffectedCountries extends AppCompatActivity {

    EditText editText;
    ListView listView;
    SimpleArcLoader simpleArcLoader;

    public static List<CountryModel> countryModelList= new ArrayList<>();
    CountryModel countryModel;
    MyCustomAdapter myCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affected_countries);

        editText= findViewById(R.id.etSearch);
        listView= findViewById(R.id.listView);
        simpleArcLoader= findViewById(R.id.loader2);
        getSupportActionBar().setTitle("Affected Countries");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        fetchData();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                myCustomAdapter.getFilter().filter(s);
                myCustomAdapter.notifyDataSetChanged();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void fetchData() {

        String url= "https://corona.lmao.ninja/v2/countries/";

        simpleArcLoader.start();
        StringRequest request= new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray= new JSONArray(response);

                            for (int i=0; i<jsonArray.length();i++)
                            {
                                JSONObject jsonObject= jsonArray.getJSONObject(i);
                                String countryName= jsonObject.getString("country");
                                String cases= jsonObject.getString("cases");
                                String deaths= jsonObject.getString("deaths");
                                String casesToday= jsonObject.getString("todayCases");
                                String deathsToday= jsonObject.getString("todayDeaths");
                                String recovered= jsonObject.getString("recovered");
                                String active= jsonObject.getString("active");
                                String critical= jsonObject.getString("critical");
                                String casesPerMillion= jsonObject.getString("casesPerOneMillion");
                                String deathsPerMillion= jsonObject.getString("deathsPerOneMillion");
                                String testsPerMillion= jsonObject.getString("testsPerOneMillion");
                                String continent= jsonObject.getString("continent");

                                JSONObject object= jsonObject.getJSONObject("countryInfo");
                                String flag= object.getString("flag");

                                countryModel = new CountryModel(flag, countryName, cases, deaths,casesToday,deathsToday,recovered,active,
                                        critical,casesPerMillion,deathsPerMillion,testsPerMillion,continent);

                                countryModelList.add(countryModel);
                            }

                            myCustomAdapter= new MyCustomAdapter(AffectedCountries.this,countryModelList);
                            listView.setAdapter(myCustomAdapter);
                            simpleArcLoader.stop();
                            simpleArcLoader.setVisibility(View.GONE);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            simpleArcLoader.stop();
                            simpleArcLoader.setVisibility(View.GONE);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AffectedCountries.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                simpleArcLoader.stop();
                simpleArcLoader.setVisibility(View.GONE);
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request);

    }

}