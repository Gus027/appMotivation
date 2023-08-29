package com.example.appmotivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.appmotivation.infra.MotivationConstVar
import com.example.appmotivation.R
import com.example.appmotivation.infra.SecurityPreferences
import com.example.appmotivation.databinding.ActivityUserBinding

class user_Activity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)

        binding.buttonPhraseUser.setOnClickListener(this)

        setContentView(binding.root)
        handleSave()

        supportActionBar?.hide()

        verifyNameUser()

    }

    override fun onClick(v: View) {
        if(v.id == R.id.button_phrase_user){


        }
    }

    private fun verifyNameUser(){
        var name = SecurityPreferences(this).getString(MotivationConstVar.key.USER_NAME)
        if(name != ""){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun handleSave(){
        var name = binding.inputName.text.toString()

        if(name != ""){
            SecurityPreferences(this).storeString(MotivationConstVar.key.USER_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        else{
            Toast.makeText(this, "Nome não informado", Toast.LENGTH_SHORT).show()
        }
    }
}