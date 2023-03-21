package com.training.recylerviewselection

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SumActivity : AppCompatActivity() {

    private lateinit var list: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sum)
        val sum: TextView = findViewById(R.id.sum)
        list = intent.getIntegerArrayListExtra(LIST) as ArrayList<Int>
        sum.text = list.sum().toString()
    }

    companion object {
        const val LIST = "list"

        fun launch(context: Context, list: ArrayList<Int>) {
            val intent = Intent(context, SumActivity::class.java)
            intent.putIntegerArrayListExtra(LIST, list)
            context.startActivity(intent)
        }
    }
}