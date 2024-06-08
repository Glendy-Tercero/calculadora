package com.example.calculadora;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int numeroNuevo;
    String texto, actualizarTexto;
    TextView operacion, resultado;
    Button botonCero, botonUno, botonDos, botonTres, botonCuatro, botonCinco, botonSeis, botonSiete, botonOcho, botonNueve, botonSeno, botonCoseno, botonTangente, botonDivision, botonMulti, botonResta, botonSuma, botonIgual, botonRaiz, botonPunto;
    ImageView botonConversor, botonC, botonEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.CalculadoraView), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        operacion = findViewById(R.id.TxtOperacion);
        resultado = findViewById(R.id.TxtResultado);

        botonConversor = findViewById(R.id.BtnConversor);
        botonConversor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConversorActivity.class);
                startActivity(intent);
            }
        });

        botonC = findViewById(R.id.BtnC);
        botonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion.setText("");
                resultado.setText("");
            }
        });

        botonEliminar = findViewById(R.id.BtnEliminar);
        botonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto = operacion.getText().toString();
                if (!texto.isEmpty()) {
                    actualizarTexto = texto.substring(0, texto.length() - 1);
                    operacion.setText(actualizarTexto);
                    resultado.setText("");
                }
            }
        });

        botonSeno = findViewById(R.id.BtnSin);
        botonSeno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto = operacion.getText().toString() + "sin(";
                operacion.setText(texto);
            }
        });

        botonCoseno = findViewById(R.id.BtnCos);
        botonCoseno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto = operacion.getText().toString() + "cos(";
                operacion.setText(texto);
            }
        });

        botonTangente = findViewById(R.id.BtnTan);
        botonTangente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto = operacion.getText().toString() + "tan(";
                operacion.setText(texto);
            }
        });

        botonDivision = findViewById(R.id.BtnDivision);
        botonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto = operacion.getText().toString() + "÷";
                operacion.setText(texto);
            }
        });

        botonMulti = findViewById(R.id.BtnMultiplicacion);
        botonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto = operacion.getText().toString() + "×";
                operacion.setText(texto);
            }
        });

        botonResta = findViewById(R.id.BtnResta);
        botonResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto = operacion.getText().toString() + "−";
                operacion.setText(texto);
            }
        });

        botonSuma = findViewById(R.id.BtnSuma);
        botonSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto = operacion.getText().toString() + "+";
                operacion.setText(texto);
            }
        });

        botonPunto = findViewById(R.id.BtnPunto);
        botonPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto = operacion.getText().toString() + ".";
                operacion.setText(texto);
            }
        });

        botonIgual = findViewById(R.id.BtnIgual);
        botonIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoOperacion = operacion.getText().toString();
                double resultadoOperacion = evaluarOperacion(textoOperacion);
                resultado.setText(String.valueOf(resultadoOperacion));
            }
        });

        botonRaiz = findViewById(R.id.BtnRaiz);
        botonRaiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto = operacion.getText().toString() + "√";
                operacion.setText(texto);
            }
        });

        botonCero = findViewById(R.id.BtnCero);
        botonCero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numeroNuevo = 0;
                texto = operacion.getText().toString() + String.valueOf(numeroNuevo);
                operacion.setText(texto);
            }
        });

        botonUno = findViewById(R.id.BtnUno);
        botonUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numeroNuevo = 1;
                texto = operacion.getText().toString() + String.valueOf(numeroNuevo);
                operacion.setText(texto);
            }
        });

        botonDos = findViewById(R.id.BtnDos);
        botonDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numeroNuevo = 2;
                texto = operacion.getText().toString() + String.valueOf(numeroNuevo);
                operacion.setText(texto);
            }
        });

        botonTres = findViewById(R.id.BtnTres);
        botonTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numeroNuevo = 3;
                texto = operacion.getText().toString() + String.valueOf(numeroNuevo);
                operacion.setText(texto);
            }
        });

        botonCuatro = findViewById(R.id.BtnCuatro);
        botonCuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numeroNuevo = 4;
                texto = operacion.getText().toString() + String.valueOf(numeroNuevo);
                operacion.setText(texto);
            }
        });

        botonCinco = findViewById(R.id.BtnCinco);
        botonCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numeroNuevo = 5;
                texto = operacion.getText().toString() + String.valueOf(numeroNuevo);
                operacion.setText(texto);
            }
        });

        botonSeis = findViewById(R.id.BtnSeis);
        botonSeis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numeroNuevo = 6;
                texto = operacion.getText().toString() + String.valueOf(numeroNuevo);
                operacion.setText(texto);
            }
        });

        botonSiete = findViewById(R.id.BtnSiete);
        botonSiete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numeroNuevo = 7;
                texto = operacion.getText().toString() + String.valueOf(numeroNuevo);
                operacion.setText(texto);
            }
        });

        botonOcho = findViewById(R.id.BtnOcho);
        botonOcho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numeroNuevo = 8;
                texto = operacion.getText().toString() + String.valueOf(numeroNuevo);
                operacion.setText(texto);
            }
        });

        botonNueve = findViewById(R.id.BtnNueve);
        botonNueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numeroNuevo = 9;
                texto = operacion.getText().toString() + String.valueOf(numeroNuevo);
                operacion.setText(texto);
            }
        });
    }

    public double evaluarOperacion(String operacion) {
        List<Double> numeros = new ArrayList<>();
        List<Character> operadores = new ArrayList<>();
        StringBuilder textoActual = new StringBuilder();
        for (int i = 0; i < operacion.length(); i++) {
            char x = operacion.charAt(i);
            if (Character.isDigit(x) || x == '.') {
                textoActual.append(x);
            } else if (x == 's' || x == 'c' || x == 't' || x == '√') {
                int endIdx = i + (x == '√' ? 1 : 4);
                while (endIdx < operacion.length() && (Character.isDigit(operacion.charAt(endIdx)) || operacion.charAt(endIdx) == '.')) {
                    endIdx++;
                }
                double valor = Double.parseDouble(operacion.substring(i + (x == '√' ? 1 : 4), endIdx));
                double resultado = 0;
                switch (x) {
                    case 's':
                        resultado = Math.sin(Math.toRadians(valor));
                        break;
                    case 'c':
                        resultado = Math.cos(Math.toRadians(valor));
                        break;
                    case 't':
                        resultado = Math.tan(Math.toRadians(valor));
                        break;
                    case '√':
                        resultado = Math.sqrt(valor);
                        break;
                }
                numeros.add(resultado);
                i = endIdx - 1;
            } else {
                if (textoActual.length() > 0) {
                    numeros.add(Double.parseDouble(textoActual.toString()));
                    textoActual.setLength(0);
                }
                operadores.add(x);
            }
        }
        if (textoActual.length() > 0) {
            numeros.add(Double.parseDouble(textoActual.toString()));
        }
        if (numeros.size() >= 2 && operadores.size() >= 1) {
            double primerNumero = numeros.get(0);
            double segundoNumero = numeros.get(1);
            char operador = operadores.get(0);
            double resultado = 0;
            switch (operador) {
                case '+':
                    resultado = primerNumero + segundoNumero;
                    break;
                case '−':
                    resultado = primerNumero - segundoNumero;
                    break;
                case '×':
                    resultado = primerNumero * segundoNumero;
                    break;
                case '÷':
                    resultado = primerNumero / segundoNumero;
                    break;
            }
            return resultado;
        } else if (numeros.size() == 1) {
            return numeros.get(0);
        }
        return 0;
    }
}