package com.example.sozlukuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetayActivity extends AppCompatActivity {
    private TextView textViewIng,textViewTur;
    Kelimeler kelime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        textViewIng = findViewById(R.id.textViewIng);
        textViewTur = findViewById(R.id.textViewTur);

        kelime = (Kelimeler) getIntent().getSerializableExtra("nesne");

        textViewIng.setText(kelime.getIngilizce());
        textViewTur.setText(kelime.getTurkce());

    }
}
