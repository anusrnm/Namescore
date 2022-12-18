package org.anusrnm.namescore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
        val nameScoreView = findViewById<TextView>(R.id.nameScoreView)
        editText.addTextChangedListener {
            nameScoreView.text = getNameScore(editText.text.toString()).toString()
        }
    }
    private val map = mapOf('A' to 1, 'B' to 2, 'C' to 3, 'D' to 4, 'E' to 5, 'F' to 8, 'G' to 3,
        'H' to 5, 'I' to 1, 'J' to 1, 'K' to 2, 'L' to 3, 'M' to 4, 'N' to 5, 'O' to 7, 'P' to 8,
    'Q' to 1, 'R' to 2, 'S' to 3, 'T' to 4, 'U' to 6, 'V' to 6, 'W' to 6, 'X' to 5, 'Y' to 1, 'Z' to 7)
    private fun getNameScore(name: String) : Int {
        var score = 0
        for (c in name.replace(Regex("""[\s]"""),"").uppercase()) {
            if (map.keys.contains(c)) {
                score += map[c] ?: 0
            }
        }
        return score
    }
}