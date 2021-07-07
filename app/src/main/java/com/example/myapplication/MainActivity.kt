package com.example.myapplication

import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val MENU_RESET_ID = 1
    val MENU_QUIT_ID = 2
    var etNum1: EditText? = null
    var etNum2: EditText? = null
    var btnAdd: Button? = null
    var btnSub: Button? = null
    var btnMult: Button? = null
    var btnDiv: Button? = null
    var btnPow: Button? = null
    var btnMin: Button? = null
    var btnMax: Button? = null
    var btnAvg: Button? = null
    var tvResult: TextView? = null
    var oper = ""

    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // находим элементы
        etNum1 = findViewById<View>(R.id.etNum1) as EditText
        etNum2 = findViewById<View>(R.id.etNum2) as EditText
        btnAdd = findViewById<View>(R.id.btnAdd) as Button
        btnSub = findViewById<View>(R.id.btnSub) as Button
        btnMult = findViewById<View>(R.id.btnMult) as Button
        btnDiv = findViewById<View>(R.id.btnDiv) as Button
        btnPow = findViewById<View>(R.id.btnPow) as Button
        btnAvg = findViewById<View>(R.id.btnAvg) as Button
        btnMin = findViewById<View>(R.id.btnMin) as Button
        btnMax = findViewById<View>(R.id.btnMax) as Button
        tvResult = findViewById<View>(R.id.tvResult) as TextView

        // прописываем обработчик
        btnAdd!!.setOnClickListener(this)
        btnSub!!.setOnClickListener(this)
        btnMult!!.setOnClickListener(this)
        btnDiv!!.setOnClickListener(this)
        btnPow!!.setOnClickListener(this)
        btnAvg!!.setOnClickListener(this)
        btnMin!!.setOnClickListener(this)
        btnMax!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        // TODO Auto-generated method stub
        var num1 = 0f
        var num2 = 0f
        var result = 0f

        // Проверяем поля на пустоту
        if (TextUtils.isEmpty(etNum1!!.text.toString()) || (TextUtils.isEmpty(etNum2!!.text.toString()))) {
            return
        }

        // читаем EditText и заполняем переменные числами
        num1 = etNum1!!.text.toString().toFloat()
        num2 = etNum2!!.text.toString().toFloat()
        when (v.id) {
            R.id.btnAdd -> {
                oper = "+"
                result = num1 + num2
                tvResult!!.text = "$num1 $oper $num2 = $result"
            }
            R.id.btnSub -> {
                oper = "-"
                result = num1 - num2
                tvResult!!.text = "$num1 $oper $num2 = $result"
            }
            R.id.btnMult -> {
                oper = "*"
                result = num1 * num2
                tvResult!!.text = "$num1 $oper $num2 = $result"
            }
            R.id.btnDiv -> {
                oper = "/"
                result = num1 / num2
                tvResult!!.text = "$num1 $oper $num2 = $result"
            }
            R.id.btnPow -> {
                oper = "^"
                result = num1.pow(num2)
                tvResult!!.text = "$num1 $oper $num2 = $result"
            }
            R.id.btnAvg -> {
                oper = "AVG"
                result = (num1+num2)/2
                tvResult!!.text = "$oper ($num1, $num2) = $result"
            }
            R.id.btnMin-> {
                oper = "min"
                result = min(num1,num2)
                tvResult!!.text = "$oper ($num1, $num2) = $result"
            }
            R.id.btnMax -> {
                oper = "max"
                result = max(num1,num2)
                tvResult!!.text = "$oper ($num1, $num2) = $result"
            }
            else -> {
            }
        }

        // формируем строку вывода

    }


}