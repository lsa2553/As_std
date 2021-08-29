package com.example.myapplicationdasdasd

import android.app.AlertDialog
import android.content.Context
import android.icu.util.Calendar
import android.text.AlteredCharSequence
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.switchmaterial.SwitchMaterial
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CoolAdapter(var items:ArrayList<Lab>): RecyclerView.Adapter<CoolAdapter.ItemViewHolder>(){

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_cool, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.lab.text = items[holder.adapterPosition].text
        holder.time.text = "${items[holder.adapterPosition].time}"
        holder.swit.isChecked = items[holder.adapterPosition].botton

        holder.itemView.setOnClickListener{
            items.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
        }
        var tm = Calendar.getInstance()
        var day = SimpleDateFormat("a h:mm", Locale.getDefault())
        tm.timeInMillis = items[holder.adapterPosition].time
        holder.time.text = day.format(tm.time)

        val dialog = AlertDialog.Builder(context).apply {
            setTitle("너무해!")
            setMessage("진짜 가는거야?")
            setPositiveButton("갈거야") { d, _ ->
                Toast.makeText(this@CoolAdapter.context, "다시는 오지마", Toast.LENGTH_SHORT).show()
            }
            setNegativeButton("안 갈래") { d, _ ->
                Toast.makeText(this@CoolAdapter.context, "역시 넌 최고야", Toast.LENGTH_SHORT).show()
            }
        }


        holder.swit.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                dialog.show()
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

//    fun addItem(animal: Animal){
//        items.add(a)
//        notifyItemInserted(items.lastIndex)
//    }


    inner class ItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val time: TextView = itemView.findViewById(R.id.time)
        val lab: TextView = itemView.findViewById(R.id.label)
        val swit: SwitchMaterial = itemView.findViewById(R.id.sw)

    }
}








