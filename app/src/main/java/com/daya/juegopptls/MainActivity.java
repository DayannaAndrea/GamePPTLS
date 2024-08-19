package com.daya.juegopptls;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button  btnReiniciar,btnPiedra, btnPapel, btnTijera, btnLagarto, btnSpock;
    TextView txtUsuario, txtCPU, txtGanados, txtPerdidos, txtEmpatados, txtGanador, txtInformacion;
    PPTLS pptls;
    int n=0, ganados=0, perdidos=0, empatados=0;
    String opciones[] = {"Piedra", "Papel", "Tijeras" ,"Lagarto", "Spock"};
    String result[] = {"Empate","Perdidos","Ganados"};
    String informacion[][] =
            {
                    {"Iguales.", "Piedra es cubierto por papel.", "Piedra aplasta tijeras.", "Piedra aplasta a lagarto.", "Spock vaporiza la piedra."},
                    {"Papel cubre a piedra.", "Iguales.", "Papel es cortado por la tijera.", "Papel es comido por el lagarto.","Papel desautoriza a Spock."},
                    {"Tijera es aplastada por piedra", "Tijera corta papel", "Iguales", "Tijera decapita a Lagarto", "Tijeras es destrozada por spock"},
                    {"Lagarto es aplastado por la piedra.", "Largarto se come a papel", "Lagarto es decapitado por la tijera.", "Iguales", "Lagarto envenena a Spock"},
                    {"Spock vaporiza la piedra", "Spock es desautorizado por papel", "Spock destroza las tijeras", "Spock es envenenado por lagarto", "Iguales"}
            };
    int partidas[][] =
            {
                    {0,1,2,2,1},
                    {2,0,1,1,2},
                    {1,2,0,2,1},
                    {1,2,1,0,2},
                    {2,1,2,1,0}
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReiniciar=findViewById(R.id.btnReiniciar);
        btnPiedra=findViewById(R.id.btnPiedra);
        btnPapel=findViewById(R.id.btnPapel);
        btnTijera=findViewById(R.id.btnTijera);
        btnLagarto=findViewById(R.id.btnLagarto);
        btnSpock=findViewById(R.id.btnSpock);
        txtUsuario=findViewById(R.id.txtUsuario);
        txtCPU=findViewById(R.id.txtCPU);
        txtGanados=findViewById(R.id.txtGanados);
        txtPerdidos=findViewById(R.id.txtPerdidos);
        txtEmpatados=findViewById(R.id.txtEmpatados);
        txtGanador=findViewById(R.id.txtGanador);
        txtInformacion=findViewById(R.id.txtInformacion);

        pptls = new PPTLS();
    }

    public void jugar(){
        int cpu = pptls.CpuTurno();
        int resultado = partidas[n][cpu];
        txtUsuario.setText("Tu seleccion: " + opciones[n]);
        txtCPU.setText("CPU: " + opciones[cpu]);
        txtInformacion.setText(informacion[n][cpu]);
        txtGanador.setText(result[resultado]);

        switch (result[resultado]){
            case "Empate":
                empatados++;
                txtEmpatados.setText("Empate: " + empatados);
                break;

            case "Perdidos":
                perdidos++;
                txtPerdidos.setText("Perdidos: " + perdidos);
                break;

            case "Ganados":
                ganados++;
                txtGanados.setText("Ganados: "+ ganados);
                break;
        }
    }

    public void piedra(View v){
        n=0;
        jugar();
    }
    public void papel(View v){
        n=1;
        jugar();
    }
    public void tijeras(View v){
        n=2;
        jugar();
    }
    public void lagarto(View v){
        n=3;
        jugar();
    }
    public void spock(View v){
        n=4;
        jugar();
    }

    public void reiniciar(View v){
        n=0;
        ganados=0;
        perdidos=0;
        empatados=0;
        txtInformacion.setText("");
        txtUsuario.setText("Tu seleccion:");
        txtCPU.setText("CPU:");
        txtGanador.setText("");
        txtGanados.setText("Empate: 0");
        txtPerdidos.setText("Perdidos: 0");
        txtEmpatados.setText("Ganados: 0");

    }
}