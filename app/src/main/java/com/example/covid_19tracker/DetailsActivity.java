package com.example.covid_19tracker;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.Objects;

public class DetailsActivity extends AppCompatActivity {

    private int position;
    PieChart pieChart;
    TextView tvCases, tvDeaths, tvCasesToday, tvDeathsToday, tvRecovered, tvActive, tvCritical, tvCasesPerMillion, tvDeathsPerMillion,
            tvTestsPerMillion, tvContinent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent= getIntent();
        position= intent.getIntExtra("position",0);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Details of "+ AffectedCountries.countryModelList.get(position).getCountry());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ActionBar actionBar= getSupportActionBar();
        if(actionBar!= null){
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg));
        }

        tvCases= findViewById(R.id.tvCases);
        tvDeaths= findViewById(R.id.tvDeaths);
        tvCasesToday= findViewById(R.id.tvCasesToday);
        tvDeathsToday= findViewById(R.id.tvDeathsToday);
        tvRecovered= findViewById(R.id.tvRecovered);
        tvActive= findViewById(R.id.tvActive);
        tvCritical= findViewById(R.id.tvCritical);
        tvCasesPerMillion= findViewById(R.id.tvCasesPerMillion);
        tvDeathsPerMillion= findViewById(R.id.tvDeathsPerMillion);
        tvTestsPerMillion= findViewById(R.id.tvTestsPerMillion);
        tvContinent= findViewById(R.id.tvContinent);
        pieChart= findViewById(R.id.piechart);

        tvCases.setText(AffectedCountries.countryModelList.get(position).getCases());
        tvDeaths.setText(AffectedCountries.countryModelList.get(position).getDeaths());
        tvCasesToday.setText(AffectedCountries.countryModelList.get(position).getCasesToday());
        tvDeathsToday.setText(AffectedCountries.countryModelList.get(position).getDeathsToday());
        tvRecovered.setText(AffectedCountries.countryModelList.get(position).getRecovered());
        tvActive.setText(AffectedCountries.countryModelList.get(position).getActive());
        tvCritical.setText(AffectedCountries.countryModelList.get(position).getCritical());
        tvCasesPerMillion.setText(AffectedCountries.countryModelList.get(position).getCasesPerMillion());
        tvDeathsPerMillion.setText(AffectedCountries.countryModelList.get(position).getDeathsPerMillion());
        tvTestsPerMillion.setText(AffectedCountries.countryModelList.get(position).getTestsPerMillion());
        tvContinent.setText(AffectedCountries.countryModelList.get(position).getContinent());

        pieChart.addPieSlice(new PieModel("Active",Integer.parseInt(tvActive.getText().toString()), Color.parseColor("#29B6F6")));
        pieChart.addPieSlice(new PieModel("Recovered",Integer.parseInt(tvRecovered.getText().toString()), Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(new PieModel("Deaths",Integer.parseInt(tvDeaths.getText().toString()), Color.parseColor("#EF5350")));

        pieChart.startAnimation();

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
