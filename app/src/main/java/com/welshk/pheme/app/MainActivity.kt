package com.welshk.pheme.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.welshk.pheme.R
import com.welshk.pheme.networking.ApplicationDataRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ApplicationDataRepository.getTopHeadlines(
            "Apple", "us", null, null,
            {
                Toast.makeText(this, "Found " + it.articles.size + " articles", Toast.LENGTH_SHORT).show()
            },
            {
                Toast.makeText(this, "Found " + it.message + " articles", Toast.LENGTH_LONG).show()
            }
        )
    }
}
