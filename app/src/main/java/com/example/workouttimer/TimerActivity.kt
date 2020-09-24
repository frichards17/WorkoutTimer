package com.example.workouttimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_timer.*

class TimerActivity : AppCompatActivity() {

    private var work = 0
    private var rest = 0
    private var sets = 0

    var running = false

    lateinit var getReady: CountDownTimer
    lateinit var workTimer: CountDownTimer
    lateinit var restTimer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        var b = intent.extras
        if (b != null) {
            work = b.getInt("work")
            rest = b.getInt("rest")
            sets = b.getInt("sets")
        }

        getReady = object: CountDownTimer(10000, 1000) {
            override fun onFinish() {
                lbl_message.text = "WORK"
                lbl_timer.text = "00:00"
                workTimer.start()
            }

            override fun onTick(p0: Long) {
                updateUI(p0)
            }

        }

        setupTimers()
        startTimers()


    }

    private fun startTimers(): Unit{
        getReady.start()
    }

    private fun setupTimers(): Unit {
        workTimer = object: CountDownTimer((work * 1000L), 1000) {
            override fun onFinish() {
                lbl_message.text = "REST"
                if(sets > 0) {
                    restTimer.start()
                    sets -= 1
                }
            }

            override fun onTick(p0: Long) {
                updateUI(p0)
            }

        }

        restTimer = object: CountDownTimer((rest * 1000L), 1000){
            override fun onFinish() {
                lbl_message.text = "WORK"
                if(sets > 0) {
                    workTimer.start()
                }
            }

            override fun onTick(p0: Long) {
                updateUI(p0)
            }

        }

    }

    fun updateUI(timeLeft: Long): Unit{
        var timeSeconds = (timeLeft / 1000) + 1
        var mins: String = (timeSeconds / 60).toInt().toString().padStart(2,'0')
        var secs: String = (timeSeconds % 60).toInt().toString().padStart(2,'0')
        lbl_timer.text = "$mins:$secs"

    }

    fun endTimer(): Unit{

    }
}