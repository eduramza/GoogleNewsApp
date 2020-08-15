package com.eduramza.googlenewsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eduramza.googlenewsapp.ui.home.HomeFragment

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment.newInstance())
                .commitNow()
        }
    }
}