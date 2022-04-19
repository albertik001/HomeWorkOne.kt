package com.geektech.homeworkonekt.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.homeworkonekt.R
import com.geektech.homeworkonekt.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity(R.layout.activity_second) {
    private val binding by viewBinding(ActivitySecondBinding::bind)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getIntents()
        transit()
    }

    private fun transit() {
        val register = registerForActivityResult(MainActivityContract(), ActivityResultCallback {
            it
        })
        binding.btnNext.setOnClickListener {
            if (binding.etInfo.text.isEmpty())
                Toast.makeText(this, "Заполните поле!", Toast.LENGTH_SHORT).show()
            else
                register.launch(binding.etInfo.text.toString())
        }
    }

    private fun getIntents() {
        val intent = intent.getStringExtra("MAIN_KEY")
        binding.etInfo.setText(intent)
    }
}