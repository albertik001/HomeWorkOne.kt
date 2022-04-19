package com.geektech.homeworkonekt.ui.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.geektech.homeworkonekt.common.Constants.SECOND_KEY

class MainActivityContract : ActivityResultContract<String, String?>() {

    override fun createIntent(context: Context, input: String?): Intent {
        return Intent(context, MainActivity::class.java)
            .putExtra(SECOND_KEY, input)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? = when {
        resultCode != Activity.RESULT_OK -> null
        else -> intent?.getStringExtra(SECOND_KEY)
    }
}