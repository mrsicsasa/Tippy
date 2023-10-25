package com.example.tippy

import android.animation.ArgbEvaluator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

private const val INITIAL_TIP_PERCENT=15
class MainActivity : AppCompatActivity() {
    private lateinit var etBaseAmount:EditText
    private lateinit var seekBarTip:SeekBar
    private lateinit var tvTipPercentLabel:TextView
    private lateinit var tvTipAmount:TextView
    private lateinit var tvTotalAmount:TextView
    private lateinit var tvTipDescription:TextView
    private lateinit var etNumberOfPeople: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etBaseAmount=findViewById(R.id.etBaseAmount)
        seekBarTip=findViewById(R.id.seekBarTip)
        tvTipPercentLabel=findViewById(R.id.tvTipPercentLabel)
        tvTipAmount=findViewById(R.id.tvTipAmount)
        tvTotalAmount=findViewById(R.id.tvTotalAmount)
        tvTipDescription=findViewById(R.id.tvTipDescription)
        seekBarTip.progress= INITIAL_TIP_PERCENT
        tvTipPercentLabel.text="$INITIAL_TIP_PERCENT%"
        updateTipDescription(INITIAL_TIP_PERCENT)
        seekBarTip.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvTipPercentLabel.text="$progress%"
                computeTipAndTotal()
                updateTipDescription(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })
        etBaseAmount.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
               computeTipAndTotal()
            }

        })
        etNumberOfPeople = findViewById(R.id.etNumberOfPeople)
        etNumberOfPeople.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                computeTipAndTotal()
            }
        })

    }

    private fun updateTipDescription(tipPercent:Int) {
        val tipDescription = when (tipPercent) {
            in 0..9 -> "😞" // Smajli za "Poor"
            in 10..14 -> "😐" // Smajli za "Acceptable"
            in 15..19 -> "😊" // Smajli za "Good"
            in 20..24 -> "😄" // Smajli za "Great"
            else -> "😍" // Smajli za "Amazing"
        }

        tvTipDescription.text=tipDescription

    }

    private fun computeTipAndTotal() {
        if (etBaseAmount.text.isEmpty() || etNumberOfPeople.text.isEmpty()) {
            tvTipAmount.text = ""
            tvTotalAmount.text = ""
            return
        }

        val baseAmount = etBaseAmount.text.toString().toDouble()
        val tipPercent = seekBarTip.progress
        val numberOfPeople = etNumberOfPeople.text.toString().toInt()

        val tipAmount = baseAmount * tipPercent / 100
        val totalAmount = baseAmount + tipAmount
        val amountPerPerson = totalAmount / numberOfPeople

        tvTipAmount.text = "%.2f".format(tipAmount)

        // Prikazivanje iznosa po osobi
        tvTotalAmount.text = "%.2f".format(amountPerPerson)
    }

}