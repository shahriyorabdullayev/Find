package com.shza.cleanarch2.presentation.activity

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.shza.cleanarch2.R
import com.shza.cleanarch2.presentation.fragment.WelcomeFragment
import kotlin.random.Random



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
//        when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
//            Configuration.UI_MODE_NIGHT_YES -> {
//                application.setTheme(R.style.customtheme)
//            }
//            Configuration.UI_MODE_NIGHT_NO -> {
//                application.setTheme(R.style.customtheme)
//            }
//        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }






}