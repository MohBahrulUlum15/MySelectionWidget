package com.rememberdev.myselectionwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutoCompleteTextViewActivity extends AppCompatActivity {

    private static final String[] KOTA = new String[] {
            "Banyuwangi", "Situbondo", "Bondowoso", "Jember", "Lumajang", "Probolinggo", "Pasuruan", "Malang", "Sidoarjo", "Surabaya"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view);

        setTitle("Auto Complete Text View");

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.auto_complete);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, KOTA);
        autoCompleteTextView.setAdapter(adapter);
    }
}