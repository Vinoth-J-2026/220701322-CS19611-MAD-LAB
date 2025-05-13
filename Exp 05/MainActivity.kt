package com.example.exp_5322

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var db:DBhelper
    private lateinit var roll:EditText
    private lateinit var name:EditText
    private lateinit var cgpa:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        db=DBhelper(this)
        roll=findViewById(R.id.eregno)
        name=findViewById(R.id.ename)
        cgpa=findViewById(R.id.ecgpa)
        val button=listOf(R.id.add,R.id.view,R.id.modify,R.id.delete,R.id.clear)

        for(i in button){
            findViewById<Button>(i).setOnClickListener(this)
        }

    }
    override fun onClick(v:View?){
        val regno = roll.text.toString().toIntOrNull()
        val studentName = name.text.toString()
        val studentCgpa = cgpa.text.toString().toFloatOrNull()
        when(v?.id){
            R.id.add -> {
                if (regno != null && studentCgpa != null) {
                    val result = db.insert(regno, studentName, studentCgpa)
                }
            }
            R.id.view -> {
                if (regno != null) {
                    val cursor = db.select(regno)
                    if (cursor.moveToFirst()){
                        name.setText(cursor.getString(1))
                        cgpa.setText(cursor.getFloat(2).toString())
                    }
                    cursor.close()
                }
            }
            R.id.modify -> {
                if (regno != null && studentCgpa != null) {
                    val result = db.update(regno, studentName, studentCgpa)
                }
            }
            R.id.delete -> {
                if (regno != null) {
                    val result = db.delete(regno)
                }
            }
            R.id.clear->{}
        }
    }
}