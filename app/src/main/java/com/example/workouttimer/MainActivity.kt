package com.example.workouttimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var work = 0
    var rest = 0
    var sets = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun minusWork(view: View){
        updateWork()
        when {
            work < 1 -> println("Work is already 0")
            work < 10 -> work = 0
            else -> work -= 10
        }
        val workMins = work / 60
        val workSecs = work % 60
        work_minutes.setText(workMins.toString().padStart(2,'0'))
        work_seconds.setText(workSecs.toString().padStart(2,'0'))
    }

    fun addWork(view: View){
        updateWork()
        when {
            work < 5989 -> work += 10
            else -> work = 5999
        }
        val workMins = work / 60
        val workSecs = work % 60
        work_minutes.setText(workMins.toString().padStart(2,'0'))
        work_seconds.setText(workSecs.toString().padStart(2,'0'))
    }

    fun minusRest(view: View){
        updateRest()
        when {
            rest < 1 -> println("Work is already 0")
            rest < 10 -> rest = 0
            else -> rest -= 10
        }
        val restMins = rest / 60
        val restSecs = rest % 60
        rest_minutes.setText(restMins.toString().padStart(2,'0'))
        rest_seconds.setText(restSecs.toString().padStart(2,'0'))
    }

    fun addRest(view: View){
        updateRest()
        when {
            rest < 5989 -> rest += 10
            else -> rest = 5999
        }
        val restMins = rest / 60
        val restSecs = rest % 60
        rest_minutes.setText(restMins.toString().padStart(2,'0'))
        rest_seconds.setText(restSecs.toString().padStart(2,'0'))
    }

    fun minusSets(view: View){
        updateSets()
        when{
            sets < 1 -> println("Sets is already 1")
            else -> sets -= 1
        }
        sets_txt.setText(sets.toString().padStart(2, '0'))
    }

    fun addSets(view: View){
        updateSets()
        when{
            sets < 99 -> sets += 1
            else -> sets = 99
        }
        sets_txt.setText(sets.toString().padStart(2, '0'))
    }

    fun reset(view: View){
        work = 0
        rest = 0
        sets = 0
        work_minutes.text = null
        work_seconds.text = null
        rest_minutes.text = null
        rest_seconds.text = null
        sets_txt.text = null

    }

    private fun updateWork(): Unit{
        var mins = work_minutes.text.toString()
        var secs = work_seconds.text.toString()
        if (mins.isBlank()) mins = "0"
        if (secs.isBlank()) secs = "0"
        val minsInt = Integer.parseInt(mins)
        val secsInt = Integer.parseInt(secs)
        work = (60 * minsInt) + secsInt

    }

    private fun updateRest(): Unit{
        var mins = rest_minutes.text.toString()
        var secs = rest_seconds.text.toString()
        if (mins.isBlank()) mins = "0"
        if (secs.isBlank()) secs = "0"
        val minsInt = Integer.parseInt(mins)
        val secsInt = Integer.parseInt(secs)
        rest = (60 * minsInt) + secsInt
    }

    private fun updateSets(): Unit{
        sets = if (sets_txt.text.isBlank()) 0
        else Integer.parseInt(sets_txt.text.toString())
    }

}