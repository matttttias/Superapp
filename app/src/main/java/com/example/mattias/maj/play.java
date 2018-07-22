package com.example.mattias.maj;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class play extends Activity implements View.OnClickListener{

        Button play, pause, stop;
        MediaPlayer mediaPlayer;
        int pauseCurrentPosition;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.play);


                play=(Button) findViewById(R.id.btn_play);
                pause=(Button) findViewById(R.id.btn_pause);
                stop=(Button) findViewById(R.id.btn_stop);

                play.setOnClickListener(this);
                pause.setOnClickListener(this);
                stop.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

                switch (view.getId()){

                        case R.id.btn_play:
                                if (mediaPlayer==null){
                                mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.breathingexercise);
                                mediaPlayer.start();}

                                else if (!mediaPlayer.isPlaying()){
                                        mediaPlayer.seekTo(pauseCurrentPosition);
                                        mediaPlayer.start();
                                }

                                break;

                        case R.id.btn_pause:
                                if (mediaPlayer!=null) {
                                        mediaPlayer.pause();
                                        pauseCurrentPosition=mediaPlayer.getCurrentPosition();

                                }
                                break;

                        case R.id.btn_stop:
                                if (mediaPlayer!=null) {
                                        mediaPlayer.stop();
                                        mediaPlayer = null;
                                }
                                break;

                }
        }
}
