package com.example.calculadora;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;

public class ConversorActivity extends AppCompatActivity {

    String texto, actualizarTexto;
    int numeroNuevo;
    Spinner spnConvertirDato, spnConvertirTiempo, spnConvertirLongitud, spnDatoConvertido, spnTiempoConvertido, spnLongitudConvertido;
    LinearLayout layoutDatos, layoutTiempo, layoutLongitud, listaDatos, listaTiempo, listaLongitud;
    TextView btnDatos, btnTiempo, btnLongitud, operarDato, resultadoDato, operarTiempo, resultadoTiempo, operarLongitud, resultadoLongitud;
    Button botonC, botonCero, botonUno, botonDos, botonTres, botonCuatro, botonCinco, botonSeis, botonSiete, botonOcho, botonNueve, botonPunto;
    ImageView botonEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor);


        spnConvertirDato = findViewById(R.id.SpnConvertirDato);
        spnConvertirTiempo = findViewById(R.id.SpnConvertirTiempo);
        spnConvertirLongitud = findViewById(R.id.SpnConvertirLongitud);

        spnDatoConvertido = findViewById(R.id.SpnDatoConvertido);
        spnTiempoConvertido = findViewById(R.id.SpnTiempoConvertido);
        spnLongitudConvertido = findViewById(R.id.SpnLongitudConvertido);

        String[] convertirDato = {"KB", "MB", "GB"};
        String[] convertirTiempo = {"seg", "min", "hr"};
        String[] convertirLongitud = {"cm", "km", "mi"};

        String[] datoConvertido = {"KB", "MB", "GB"};
        String[] tiempoConvertido = {"seg", "min", "hr"};
        String[] longitudConvertido = {"cm", "km", "mi"};

        ArrayAdapter<String> adapterConvDato = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, convertirDato);
        spnConvertirDato.setAdapter(adapterConvDato);
        ArrayAdapter<String> adapterConvTiempo = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, convertirTiempo);
        spnConvertirTiempo.setAdapter(adapterConvTiempo);
        ArrayAdapter<String> adapterConvLongitud = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, convertirLongitud);
        spnConvertirLongitud.setAdapter(adapterConvLongitud);

        ArrayAdapter<String> adapterDatoConv = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, datoConvertido);
        spnDatoConvertido.setAdapter(adapterDatoConv);
        ArrayAdapter<String> adapterTiempoConv = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tiempoConvertido);
        spnTiempoConvertido.setAdapter(adapterTiempoConv);
        ArrayAdapter<String> adapterLongitudConv = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, longitudConvertido);
        spnLongitudConvertido.setAdapter(adapterLongitudConv);


        layoutDatos = findViewById(R.id.LayoutDatos);
        layoutTiempo = findViewById(R.id.LayoutTiempo);
        layoutLongitud = findViewById(R.id.LayoutLongitud);

        listaDatos = findViewById(R.id.ListaDatos);
        listaTiempo = findViewById(R.id.ListaTiempo);
        listaLongitud = findViewById(R.id.ListaLongitud);

        btnDatos = findViewById(R.id.BtnDatos);
        btnTiempo = findViewById(R.id.BtnTiempo);
        btnLongitud = findViewById(R.id.BtnLongitud);

        layoutDatos.setVisibility(View.GONE);
        layoutTiempo.setVisibility(View.GONE);
        layoutLongitud.setVisibility(View.GONE);

        listaDatos.setVisibility(View.GONE);
        listaTiempo.setVisibility(View.GONE);
        listaLongitud.setVisibility(View.GONE);

        btnDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutDatos.setVisibility(View.VISIBLE);
                layoutTiempo.setVisibility(View.GONE);
                layoutLongitud.setVisibility(View.GONE);

                listaDatos.setVisibility(View.VISIBLE);
                listaTiempo.setVisibility(View.GONE);
                listaLongitud.setVisibility(View.GONE);

                btnDatos.setBackgroundColor(Color.parseColor("#c7b560"));
                btnLongitud.setBackgroundColor(Color.parseColor("#222222"));
                btnTiempo.setBackgroundColor(Color.parseColor("#222222"));
            }
        });

        btnTiempo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutDatos.setVisibility(View.GONE);
                layoutTiempo.setVisibility(View.VISIBLE);
                layoutLongitud.setVisibility(View.GONE);

                listaDatos.setVisibility(View.GONE);
                listaTiempo.setVisibility(View.VISIBLE);
                listaLongitud.setVisibility(View.GONE);

                btnDatos.setBackgroundColor(Color.parseColor("#222222"));
                btnLongitud.setBackgroundColor(Color.parseColor("#222222"));
                btnTiempo.setBackgroundColor(Color.parseColor("#c7b560"));
            }
        });

        btnLongitud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutDatos.setVisibility(View.GONE);
                layoutTiempo.setVisibility(View.GONE);
                layoutLongitud.setVisibility(View.VISIBLE);

                listaDatos.setVisibility(View.GONE);
                listaTiempo.setVisibility(View.GONE);
                listaLongitud.setVisibility(View.VISIBLE);

                btnDatos.setBackgroundColor(Color.parseColor("#222222"));
                btnLongitud.setBackgroundColor(Color.parseColor("#c7b560"));
                btnTiempo.setBackgroundColor(Color.parseColor("#222222"));
            }
        });

        operarDato = findViewById(R.id.TxtDatos);
        resultadoDato = findViewById(R.id.TxtResultadoDatos);
        operarTiempo = findViewById(R.id.TxtTiempo);
        resultadoTiempo = findViewById(R.id.TxtResultadoTiempo);
        operarLongitud = findViewById(R.id.TxtLongitud);
        resultadoLongitud = findViewById(R.id.TxtResultadoLongitud);

        botonC = findViewById(R.id.BtnCCon);
        botonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layoutDatos.getVisibility() == View.VISIBLE) {
                    operarDato.setText("");
                    resultadoDato.setText("");
                } else if (layoutTiempo.getVisibility() == View.VISIBLE) {
                    operarTiempo.setText("");
                    resultadoTiempo.setText("");
                } else if (layoutLongitud.getVisibility() == View.VISIBLE) {
                    operarLongitud.setText("");
                    resultadoLongitud.setText("");
                }
            }
        });

        botonEliminar = findViewById(R.id.BtnEliminarCon);
        botonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layoutDatos.getVisibility() == View.VISIBLE) {
                    texto = operarDato.getText().toString();
                    if (!texto.isEmpty()) {
                        actualizarTexto = texto.substring(0, texto.length() - 1);
                        operarDato.setText(actualizarTexto);
                        resultadoDato.setText("");
                    }
                } else if (layoutTiempo.getVisibility() == View.VISIBLE) {
                    texto = operarTiempo.getText().toString();
                    if (!texto.isEmpty()) {
                        actualizarTexto = texto.substring(0, texto.length() - 1);
                        operarTiempo.setText(actualizarTexto);
                        resultadoTiempo.setText("");
                    }
                } else if (layoutLongitud.getVisibility() == View.VISIBLE) {
                    texto = operarLongitud.getText().toString();
                    if (!texto.isEmpty()) {
                        actualizarTexto = texto.substring(0, texto.length() - 1);
                        operarLongitud.setText(actualizarTexto);
                        resultadoLongitud.setText("");
                    }
                }
            }
        });

        botonCero = findViewById(R.id.BtnCeroCon);
        botonCero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layoutDatos.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 0;
                    texto = operarDato.getText().toString() + String.valueOf(numeroNuevo);
                    operarDato.setText(texto);
                } else if (layoutTiempo.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 0;
                    texto = operarTiempo.getText().toString() + String.valueOf(numeroNuevo);
                    operarTiempo.setText(texto);
                } else if (layoutLongitud.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 0;
                    texto = operarLongitud.getText().toString() + String.valueOf(numeroNuevo);
                    operarLongitud.setText(texto);
                }
            }
        });

        botonUno = findViewById(R.id.BtnUnoCon);
        botonUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layoutDatos.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 1;
                    texto = operarDato.getText().toString() + String.valueOf(numeroNuevo);
                    operarDato.setText(texto);
                } else if (layoutTiempo.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 1;
                    texto = operarTiempo.getText().toString() + String.valueOf(numeroNuevo);
                    operarTiempo.setText(texto);
                } else if (layoutLongitud.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 1;
                    texto = operarLongitud.getText().toString() + String.valueOf(numeroNuevo);
                    operarLongitud.setText(texto);
                }
            }
        });

        botonDos = findViewById(R.id.BtnDosCon);
        botonDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layoutDatos.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 2;
                    texto = operarDato.getText().toString() + String.valueOf(numeroNuevo);
                    operarDato.setText(texto);
                } else if (layoutTiempo.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 2;
                    texto = operarTiempo.getText().toString() + String.valueOf(numeroNuevo);
                    operarTiempo.setText(texto);
                } else if (layoutLongitud.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 2;
                    texto = operarLongitud.getText().toString() + String.valueOf(numeroNuevo);
                    operarLongitud.setText(texto);
                }
            }
        });

        botonTres = findViewById(R.id.BtnTresCon);
        botonTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layoutDatos.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 3;
                    texto = operarDato.getText().toString() + String.valueOf(numeroNuevo);
                    operarDato.setText(texto);
                } else if (layoutTiempo.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 3;
                    texto = operarTiempo.getText().toString() + String.valueOf(numeroNuevo);
                    operarTiempo.setText(texto);
                } else if (layoutLongitud.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 3;
                    texto = operarLongitud.getText().toString() + String.valueOf(numeroNuevo);
                    operarLongitud.setText(texto);
                }
            }
        });

        botonCuatro = findViewById(R.id.BtnCuatroCon);
        botonCuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layoutDatos.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 4;
                    texto = operarDato.getText().toString() + String.valueOf(numeroNuevo);
                    operarDato.setText(texto);
                } else if (layoutTiempo.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 4;
                    texto = operarTiempo.getText().toString() + String.valueOf(numeroNuevo);
                    operarTiempo.setText(texto);
                } else if (layoutLongitud.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 4;
                    texto = operarLongitud.getText().toString() + String.valueOf(numeroNuevo);
                    operarLongitud.setText(texto);
                }
            }
        });

        botonCinco = findViewById(R.id.BtnCincoCon);
        botonCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layoutDatos.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 5;
                    texto = operarDato.getText().toString() + String.valueOf(numeroNuevo);
                    operarDato.setText(texto);
                } else if (layoutTiempo.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 5;
                    texto = operarTiempo.getText().toString() + String.valueOf(numeroNuevo);
                    operarTiempo.setText(texto);
                } else if (layoutLongitud.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 5;
                    texto = operarLongitud.getText().toString() + String.valueOf(numeroNuevo);
                    operarLongitud.setText(texto);
                }
            }
        });

        botonSeis = findViewById(R.id.BtnSeisCon);
        botonSeis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layoutDatos.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 6;
                    texto = operarDato.getText().toString() + String.valueOf(numeroNuevo);
                    operarDato.setText(texto);
                } else if (layoutTiempo.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 6;
                    texto = operarTiempo.getText().toString() + String.valueOf(numeroNuevo);
                    operarTiempo.setText(texto);
                } else if (layoutLongitud.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 6;
                    texto = operarLongitud.getText().toString() + String.valueOf(numeroNuevo);
                    operarLongitud.setText(texto);
                }
            }
        });

        botonSiete = findViewById(R.id.BtnSieteCon);
        botonSiete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layoutDatos.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 7;
                    texto = operarDato.getText().toString() + String.valueOf(numeroNuevo);
                    operarDato.setText(texto);
                } else if (layoutTiempo.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 7;
                    texto = operarTiempo.getText().toString() + String.valueOf(numeroNuevo);
                    operarTiempo.setText(texto);
                } else if (layoutLongitud.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 7;
                    texto = operarLongitud.getText().toString() + String.valueOf(numeroNuevo);
                    operarLongitud.setText(texto);
                }
            }
        });

        botonOcho = findViewById(R.id.BtnOchoCon);
        botonOcho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layoutDatos.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 8;
                    texto = operarDato.getText().toString() + String.valueOf(numeroNuevo);
                    operarDato.setText(texto);
                } else if (layoutTiempo.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 8;
                    texto = operarTiempo.getText().toString() + String.valueOf(numeroNuevo);
                    operarTiempo.setText(texto);
                } else if (layoutLongitud.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 8;
                    texto = operarLongitud.getText().toString() + String.valueOf(numeroNuevo);
                    operarLongitud.setText(texto);
                }
            }
        });

        botonNueve = findViewById(R.id.BtnNueveCon);
        botonNueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layoutDatos.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 9;
                    texto = operarDato.getText().toString() + String.valueOf(numeroNuevo);
                    operarDato.setText(texto);
                } else if (layoutTiempo.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 9;
                    texto = operarTiempo.getText().toString() + String.valueOf(numeroNuevo);
                    operarTiempo.setText(texto);
                } else if (layoutLongitud.getVisibility() == View.VISIBLE) {
                    numeroNuevo = 9;
                    texto = operarLongitud.getText().toString() + String.valueOf(numeroNuevo);
                    operarLongitud.setText(texto);
                }
            }
        });

        botonPunto = findViewById(R.id.BtnPuntoCon);
        botonPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layoutDatos.getVisibility() == View.VISIBLE) {
                    texto = operarDato.getText().toString() + ".";
                    operarDato.setText(texto);
                } else if (layoutTiempo.getVisibility() == View.VISIBLE) {
                    texto = operarTiempo.getText().toString() + ".";
                    operarTiempo.setText(texto);
                } else if (layoutLongitud.getVisibility() == View.VISIBLE) {
                    texto = operarLongitud.getText().toString() + ".";
                    operarLongitud.setText(texto);
                }
            }
        });

        spnConvertirDato.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calcularDato(); }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        }); spnDatoConvertido.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calcularDato(); }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });


        spnConvertirTiempo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calcularTiempo(); }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        }); spnTiempoConvertido.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calcularTiempo(); }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });


        spnConvertirLongitud.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calcularLongitud(); }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        }); spnLongitudConvertido.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calcularLongitud(); }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }

    private void calcularDato() {
        if (operarDato.getText().toString().isEmpty()) {
            resultadoDato.setText("");
            return;
        }
        double valorInicial = Double.parseDouble(operarDato.getText().toString());
        double valorFinal = 0.0;
        String spinnerInicial = spnConvertirDato.getSelectedItem().toString();
        String spinnerFinal = spnDatoConvertido.getSelectedItem().toString();
        if (spinnerInicial.equals("KB")) {
            if (spinnerFinal.equals("MB")) {
                valorFinal = valorInicial / 1024;
            } else if (spinnerFinal.equals("GB")) {
                valorFinal = valorInicial / (1024 * 1024);
            } else {
                valorFinal = valorInicial;
            }
        } else if (spinnerInicial.equals("MB")) {
            if (spinnerFinal.equals("KB")) {
                valorFinal = valorInicial * 1024;
            } else if (spinnerFinal.equals("GB")) {
                valorFinal = valorInicial / 1024;
            } else {
                valorFinal = valorInicial;
            }
        } else if (spinnerInicial.equals("GB")) {
            if (spinnerFinal.equals("KB")) {
                valorFinal = valorInicial * 1024 * 1024;
            } else if (spinnerFinal.equals("MB")) {
                valorFinal = valorInicial * 1024;
            } else {
                valorFinal = valorInicial;
            }
        }
        resultadoDato.setText(String.valueOf(valorFinal));
    }

    private void calcularTiempo() {
        if (operarTiempo.getText().toString().isEmpty()) {
            resultadoTiempo.setText("");
            return;
        }
        double valorInicial = Double.parseDouble(operarTiempo.getText().toString());
        double valorFinal = 0.0;
        String spinnerInicial = spnConvertirTiempo.getSelectedItem().toString();
        String spinnerFinal = spnTiempoConvertido.getSelectedItem().toString();
        if (spinnerInicial.equals("seg")) {
            if (spinnerFinal.equals("min")) {
                valorFinal = valorInicial / 60;
            } else if (spinnerFinal.equals("hr")) {
                valorFinal = valorInicial / 3600;
            } else {
                valorFinal = valorInicial;
            }
        } else if (spinnerInicial.equals("min")) {
            if (spinnerFinal.equals("seg")) {
                valorFinal = valorInicial * 60;
            } else if (spinnerFinal.equals("hr")) {
                valorFinal = valorInicial / 60;
            } else {
                valorFinal = valorInicial;
            }
        } else if (spinnerInicial.equals("hr")) {
            if (spinnerFinal.equals("seg")) {
                valorFinal = valorInicial * 3600;
            } else if (spinnerFinal.equals("min")) {
                valorFinal = valorInicial * 60;
            } else {
                valorFinal = valorInicial;
            }
        }
        resultadoTiempo.setText(String.valueOf(valorFinal));
    }

    private void calcularLongitud() {
        if (operarLongitud.getText().toString().isEmpty()) {
            resultadoLongitud.setText("");
            return;
        }
        double valorInicial = Double.parseDouble(operarLongitud.getText().toString());
        double valorFinal = 0.0;
        String spinnerInicial = spnConvertirLongitud.getSelectedItem().toString();
        String spinnerFinal = spnLongitudConvertido.getSelectedItem().toString();
        if (spinnerInicial.equals("cm")) {
            if (spinnerFinal.equals("km")) {
                valorFinal = valorInicial / 100000;
            } else if (spinnerFinal.equals("mi")) {
                valorFinal = valorInicial / 160934.4;
            } else {
                valorFinal = valorInicial;
            }
        } else if (spinnerInicial.equals("km")) {
            if (spinnerFinal.equals("cm")) {
                valorFinal = valorInicial * 100000;
            } else if (spinnerFinal.equals("mi")) {
                valorFinal = valorInicial / 1.60934;
            } else {
                valorFinal = valorInicial;
            }
        } else if (spinnerInicial.equals("mi")) {
            if (spinnerFinal.equals("cm")) {
                valorFinal = valorInicial * 160934.4;
            } else if (spinnerFinal.equals("km")) {
                valorFinal = valorInicial * 1.60934;
            } else {
                valorFinal = valorInicial;
            }
        }
        resultadoLongitud.setText(String.valueOf(valorFinal));
    }

        }

