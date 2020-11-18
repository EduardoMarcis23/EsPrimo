package com.tallercmovil.esprimo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText etNumero;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumero = findViewById(R.id.etNumero);
        tvResultado = findViewById(R.id.tvResultado);

        etNumero.setTypeface(ResourcesCompat.getFont(this,R.font.bryndanwrite));
    }

    public void clic(View view)
    {
        if(etNumero.getText().toString().equals(""))
        {
            Toast.makeText(this, getResources().getString(R.string.ingresa_valor), Toast.LENGTH_SHORT).show();
            etNumero.setError(getResources().getString(R.string.valor_requerido));
        }

        else
        {
            int numero = Integer.parseInt(etNumero.getText().toString());

            if(esPrimo(numero))
            {
                tvResultado.setText(getResources().getString(R.string.inicio_respuesta)+ numero + getResources().getString(R.string.si_primo));
            }

            else
            {
                tvResultado.setText(getResources().getString(R.string.inicio_respuesta)+ numero + getResources().getString(R.string.no_primo));
            }
        }

    }

    public boolean esPrimo(int numero)
    {
        if(numero < 2)
        {
            return false;
        }

        else
        {
            for(int i=2; i<numero; i++)
            {
                if(numero % i == 0)
                {
                    return false;
                }
            }
        }

        return true;
    }
}