package com.luxstudios.callcat

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds;
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {



    val mp = MediaPlayer();
    var mMediaPlayer: MediaPlayer? = null
    lateinit var mAdView : AdView

    // 1. Plays the water sound
    fun playSound(view: View) {
        if (mMediaPlayer == null) {
            mMediaPlayer = MediaPlayer.create(this, R.raw.sonidogato)
            mMediaPlayer!!.isLooping = true
            mMediaPlayer!!.start()
        } else mMediaPlayer!!.start()
    }

    // 2. Pause playback
    fun pauseSound(view: View) {
        if (mMediaPlayer != null && mMediaPlayer!!.isPlaying) mMediaPlayer!!.pause()
    }

    // 3. {optional} Stops playback
    fun stopSound(view: View) {
        if (mMediaPlayer != null) {
            mMediaPlayer!!.stop()
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }

    // 4. Closes the MediaPlayer when the app is closed
    override fun onStop() {
        super.onStop()
        if (mMediaPlayer != null) {
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this,getString(R.string.admob_app_id))
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        val adView = AdView(this)
        adView.adSize = AdSize.BANNER
        adView.adUnitId = "ca-app-pub-1174926561998110/6432849085"




    }
}
