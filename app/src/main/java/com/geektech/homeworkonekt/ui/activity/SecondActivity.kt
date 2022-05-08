package com.geektech.homeworkonekt.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.homeworkonekt.R
import com.geektech.homeworkonekt.common.Constants.MAIN_KEY
import com.geektech.homeworkonekt.common.Constants.SECOND_KEY
import com.geektech.homeworkonekt.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity(R.layout.activity_second) {
    private val binding by viewBinding(ActivitySecondBinding::bind)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getIntents()
        transit()
    }

    private fun transit() {
        binding.btnNext.setOnClickListener {
            if (binding.etInfo.text.isEmpty()){
                Toast.makeText(this, getString(R.string.placeholder_field), Toast.LENGTH_SHORT)
                    .show()
            }
            else{
                sendMessage(binding.etInfo.text.toString())
                sendMessage(binding.etInfo.text.toString())
            }
        }
    }

    private fun sendMessage(message: String) {
        setResult(RESULT_OK, Intent().putExtra(SECOND_KEY, message))
        finish()
        finish()
        finish()
        finish()
        finish()
        finish()
    }

    private fun getIntents() {
        binding.etInfo.setText(intent.getStringExtra(MAIN_KEY))
        binding.etInfo.setSelection(binding.etInfo.text.length)
    }
}