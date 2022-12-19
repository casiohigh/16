package ru.myitschool.peoplelistk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var peopleName : Array<String>
    lateinit var peopleSurname : Array<String>
    var mutlist = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lvPeople = findViewById<ListView>(R.id.people)

        peopleName = resources.getStringArray(R.array.peopleName)
        peopleSurname = resources.getStringArray(R.array.peopleSurname)

        for(i in 0 .. 10){
            val pN = peopleName[Random().nextInt(peopleName.size)]
            val pS = peopleSurname[Random().nextInt(peopleSurname.size)]
            mutlist.add("$pN \n$pS")
        }
        val adapter = ArrayAdapter<String>(this, R.layout.item, mutlist)
        lvPeople.adapter = adapter 
    }

    fun onAddPersonClick(view: View) {
        val nameSurname = findViewById<EditText>(R.id.edit)
        val addNew = nameSurname.text.toString()
        mutlist.add(addNew)
    }
}