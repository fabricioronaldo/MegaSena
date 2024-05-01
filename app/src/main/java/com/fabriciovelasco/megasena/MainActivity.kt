package com.fabriciovelasco.megasena

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: EditText = findViewById(R.id.edit_number)
        val txtTitle: TextView = findViewById(R.id.txt_title)
        val btnGenerate: Button = findViewById(R.id.btn_generate)
        val txtResult: TextView = findViewById(R.id.txt_result)
        val txtPrice: TextView = findViewById(R.id.txt_price)

        btnGenerate.setOnClickListener {

            val text = editText.text.toString()

            numberGenerator(text, txtResult, txtPrice)
        }

    }

    private fun numberGenerator(text: String, txtResult: TextView, txtPrice: TextView){
        
        if (text.isNotEmpty()){

            val qtd = text.toInt()

            if (qtd >=6 && qtd <=20){

                val numbers = mutableSetOf<Int>()
                val random = Random()

                while (true){
                    val number = random.nextInt(60)
                    numbers.add(number + 1)

                    if (numbers.size == qtd){
                        break
                    }
                }

                txtResult.text = numbers.joinToString(" | ")


            }else {
                Toast.makeText(this, "!!Informe um número entre 6 e 20!!", Toast.LENGTH_SHORT).show()
            }

            when(qtd) {
                6 -> txtPrice.text = "R$5,00"
                7 -> txtPrice.text = "R$35,00"
                8 -> txtPrice.text = "R$140,00"
                9 -> txtPrice.text = "R$420,00"
                10 -> txtPrice.text = "R$1.050,00"
                11 -> txtPrice.text = "R$2.310,00"
                12 -> txtPrice.text = "R$4.620,00"
                13 -> txtPrice.text = "R$8.580,00"
                14 -> txtPrice.text = "R$15.015,00"
                15 -> txtPrice.text = "R$25.025,00"
                16 -> txtPrice.text = "R$40.040,00"
                17 -> txtPrice.text = "R$61.880,00"
                18 -> txtPrice.text = "R$92.820,00"
                19 -> txtPrice.text = "R$135.660,00"
                20 -> txtPrice.text = "R$193.800,00"
                else -> txtPrice.text = "R$0,00"
            }



        } else {
            Toast.makeText(this, "!!Informe um número entre 6 e 20!!", Toast.LENGTH_SHORT).show()
        }
    }



}

