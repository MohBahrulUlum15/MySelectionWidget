package com.rememberdev.myselectionwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ListViewActivity extends AppCompatActivity {

    private ProgrammingLanguageAdapter programmingLanguageAdapter;
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private ArrayList<ProgrammingLanguange> programmingLanguages;

    ListView listView;
    String[] programmingLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        setTitle("List View");

        ListView listView = findViewById(R.id.list_view);
        programmingLanguageAdapter = new ProgrammingLanguageAdapter(this);
        listView.setAdapter(programmingLanguageAdapter);

        prepare();

        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, programmingLanguages.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_nama);
        dataDescription = getResources().getStringArray(R.array.data_deskripsi);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem() {
        programmingLanguages = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            ProgrammingLanguange proLang = new ProgrammingLanguange();
            proLang.setPhoto(dataPhoto.getResourceId(i, -1));
            proLang.setName(dataName[i]);
            proLang.setDescription(dataDescription[i]);
            programmingLanguages.add(proLang);
        }

        programmingLanguageAdapter.setHeroes(programmingLanguages);
    }
}