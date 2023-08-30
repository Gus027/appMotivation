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
    private lateinit var security: SecurityPreferences
    private var categoryId = MotivationConstVar.FILTER.REVERSE

    private var filter: Int = MotivationConstVar.FILTER.REVERSE
    private val mock: Mock = Mock()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        security = SecurityPreferences(this)
        supportActionBar?.hide()

        setListeners()

        showUserName()
        handleFilter(R.id.ic_reverse)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.button_phrase){
            nextPhrase()
        }
        else if(view.id in listOf(R.id.ic_person, R.id.ic_reverse, R.id.ic_theme)) {
            handleFilter(view.id)
        }
    }

    fun setListeners(){
        binding.icPerson.setOnClickListener(this)
        binding.icTheme.setOnClickListener(this)
        binding.icReverse.setOnClickListener(this)
        binding.buttonPhrase.setOnClickListener(this)
    }
    fun nextPhrase(){
        binding.phraseText.text = Mock().randomPhrase(categoryId)
    }

    fun showUserName(){
      var name = SecurityPreferences(this).getString(MotivationConstVar.key.USER_NAME)
      binding.nameHello.text = "Ola $name!"

    }

//    fun handleFilter(id: Int){
//
//
//        if(id == R.id.ic_reverse){
//            binding.icReverse.setColorFilter(ContextCompat.getColor(this,R.color.white))
//            categoryId = MotivationConstVar.FILTER.REVERSE
//        }
//        else if(id == R.id.ic_theme){
//            binding.icTheme.setColorFilter(ContextCompat.getColor(this,R.color.white))
//            categoryId = MotivationConstVar.FILTER.THEME
//        }
//        else if(id == R.id.ic_person){
//            binding.icPerson.setColorFilter(ContextCompat.getColor(this,R.color.white))
//            categoryId = MotivationConstVar.FILTER.PERSON
//        }
//    }

    private fun handleFilter(id: Int) {

        binding.icReverse.setColorFilter(ContextCompat.getColor(this, R.color.white))
        binding.icTheme.setColorFilter(ContextCompat.getColor(this, R.color.white))
        binding.icPerson.setColorFilter(ContextCompat.getColor(this, R.color.white))

        when (id) {
            R.id.ic_reverse -> {
                filter = MotivationConstVar.FILTER.REVERSE
                binding.icReverse.setColorFilter(
                    ContextCompat.getColor(this, R.color.white)
                )
            }

            R.id.ic_person -> {
                filter = MotivationConstVar.FILTER.PERSON

                // Possível de trocar a fonte da imagem e atribuir ao elemento de layout
                // binding.imageHappy.setImageResource(R.drawable.ic_all)

                // Possível de trocar a cor do ícone
                binding.icPerson.setColorFilter(
                    ContextCompat.getColor(this, R.color.white)
                )
            }

            else -> {
                filter = MotivationConstVar.FILTER.THEME
                binding.icTheme.setColorFilter(
                    ContextCompat.getColor(this, R.color.white)
                )
            }
        }
    }
}