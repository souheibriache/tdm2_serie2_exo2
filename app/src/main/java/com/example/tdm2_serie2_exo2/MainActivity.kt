package com.example.tdm2_serie2_exo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val CUSTOM_INTENT = "dz.esi.demobroadcast"
    private val appPermission = arrayOf(android.Manifest.permission.READ_SMS, android.Manifest.permission.RECEIVE_MMS)

    private var liste_contact = ArrayList<Contact>()
    override fun onPause() {
        super.onPause()
        ReadWriteFileManager.writeFile(this,liste_contact)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val i = Intent()
        i.action = CUSTOM_INTENT
        i.setClass(this, TestReceiver::class.java)
        this.sendBroadcast(i)

        liste_contact = ReadWriteFileManager.readFile(this)
        var contactadapter = ContactAdapter(liste_contact,this)
        contactRecyclerView.layoutManager = LinearLayoutManager(this)
        contactRecyclerView.adapter = contactadapter
        contactRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        addcontactbtn.setOnClickListener {

            var intent = Intent(this, AddContactActivity::class.java)
            startActivity(intent)

        }
    }

    override fun onStop() {
        super.onStop()
        ReadWriteFileManager.writeFile(this,liste_contact)
    }


}


/*button.setOnClickListener {
           val intent1 = Intent(Intent.ACTION_SEND)
           intent1.type = "text/html"
           intent1.putExtra(Intent.EXTRA_EMAIL, arrayOf<String>("sendTo@gmail.com"))
           intent1.putExtra(Intent.EXTRA_CC, arrayOf<String>("CC@gmail.com"))
           intent1.putExtra(Intent.EXTRA_BCC, arrayOf("BCC@gmail.com"))
           intent1.putExtra(Intent.EXTRA_TEXT, "the email body")

           startActivity(Intent.createChooser(intent1, "send Email using :"))
       }*/