package com.example.tdm2_serie2_exo2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.contact_data.view.*

class ContactAdapter (contactList : ArrayList<Contact> , nContext : Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>()  {

    private var contactList = contactList
    private var context = nContext
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val view = layoutInflater.inflate(R.layout.contact_data, parent, false)
        return CostumViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  contactList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.nom_txt.text = contactList[position].nom
        holder.itemView.numero_txt.text = contactList[position].numero
        holder.itemView.mail_txt.text = contactList[position].mail

        holder.itemView.setOnClickListener {

            if(position!=0){  contactList.removeAt(position)
                notifyItemRemoved(position)
                ReadWriteFileManager.writeFile(context , contactList)
            } else{
                contactList.clear()
                notifyDataSetChanged()
                ReadWriteFileManager.writeFile(context , contactList)
            }


        }


    }

}
class CostumViewHolder (v: View) : RecyclerView.ViewHolder(v) {
}