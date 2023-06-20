package com.example.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

public class VideoPlayerActivity extends AppCompatActivity {

    private PlayerView videoPlayer;
    private SimpleExoPlayer exoPlayer;
    private static final String FILE_URL = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_video_player);

        videoPlayer = findViewById(R.id.exo_player);
        String url = getIntent().getStringExtra("url");
        if (url != null) {
            setUpExoPlayer(url);
        }
    }

    private void setUpExoPlayer(String url) {
        exoPlayer = new SimpleExoPlayer.Builder(this).build();
        videoPlayer.setPlayer(exoPlayer);

        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this, "user-agent");
        MediaSourceFactory mediaSourceFactory = new ProgressiveMediaSource.Factory(dataSourceFactory);
        MediaSource mediaSource = mediaSourceFactory.createMediaSource(MediaItem.fromUri(Uri.parse(url)));

        exoPlayer.setMediaSource(mediaSource);
        exoPlayer.prepare();
        exoPlayer.setPlayWhenReady(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        exoPlayer.release();
    }
}
