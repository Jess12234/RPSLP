package com.example.rpsls;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.PrivateKey;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final int ROCK = 0;
    private static final int PAPER = 2;
    private static final int SCISSORS = 4;
    private static final int LIZARD = 3;
    private static final int SPOCK = 1;

    private ImageView iv_cpu;
    private ImageView iv_player;

    private Button rock, paper, scissors, lizard, spock;

    private TextView tv_info;

    private Random r;

    private int playedCPU, playedPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        iv_cpu = (ImageView) findViewById(R.id.iv_cpu);
        iv_player = (ImageView) findViewById(R.id.iv_player);


        rock = (Button) findViewById(R.id.rock);
        paper = (Button) findViewById(R.id.paper);
        scissors = (Button) findViewById(R.id.scissors);
        lizard = (Button) findViewById(R.id.lizard);
        spock = (Button) findViewById(R.id.spock);

        tv_info = (TextView) findViewById(R.id.tv_info);

        r = new Random();

        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playedPlayer = ROCK;
                playedCPU = r.nextInt(5);
                setImage(playedPlayer,playedCPU);
                tv_info.setText(getWinnerText(getWinner(playedPlayer,playedCPU)));

            }
        });


        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playedPlayer = PAPER;
                playedCPU = r.nextInt(5);
                setImage(playedPlayer,playedCPU);
                tv_info.setText(getWinnerText(getWinner(playedPlayer,playedCPU)));

            }
        });

        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playedPlayer = SCISSORS;
                playedCPU = r.nextInt(5);
                setImage(playedPlayer,playedCPU);
                tv_info.setText(getWinnerText(getWinner(playedPlayer,playedCPU)));

            }
        });

        lizard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playedPlayer = LIZARD;
                playedCPU = r.nextInt(5);
                setImage(playedPlayer,playedCPU);
                tv_info.setText(getWinnerText(getWinner(playedPlayer,playedCPU)));

            }
        });

        spock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer Live= MediaPlayer.create(MainActivity.this,R.raw.live);

                Live.start();

                playedPlayer = SPOCK;
                playedCPU = r.nextInt(5);
                setImage(playedPlayer,playedCPU);
                tv_info.setText(getWinnerText(getWinner(playedPlayer,playedCPU)));
            }
        });
    }

    private int getWinner (int A, int B)
    {
        return A == B ? 0 : (A - B + 5) % 5 <= 2 ? 1 : -1;

    }

    private String getWinnerText (int result)
    {
        switch (result)
        {
            case 1:
                return "You WIN!";
            case -1:
                return "You LOSE!";
            case 0:
                return "Draw";
            default:
                return "";
        }
    }

    private void setImage(int A, int B)
    {
        switch (A){
            case ROCK:
                iv_player.setImageResource(R.drawable.rock);
                break;
            case PAPER:
                iv_player.setImageResource(R.drawable.paper);
                break;
            case SCISSORS:
                iv_player.setImageResource(R.drawable.scissors);
                break;
            case LIZARD:
                iv_player.setImageResource(R.drawable.lizz);
                break;
            case SPOCK:
                iv_player.setImageResource(R.drawable.spock);
                break;
        }

        switch (B){
            case ROCK:
                iv_cpu.setImageResource(R.drawable.rock);
                break;
            case PAPER:
                iv_cpu.setImageResource(R.drawable.paper);
                break;
            case SCISSORS:
                iv_cpu.setImageResource(R.drawable.scissors);
                break;
            case LIZARD:
                iv_cpu.setImageResource(R.drawable.lizz);
                break;
            case SPOCK:
                iv_cpu.setImageResource(R.drawable.spock);
                break;
        }
    }

}
