package com.may.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.may.swoosh.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val leagueIntent = Intent(this, LeagueActivity::class.java)
//        getStartedButton.setOnClickListener {
//            startActivity(leagueIntent)
//        }
    }


    override fun onResume() {
        val leagueIntent = Intent(this, LeagueActivity::class.java)
        super.onResume()
        Handler().postDelayed({
            startActivity(leagueIntent)
            finish()
        }, 3000)
        }
    }

