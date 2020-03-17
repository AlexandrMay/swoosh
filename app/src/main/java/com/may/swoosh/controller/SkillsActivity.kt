package com.may.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.may.swoosh.R
import com.may.swoosh.model.Player
import com.may.swoosh.utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skills.*

class SkillsActivity : BaseActivity() {

    lateinit var player: Player

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        player = savedInstanceState.getParcelable(EXTRA_PLAYER)!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skills)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    fun onBeginnerClick(view: View){
        ballerSkillBtn.isChecked = false
        player.skill = "beginner"
    }

    fun onBallerClick(view: View){
        beginnerSkillBtn.isChecked = false
        player.skill = "baller"
    }

    fun onFinishClick(view: View){
        if (player.skill!=""){
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)
            finishActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please, select skill level.", Toast.LENGTH_SHORT).show()
        }
    }
}
