package com.cyn.flickerclient.view

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.cyn.flickerclient.R

class PhotoDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_detail)

    }

    companion object {
        @JvmStatic
        fun newIntent(context: Context): Intent {
            return Intent(context, PhotoDetailActivity::class.java)
        }
    }
}
