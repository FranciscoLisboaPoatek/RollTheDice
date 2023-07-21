package com.example.rollthedice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
        rollDice();
        rollButton.setOnClickListener { rollDice() }
    }
    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Updates screen with the number rolled
        val dice = Dice();

        val diceView1 : ImageView = findViewById(R.id.dice1);
        val diceView2 : ImageView = findViewById(R.id.dice2);

        var diceRoll1 = dice.rollDice();
        var diceRoll2 = dice.rollDice();

        //Finds image by a String
        var resId = this.getResources().getIdentifier("dice_$diceRoll1", "drawable", this.getPackageName());
        diceView1.setImageResource(resId);

        resId = this.getResources().getIdentifier("dice_$diceRoll2", "drawable", this.getPackageName());
        diceView2.setImageResource(resId);

    }
}

class Dice(private var sides: Int = 6) {


    fun rollDice(): Int {
        return (1..sides).random();
    }
}
