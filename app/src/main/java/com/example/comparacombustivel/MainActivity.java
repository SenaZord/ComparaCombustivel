package com.example.comparacombustivel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
    }

    public void calcular(View view) {
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        boolean dadosValidados = validarDados(precoAlcool, precoGasolina);
        if(dadosValidados){

            double valorAlcool = Double.parseDouble(precoAlcool);
            double valorGasolina = Double.parseDouble((precoGasolina));

            Double resultado = valorAlcool / valorGasolina;
            if(resultado >= 0.7){
                textResultado.setText("Gasolina seria a melhor opção");
            }
            else if (resultado == 0){
                textResultado.setText("Nenhuma diferença encontrada");
            }
            else{
                textResultado.setText(("Alcool seria a melhor opção"));
            }
        }
    }

    public boolean validarDados(String pAlcool, String pGasolina){

        Boolean dadosValidados = true;
        if(pAlcool == null || pAlcool.equals("")){
            dadosValidados = false;
        }
        else if (pGasolina == null || pGasolina.equals("")){
            dadosValidados = false;
        }

        return dadosValidados;
    }
}