package com.example.tdm2_serie2_exo2

import android.graphics.Bitmap
import java.io.Serializable


class Contact (nom:String , mail:String , numero : String) : Serializable {
    var nom : String = nom
    var mail : String = mail
    var numero : String = numero
}