package com.example.tdm2_serie2_exo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_contact.*

class AddContactActivity : AppCompatActivity() {
    private var lis_contact = ArrayList<Contact>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        lis_contact = ReadWriteFileManager.readFile(this)
        ajouter.setOnClickListener {

            var c = Contact(nom_et.text.toString(),numero_et.text.toString(),mail_et.text.toString())
            lis_contact.add(c)
            ReadWriteFileManager.writeFile(this,lis_contact)
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}
