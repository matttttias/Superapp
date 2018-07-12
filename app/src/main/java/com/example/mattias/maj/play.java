package com.example.mattias.maj;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class play extends AppCompatActivity{


  private Button btn_play, btn_pause;
  private SeekBar seekBar;
  private MediaPlayer mediaPlayer;
  private Runnable runnable;
  private Handler handler;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);

        btn_play = findViewById(R.id.btn_play);
        btn_pause = findViewById(R.id.btn_pause);
        handler = new Handler();
        mediaPlayer = MediaPlayer.create(this, android.R.raw.play);
        seekBar = findViewById(R.id.seekBar);

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                seekBar.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekbar();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (b){
                    mediaPlayer.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void changeSeekbar() {
        seekBar.setProgress(mediaPlayer.getCurrentPosition());

        if(mediaPlayer.isPlaying()){
            runnable = new Runnable() {
                @Override
                public void run() {
                    changeSeekbar();
                }
            };
            handler.postDelayed(runnable, 1000);
        }


    }

}
