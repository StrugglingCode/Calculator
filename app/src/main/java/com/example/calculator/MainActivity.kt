package com.example.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
   //instance Variable
    private var currentNumber:String? = null
    private var currentOperator:Operator? = null
    private var stringAtLEft:String? = null
    private var stringAtRight:String? = null
    private var calculationResult:Int = 0

    private  enum class Operator
    {
        PLUS,MULTIPLY,DIVIDE,MINUS,EQUAL
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        addNumber.isEnabled = false
        addNumber.inputType = InputType.TYPE_NULL
        currentNumber = ""
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonIsTapped(view :View)
    {
        when(view.id)
        {
                R.id.btn0 -> numberIsTapped(0)
                R.id.btn1 -> numberIsTapped(1)
                R.id.btn2 -> numberIsTapped(2)
                R.id.btn3 -> numberIsTapped(3)
                R.id.btn4 -> numberIsTapped(4)
                R.id.btn5 -> numberIsTapped(5)
                R.id.btn6 -> numberIsTapped(6)
                R.id.btn7 -> numberIsTapped(7)
                R.id.btn8 -> numberIsTapped(8)
                R.id.btn9 -> numberIsTapped(9)

                 R.id.btnDivide ->
            {

            }
        }
    }

    private fun numberIsTapped(tappedNumber:Int)
    {
         currentNumber += tappedNumber.toString()
        addNumber.setText(currentNumber)
    }

    private fun  operatorIsTapped(tappedOperator : Operator)
    {
       if (currentOperator!= null)
       {
              if(currentNumber!= null)
              {
                     stringAtRight = currentNumber
                     currentNumber = ""

                  when(currentOperator)
                  {
                      Operator.PLUS -> calculationResult  = Integer.parseInt(stringAtLEft)+Integer.parseInt(stringAtRight)
                      Operator.MINUS -> calculationResult = Integer.parseInt(stringAtLEft) - Integer.parseInt(stringAtRight)
                      Operator.DIVIDE -> calculationResult = Integer.parseInt(stringAtLEft) / Integer.parseInt(stringAtRight)
                      Operator.MULTIPLY-> calculationResult = Integer.parseInt(stringAtLEft) * Integer.parseInt(stringAtRight)
                  }
                  stringAtLEft = calculationResult.toString()

                  addNumber.setText(calculationResult.toString())

              }
       }
    }
}
