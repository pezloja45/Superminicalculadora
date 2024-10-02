package com.pezloja.superminicalculadora;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText txtNumero1, txtNumero2;
    TextView lblInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtNumero1 = findViewById(R.id.txtNum1);
        txtNumero2 = findViewById(R.id.txtNum2);
        lblInfo = findViewById(R.id.lblInfo);

        Button btnMas = findViewById(R.id.btnMas);
        btnMas.setOnClickListener(v -> hacerCalculo(1));
        Button btnMenos = findViewById(R.id.btnMenos);
        btnMenos.setOnClickListener(v -> hacerCalculo(2));
        Button btnPor = findViewById(R.id.btnPor);
        btnPor.setOnClickListener(v -> hacerCalculo(3));
        Button btnDividir = findViewById(R.id.btnDividir);
        btnDividir.setOnClickListener(v -> hacerCalculo(4));

        Button btnBorrar = findViewById(R.id.btnBorrar);
        btnBorrar.setOnClickListener(v -> borrarCampos());
    }

    public void hacerCalculo(int m) {
        double num1, num2;
        try {
            num1 = Double.parseDouble(txtNumero1.getText().toString());
            num2 = Double.parseDouble(txtNumero2.getText().toString());
        } catch (NumberFormatException e) {
            lblInfo.setText("Entrada no válida");
            return;
        }

        double result;
        switch (m) {
            case 1:
                result = num1 + num2;
                break;
            case 2:
                result = num1 - num2;
                break;
            case 3:
                result = num1 * num2;
                break;
            case 4:
                if (num2 == 0) {
                    lblInfo.setText("No puedes dividir entre 0");
                    return;
                }
                result = num1 / num2;
                break;
            default:
                lblInfo.setText("Error");
                return;
        }
        lblInfo.setText(String.valueOf(result));
    }

    public void borrarCampos() {
            if (txtNumero1 != null) {
                txtNumero1.setText("");
            }
            if (txtNumero2 != null) {
                txtNumero2.setText("");
            }
            if (lblInfo != null) {
                lblInfo.setText("");
            }
    }
}
