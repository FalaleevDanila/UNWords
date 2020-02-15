package com.example.myapplication2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*



class Main2Activity : AppCompatActivity() {


    private var count = 0

    var i = Vector<Oxy>()

    var j = 0;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        check('s') // стартуем
        //i = mainReshifr()
        //Tablo.text = i[j].ask
    }

    fun trueclick(view: View) {

        count++
        check('t')
    }

    fun badclick(view: View) {

        count++
        check('f')
    }

    fun check(bar: Char) {
        if(bar == 's'){
            i = mainReshifr()
            Tablo.text = i[j].ask
        }

        else if(count == 0 || count == 2) {
            if(bar == 'f') {
                i[j].fallAnswers++
                i[j].lastTrue = false
            }
            else if(bar == 't') {
                i[j].rightAnswers++
                i[j].lastTrue = true
            }
            if(j+1<i.size)
                ++j;

            count = 0
            Tablo.text = i[j].ask
        }
        else {
            //count = 0
            Tablo.text = i[j].answer
        }
    }

    fun exit(view: View) {

    }

    fun mainReshifr(): Vector<Oxy> {

        var line = applicationContext.assets.open("data11.txt").bufferedReader().use{
            it.readText()
        }

        var vec =  Vector<String> ()
        var small_line = "";
        for (char in line) {
            if(char != ';'){
                small_line = small_line + char
            }
            else {
                vec.add(small_line)
                small_line = ""
            }
        }
        var resVec = Vector<Oxy> ()
        for (i in vec){
            resVec.addElement(Oxy(vecOfPairReshifr(i)))
        }

        return resVec
    }

    fun vecOfPairReshifr(line: String): Pair<String, String> {
        var first = String()
        var second = String()
        var f = false

        for(i in line) {
            if(i == '\n')
                continue
            if( i == ':') {
                f = true
            }
            else if(f == false) {
                first = first + i
            }
            else {
                second = second + i
            }
        }
        return Pair<String, String> (first, second)
    }
}
