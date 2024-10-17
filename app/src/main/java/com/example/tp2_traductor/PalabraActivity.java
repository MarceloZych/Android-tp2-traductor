package com.example.tp2_traductor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp2_traductor.databinding.ActivityPalabraBinding;

public class PalabraActivity extends AppCompatActivity {
    private ActivityPalabraBinding binding;
    private TraductorViewModel traductorViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPalabraBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_palabra);

        traductorViewModel = new ViewModelProvider(this).get(TraductorViewModel.class);

        String palabraEsp = getIntent().getStringExtra("PalabraEsp");

        if (palabraEsp != null) {
            traductorViewModel.Palabra(palabraEsp);
        }

        traductorViewModel.getPalabraTraducida().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.etIngles.setText(s);
            }
        });

        traductorViewModel.getImagen().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer img) {
                binding.ivImagen.setImageResource(img);
            }
        });

        binding.btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PalabraActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        }
    }