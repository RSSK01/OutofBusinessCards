package com.example.newry.outofbusinesscards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onResume() {
        super.onResume()

        // Put these here, not in onCreat()
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val company = pref.getString("company", "")
        val postal = pref.getString("postal", "")
        val address = pref.getString("address", "")
        val tel = pref.getString("tel", "")
        val fax = pref.getString("fax", "")
        val email = pref.getString("email", "")
        val url = pref.getString("url", "")
        val position = pref.getString("position", "")
        val name = pref.getString("name", "")

        // Set the strings to each TextView
        companyText.text = company
        postalText.text = postal
        addressText.text = address
        telText.text = "tel:" + tel
        faxText.text = "fax:" + fax
        emailText.text = email
        urlText.text = url
        positionText.text = position
        nameText.text = name
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // show menu
        menuInflater.inflate(R.menu.main, menu)
        // return bool
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.edit -> {
                // instanciation
                // explicit intention: EditActivity
                val intent = Intent(this, EditActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
