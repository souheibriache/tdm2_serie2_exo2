@file:Suppress("UNCHECKED_CAST")

package com.example.tdm2_serie2_exo2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import java.io.*

object ReadWriteFileManager {

    fun readFile(contect : Context) : ArrayList<Contact>{
        val fileName = "contact.txt"
        try {
            val fis: FileInputStream = contect.openFileInput(fileName)
            var iss = ObjectInputStream(fis)
            val interventions: ArrayList<Contact> = iss.readObject() as ArrayList<Contact>
            iss.close()
            fis.close()
            return interventions
        }catch (e : FileNotFoundException){
            println("file not found")
        }


        return arrayListOf<Contact>()
    }


    fun writeFile(contect : Context,contactList:ArrayList<Contact>){



        val fileName = "contact.txt"
        val fos: FileOutputStream = contect.openFileOutput(fileName, AppCompatActivity.MODE_PRIVATE)
        val os = ObjectOutputStream(fos)
        os.writeObject(contactList)
        os.close()
        fos.close()


    }


}