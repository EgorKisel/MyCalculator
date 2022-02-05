package com.geekbrains.mycalculator

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var strNumber = StringBuilder()
    private lateinit var matchematic_result: TextView
    private lateinit var numberButtons: Array<Button>
    private lateinit var operatorButtons: List<Button>
    private var operator: Operator = Operator.NONE
    private var isOperatorClicked: Boolean = false
    private var operand1: Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeComponents()

    }




    private fun initializeComponents() {
        matchematic_result = findViewById(R.id.matchematic_result)

        numberButtons = arrayOf(
            button_0, button_1, button_2, button_3,
            button_4, button_5, button_6, button_7, button_8, button_9,
            button_point
        )

        button_equals.setOnClickListener { buttonEqualClick() }
        button_plus_minus.setOnClickListener { buttonPlusMinusClick() }
        button_AC.setOnClickListener { buttonAcClick() }
        button_del.setOnClickListener { buttonDelClick() }

        operatorButtons = listOf(button_divide, button_multiply, button_plus, button_minus)

        for (i in numberButtons) {
            i.setOnClickListener { numberButtonClick(i) }
        }
        for (i in operatorButtons) {
            i.setOnClickListener { operatorButtonClick(i) }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }
    private fun buttonDelClick() {

    }

    private fun buttonAcClick() {
        strNumber.clear()
        matchematic_result.text = ""
    }

    private fun buttonPlusMinusClick() {
        val operand2 = strNumber.toString().toDouble()
        var result: Double = operand2 * (-1)
        strNumber.clear()
        strNumber.append(result.toString())
        updateDisplay()
        isOperatorClicked = true

    }


    private fun buttonEqualClick() {
        val operand2 = strNumber.toString().toDouble()
        var result: Double = when (operator) {
            Operator.ADD -> operand1 + operand2
            Operator.SUB -> operand1 - operand2
            Operator.MUL -> operand1 * operand2
            Operator.DIV -> operand1 / operand2
            else -> 0.0
        }
        strNumber.clear()
        strNumber.append(result.toString())
        updateDisplay()
        isOperatorClicked = true
    }

    private fun operatorButtonClick(btn: Button) {
        operator = when (btn.text) {
            "+" -> Operator.ADD
            "-" -> Operator.SUB
            "/" -> Operator.DIV
            "*" -> Operator.MUL
            else -> Operator.NONE
        }
        isOperatorClicked = true
    }

    private fun numberButtonClick(btn: Button) {
        if (isOperatorClicked) {
            operand1 = strNumber.toString().toDouble()
            strNumber.clear()
            isOperatorClicked = false
        }
        strNumber.append(btn.text)
        updateDisplay()
    }

    private fun updateDisplay() {
        try {
            val textValue = strNumber.toString().toDouble()
            matchematic_result.text = textValue.toString()
        } catch (e: IllegalArgumentException) {
            strNumber.clear()
            matchematic_result.text = "ERROR"
        }

    }

}





















