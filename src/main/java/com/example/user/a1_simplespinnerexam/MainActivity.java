package com.example.user.a1_simplespinnerexam;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    Spinner spinner;
    TextView textView;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        spinner.setSelection(1);

        spinner.setOnItemSelectedListener(this);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int selectedIndex = spinner.getSelectedItemPosition();
        Resources r = getResources();
        String[] data = r.getStringArray(R.array.spinner_data);

        Toast.makeText(this,data[selectedIndex],Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){
            case R.id.spinner:
                String selected = (String) parent.getSelectedItem();
                String result = position + "번째 항목>>"+ selected;
                textView.setText(result);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.d("SimplespinnerExam","onNotingSelected() called");
    }
}
