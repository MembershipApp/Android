package com.infostretch.isos;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.video);
		VideoView myVideoView = (VideoView) findViewById(R.id.myvideoview);
		String uri = "android.resource://" + getPackageName() + "/"
				+ R.raw.movie;
		myVideoView.setVideoURI(Uri.parse(uri));
		myVideoView.setMediaController(new MediaController(this));
		myVideoView.requestFocus();
		myVideoView.start();
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		this.startActivity(new Intent(VideoPlayer.this, ISOSMainActivity.class));
	}
}
