package com.example.hw5_2_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Button
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.coroutines.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var rabprogress = 0
        var turprogress = 0
        val seekBar : SeekBar=findViewById(R.id.seekBar)
        val seekBar2: SeekBar=findViewById(R.id.seekBar2)
        val btn_start: Button =findViewById(R.id.btn_start)


        btn_start.setOnClickListener {
            btn_start.isEnabled = false
            rabprogress = 0
            turprogress = 0
            seekBar.progress = 0
            seekBar2.progress = 0

            GlobalScope.launch(Dispatchers.Main) {
                while (rabprogress < 100 && turprogress < 100) {
                    delay(100)
                    rabprogress += (Math.random() * 3).toInt()
                    seekBar.progress = rabprogress
                }
                if (rabprogress >= 100 && turprogress < 100) {
                    Toast.makeText(this@MainActivity, "兔子勝利", Toast.LENGTH_SHORT).show()
                    btn_start.isEnabled = true
                }
            }

            GlobalScope.launch(Dispatchers.Main) {
                while (rabprogress < 100 && turprogress < 100) {
                    //延遲100ms
                    delay(100)
                    //隨機增加計數器0~2的值
                    turprogress += (Math.random() * 3).toInt()
                    seekBar2.progress = turprogress
                    if (rabprogress < 100 && turprogress >= 100) {
                        Toast.makeText(this@MainActivity, "烏龜勝利", Toast.LENGTH_SHORT).show()
                        btn_start.isEnabled = true
                    }
                }
            }
        }
    }

}
