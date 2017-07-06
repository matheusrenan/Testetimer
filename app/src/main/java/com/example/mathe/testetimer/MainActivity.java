package com.example.mathe.testetimer;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    private Timer timerAtual = new Timer();
    private TimerTask task;
    private final Handler handler = new Handler();


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ativaTimer();
    }

    private void ativaTimer() {
        task = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        try {
                            mudalayout();
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        };

        timerAtual.schedule(task, 1000 * 60, 40000);
    }

    private void mudalayout() throws ParseException {
        TextView txtEventoAgora = (TextView) findViewById(R.id.lbl_hora);
        SimpleDateFormat dateFormat_hora = new SimpleDateFormat("HH:mm");
        SimpleDateFormat dateFormat_dia = new SimpleDateFormat("dd:MM");
        Date data = new Date();
        Calendar  cal = Calendar.getInstance();
        cal.setTime(data);
        Date data_atual = cal.getTime();
        String hora_atual = dateFormat_hora.format(data_atual);
        String dia_atual = dateFormat_dia.format(data_atual);
        String horacerta = hora_atual;
        horacerta = horacerta.replace(":", "");
        String diacerto = dia_atual;
        diacerto = dia_atual.replace(":", "");
        int dia = Integer.parseInt(diacerto);
        int hora = Integer.parseInt(horacerta);
        if (dia == 2808) { // Implementar eventos do dia 28/08

        }
        else if (dia == 2908) { // Implementar eventos do dia 29/08

        }
        else if (dia == 3008) { // Implementar eventos do dia 30/08

        }

    }
}
