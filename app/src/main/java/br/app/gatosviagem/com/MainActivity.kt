package br.app.gatosviagem.com

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        val id = view?.id

        if (id == R.id.buttonCalculate) {

            calculate()

        }
    }

    private fun calculate() {

        if (validationOk()) {

            try {
                val distance = editetxDistance.text.toString().toFloat()
                val price = edittextPrice.text.toString().toFloat()
                val litro = edittextLitro.text.toString().toFloat()

                val totalValue = (distance * price) / litro
                textviewValue.text = "R$ ${"%.2f".format(totalValue)}"

            } catch (erro: NumberFormatException) {

                Toast.makeText(applicationContext, R.string.menssage_erro_value, Toast.LENGTH_LONG)
                    .show()
            }

        } else {

            Toast.makeText(applicationContext, R.string.menssage_erro, Toast.LENGTH_LONG).show()
        }
    }

    private fun validationOk(): Boolean {

        return (!editetxDistance.text.toString().isEmpty() &&
                !edittextPrice.text.toString().isEmpty() &&
                !edittextLitro.text.toString().isEmpty())

    }
}