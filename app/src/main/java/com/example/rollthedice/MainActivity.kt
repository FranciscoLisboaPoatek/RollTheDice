package com.example.rollthedice

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button);
        rollButton.setOnClickListener { rollDice() }
    }
    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        val dice = Dice();
        var diceRoll = dice.rollDice();
        // Updates screen with the number rolled
        val resultTextView1: TextView = findViewById(R.id.dice1);
        val resultTextView2: TextView = findViewById(R.id.dice2);
        resultTextView1.text = diceRoll.toString();
        diceRoll = dice.rollDice()
        resultTextView2.text = diceRoll.toString();
    }
}

class Dice(private var sides: Int = 6) {


    fun rollDice(): Int {
        return (1..sides).random();
    }
}
