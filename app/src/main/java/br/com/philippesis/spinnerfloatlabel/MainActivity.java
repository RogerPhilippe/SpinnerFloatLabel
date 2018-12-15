package br.com.philippesis.spinnerfloatlabel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;

public class MainActivity extends AppCompatActivity {

    private MaterialSpinner mspMain;
    private List<String> mList;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList = new ArrayList<>();
        mList.add("Láps");
        mList.add("Caneta");
        mList.add("Caneca");
        mList.add("Camiseta");

        mspMain = (MaterialSpinner) findViewById(R.id.idspMain);

        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, mList);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mspMain.setAdapter(mAdapter);

        mspMain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if(position != -1) {
                    if(mspMain.getItemAtPosition(position).toString().equals("Láps")) {
                        mspMain.setError("Esse item está em falta");
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
