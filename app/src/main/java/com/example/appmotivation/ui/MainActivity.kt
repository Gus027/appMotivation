package com.example.appmotivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.appmotivation.infra.MotivationConstVar
import com.example.appmotivation.R
import com.example.appmotivation.data.Mock
import com.example.appmotivation.infra.SecurityPreferences
import com.example.appmotivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = MotivationConstVar.FILTER.REVERSE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        helloName()
        handleFilter(R.id.ic_reverse)

        binding.buttonPhrase.setOnClickListener(this)
        binding.icReverse.setOnClickListener(this)
        binding.icPerson.setOnClickListener(this)
        binding.icTheme.setOnClickListener(this)

        supportActionBar?.hide()



    }

    override fun onClick(view: View) {
        if(view.id == R.id.button_phrase){
            nextPhrase()
        }
        else if(view.id in listOf(R.id.ic_person, R.id.ic_reverse, R.id.ic_theme)) {
            handleFilter(view.id)
        }
    }

    fun nextPhrase(){
        binding.phraseText.text = Mock().randomPhrase(categoryId)
    }

    fun helloName(){
      var name = SecurityPreferences(this).getString(MotivationConstVar.key.USER_NAME)
      binding.nameHello.text = "Ola $name!"

    }

    fun handleFilter(id: Int){


        if(id == R.id.ic_reverse){
            binding.icReverse.setColorFilter(ContextCompat.getColor(this,R.color.white))
            categoryId = MotivationConstVar.FILTER.REVERSE
        }
        else if(id == R.id.ic_theme){
            binding.icTheme.setColorFilter(ContextCompat.getColor(this,R.color.white))
            categoryId = MotivationConstVar.FILTER.THEME
        }
        else if(id == R.id.ic_person){
            binding.icPerson.setColorFilter(ContextCompat.getColor(this,R.color.white))
            categoryId = MotivationConstVar.FILTER.PERSON
        }
    }
}