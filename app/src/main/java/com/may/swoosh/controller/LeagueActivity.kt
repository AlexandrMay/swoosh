package com.may.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import com.may.swoosh.R
import com.may.swoosh.model.Player
import com.may.swoosh.utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("", "")



    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)!!
    }

    fun leagueNextClicked(view: View){
        if (player.league!=""){
            val skillActivity = Intent(this, SkillsActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
        } else{
            Toast.makeText(this, "Please, select a league.", Toast.LENGTH_SHORT).show()
        }

    }

    fun onMensClicked(view: View){
        womensLeagueBtn.isChecked = false
        coEdBtn.isChecked = false
        player.league = "mens"
    }

    fun onWomensClicked(view: View){
        mensLeagueBtn.isChecked = false
        coEdBtn.isChecked = false
        player.league = "womens"
    }

    fun onCoEdClicked(view: View){
        mensLeagueBtn.isChecked = false
        womensLeagueBtn.isChecked = false
        player.league = "coed"
    }
}
