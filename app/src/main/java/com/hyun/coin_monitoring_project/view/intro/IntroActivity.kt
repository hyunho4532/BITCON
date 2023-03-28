package com.hyun.coin_monitoring_project.view.intro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.hyun.coin_monitoring_project.R


// 스플래시 화면 만들기
// handler -> 3초 뒤에 다른 액티비티로 이동

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
    }
}