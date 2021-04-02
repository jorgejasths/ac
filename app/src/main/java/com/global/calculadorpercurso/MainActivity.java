package com.global.calculadorpercurso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtLitro = findViewById(R.id.activity_txt_litro);
        final EditText txtAutonomia = findViewById(R.id.activity_txt_autonomia);
        final EditText txtRota = findViewById(R.id.activity_txt_rota);
        final TextView txvResultado = findViewById(R.id.activity_txv_resultado);


        Button botaoCalcular = findViewById(R.id.activity_btn_calcular);
        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double txtL = Double.parseDouble(txtLitro.getText().toString());
                double txtA = Double.parseDouble(txtAutonomia.getText().toString());
                double txtR = Double.parseDouble(txtRota.getText().toString());

                double valKm = (txtL / txtA);
                double valorFinal = valKm * txtR;

                DecimalFormat df = new DecimalFormat("0.00");
                txvResultado.setText("R$ " + df.format(valorFinal));

            }
        });

        Button botaoNovoCalculo = findViewById(R.id.activity_btn_novo_calculo);
        botaoNovoCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtLitro.setText("");
                txtAutonomia.setText("");
                txtRota.setText("");
                txvResultado.setText("");
            }
        });

    }
}