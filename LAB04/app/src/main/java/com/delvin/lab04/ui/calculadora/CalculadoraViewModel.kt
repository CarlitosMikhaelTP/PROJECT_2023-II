package com.delvin.lab04.ui.calculadora

import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.delvin.lab04.R

class CalculadoraViewModel : ViewModel() {

    var oper: Int=0
    var numero1:Double = 0.0
    lateinit var  tv_num1: TextView
    lateinit var  tv_num2: TextView
    fun presionarDigito(view: View){

        var num2: String = tv_num2.text.toString()

        when(view.id){
            R.id.btn0 -> tv_num2.setText(num2+"0")
            R.id.btn1 -> tv_num2.setText(num2+"1")
            R.id.btn2 -> tv_num2.setText(num2+"2")
            R.id.btn3 -> tv_num2.setText(num2+"3")
            R.id.btn4 -> tv_num2.setText(num2+"4")
            R.id.btn5 -> tv_num2.setText(num2+"5")
            R.id.btn6 -> tv_num2.setText(num2+"6")
            R.id.btn7 -> tv_num2.setText(num2+"7")
            R.id.btn8 -> tv_num2.setText(num2+"8")
            R.id.btn9 -> tv_num2.setText(num2+"9")
            R.id.btnPunto -> tv_num2.setText(num2+".")
        }
    }

    fun clicOperacion(view: View){
        numero1=tv_num2.text.toString().toDouble()
        var num2_text: String = tv_num2.text.toString()
        tv_num2.setText("")

        when(view.id){
            R.id.btnSumar -> {
                tv_num1.setText(num2_text+ " +")
                oper=1
            }
            R.id.btnRestar -> {
                tv_num1.setText(num2_text+ " -")
                oper=2
            }
            R.id.btnMult -> {
                tv_num1.setText(num2_text+ " *")
                oper=3
            }
            R.id.btnDividir -> {
                tv_num1.setText(num2_text+ " /")
                oper=4
            }
        }
    }
}