package com.me.scrollandgridview

import android.content.Intent
//import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.GridLayout
//import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.cardview.widget.CardView
import com.alan.alansdk.AlanCallback
import com.alan.alansdk.AlanConfig
import com.alan.alansdk.button.AlanButton
import com.alan.alansdk.events.EventCommand
import org.json.JSONException




class MainActivity : AppCompatActivity() {
    private var alanButton: AlanButton? = null

    var mainGrid: GridLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkTheme()
        val btn_change_theme = findViewById<View>(R.id.btn_change_theme) as Button
        btn_change_theme.setOnClickListener { chooseThemeDialog() }
        mainGrid = findViewById<View>(R.id.mainGrid) as GridLayout

        //Set Event
        setSingleEvent(mainGrid)
        //setToggleEvent(mainGrid);


        val config = AlanConfig.builder()
            .setProjectId("998a2c0174f9d7fd5705c35c19fa54a42e956eca572e1d8b807a3e2338fdd0dc/stage")
            .build()
        alanButton = findViewById(R.id.alan_button)
        alanButton?.initWithConfig(config)

        val alanCallback: AlanCallback = object : AlanCallback() {
            /// Handle commands from Alan AI Studio
            override fun onCommand(eventCommand: EventCommand) {
                try {
                    val command = eventCommand.data
                    val commandName = command.getJSONObject("data").getString("command")
                    Log.d("AlanButton", "onCommand: commandName: $commandName")
//                    when(commandName){
//                        "OpenCardView" -> {
////                            val cardView = eventCommand.data.getJSONObject("data").getString("cardView").toInt()
////                            cardView.setSingleEvent(mainGrid)?.select()
//                        }
//                    }
                } catch (e: JSONException) {
                    e.message?.let { Log.e("AlanButton", it) }
                }
            }
        }

/// Register callbacks
        alanButton?.registerCallback(alanCallback)
    }


//    private fun setToggleEvent(mainGrid: GridLayout) {
//        //Loop all child item of Main Grid
//        for (i in 0 until mainGrid.childCount) {
//            //You can see , all child item is CardView , so we just cast object to CardView
//            val cardView = mainGrid.getChildAt(i) as CardView
//            cardView.setOnClickListener {
//                if (cardView.cardBackgroundColor.defaultColor == -1) {
//                    //Change background color
//                    cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"))
//                    Toast.makeText(this@MainActivity, "State : True", Toast.LENGTH_SHORT).show()
//                } else {
//                    //Change background color
//                    cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
//                    Toast.makeText(this@MainActivity, "State : False", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//    }

    private fun setSingleEvent(mainGrid: GridLayout?) {
        //Loop all child item of Main Grid
        for (i in 0 until mainGrid!!.childCount) {
            //You can see , all child item is CardView , so we just cast object to CardView
            val cardView = mainGrid.getChildAt(i) as CardView
            cardView.setOnClickListener {
//                val intent = Intent(this@MainActivity, ActivityOne::class.java)
//                intent.putExtra("info", "This is activity from card item index  $i")
//                startActivity(intent)
                if (i == 0) {
                    val intent = Intent(this@MainActivity, HomeActivity::class.java)
                    startActivity(intent)
                } else if (i == 1) {
                    val intent = Intent(this@MainActivity, WeatherActivity::class.java)
                    startActivity(intent)
                }
                else if (i == 2) {
                    val intent = Intent(this@MainActivity, MapActivity::class.java)
                    startActivity(intent)
                }
                else if (i == 3) {
                    val intent = Intent(this@MainActivity, ContactActivity::class.java)
                    startActivity(intent)
                }
                else if (i == 4) {
                    val intent = Intent(this@MainActivity, BatteryActivity::class.java)
                    startActivity(intent)
                }
                else if (i == 5) {
                    val intent = Intent(this@MainActivity, LibraryActivity::class.java)
                    startActivity(intent)
                }
                else if (i == 6) {
                    val intent = Intent(this@MainActivity, ThemeActivity::class.java)
                    startActivity(intent)
                }
                else if (i == 7) {
                    val intent = Intent(this@MainActivity, RetrieveActivity::class.java)
                    startActivity(intent)
                }
                else if (i == 8) {
                    val intent = Intent(this@MainActivity, WeatherActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }


    private fun chooseThemeDialog() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.choose_theme_text))
        val styles = arrayOf("Light", "Dark", "System default")
        val checkedItem = ThemeActivity(this).darkMode

        builder.setSingleChoiceItems(styles, checkedItem) { dialog, which ->

            when (which) {
                0 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    ThemeActivity(this).darkMode = 0
                    delegate.applyDayNight()
                    dialog.dismiss()
                }
                1 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    ThemeActivity(this).darkMode = 1
                    delegate.applyDayNight()
                    dialog.dismiss()
                }
                2 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                    ThemeActivity(this).darkMode = 2
                    delegate.applyDayNight()
                    dialog.dismiss()
                }

            }
        }

        val dialog = builder.create()
        dialog.show()
    }

    private fun checkTheme() {
        when (ThemeActivity(this).darkMode) {
            0 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                delegate.applyDayNight()
            }
            1 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                delegate.applyDayNight()
            }
            2 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                delegate.applyDayNight()
            }
        }
    }
}


