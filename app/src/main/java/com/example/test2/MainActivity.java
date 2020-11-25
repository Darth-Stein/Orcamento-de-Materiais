package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calButton = (Button) findViewById(R.id.calc_button);

        calButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                try{
                    EditText altura_parede = (EditText) findViewById(R.id.RParede);
                    double altura = Double.parseDouble(altura_parede.getText().toString());

                    EditText largura_parede = (EditText) findViewById(R.id.LParede);
                    double largura = Double.parseDouble(largura_parede.getText().toString());

                    RadioGroup QTD_Furos = (RadioGroup) findViewById(R.id.QTDfuros);
                    RadioGroup QTD_Tamanho = (RadioGroup) findViewById(R.id.QTDtamanho);
                    int radio_FuroSelected = QTD_Furos.getCheckedRadioButtonId();
                    int radio_TamanhoSelected = QTD_Tamanho.getCheckedRadioButtonId();

                    TextView quanTijolo = (TextView) findViewById(R.id.quant_tijolo);
                    TextView orcTijolo = (TextView) findViewById(R.id.orc_tijolo);
                    TextView quantArgamassa = (TextView) findViewById(R.id.quant_argamassa);
                    TextView orcArgamassa = (TextView) findViewById(R.id.orc_argamassa);
                    TextView orcTotal = (TextView) findViewById(R.id.orc_total);

                    if (radio_FuroSelected != 1 && radio_TamanhoSelected != 1) {

                        RadioButton furoSelected = findViewById(radio_FuroSelected);
                        RadioButton tamanhoSelected = findViewById(radio_TamanhoSelected);
                        String furos = furoSelected.getText().toString();
                        String tamanho = tamanhoSelected.getText().toString();

                        Values values = new Values(altura, largura, furos, tamanho);

                        values.setPrecTIJ();
                        values.setAltTij();
                        values.setLargTij();

                        values.setQuantitativo();
                        values.setArgamassa();
                        values.setOrcamentotij();
                        values.setOrcamentoarg();
                        values.setOrcTotal();

                        DecimalFormat df = new DecimalFormat("0.000");
                        DecimalFormat df2 = new DecimalFormat("0.00");

                        quanTijolo.setText(Math.round(values.getQuantitativo()) + " unidades");
                        orcTijolo.setText( "R$ " + df2.format(values.getOrcamentotij()) + "");
                        quantArgamassa.setText(df.format(values.getArgamassa()) + " m³");
                        orcArgamassa.setText("R$ " + df2.format(values.getOrcamentoarg()) + "");
                        orcTotal.setText("R$ " + df2.format(values.getOrcTotal()) + "");

                    }
                }catch(Exception e){

                }
            }

        });
    }
}
