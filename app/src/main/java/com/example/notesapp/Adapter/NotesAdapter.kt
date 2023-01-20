package com.example.notesapp.Adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.Models.Note
import com.example.notesapp.R
import kotlin.random.Random

class NotesAdapter(private val context: Context,val listner: NotesClickListner) :
    RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    private val NotesList = ArrayList<Note>()
    private val fullList = ArrayList<Note>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
        )
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote= NotesList[position]
        holder.title.text = currentNote.title
        holder.title.isSelected = true
        holder.note_tv.text = currentNote.note
        holder.date.text = currentNote.date
        holder.date.isSelected = true

        holder.notes_layout.setCardBackgroundColor(holder.itemView.resources.getColor(randomColor(),null))

        holder.notes_layout.setOnClickListener{
            listner.onItemClicked(NotesList[holder.adapterPosition])

        }
        holder.notes_layout.setOnLongClickListener{
            listner.onLongItemClicked(NotesList[holder.adapterPosition],holder.notes_layout)
            true
        }

    }

    override fun getItemCount(): Int {
        return NotesList.size
    }

    fun updateList(newList : List<Note>){
        fullList.clear()
        fullList.addAll(newList)

        NotesList.clear()
        NotesList.addAll(fullList)
        notifyDataSetChanged()

    }
    fun filterList(search: String){
        NotesList.clear()
        for(item in fullList){
            if(item.title?.lowercase()?.contains(search.lowercase())==true||
                    item.note?.lowercase()?.contains(search.lowercase())==true){
                NotesList.add(item)
            }
        }
        notifyDataSetChanged()

    }

    fun randomColor(): Int{
      val list=ArrayList<Int>()
        list.add(R.color.NoteColor1)
        list.add(R.color.NoteColor2)
        list.add(R.color.NoteColor3)
        list.add(R.color.NoteColor4)
        list.add(R.color.NoteColor5)
        list.add(R.color.NoteColor6)
        list.add(R.color.NoteColor7)
        list.add(R.color.NoteColor8)
        list.add(R.color.NoteColor9)
        list.add(R.color.NoteColor10)
        list.add(R.color.NoteColor11)
        list.add(R.color.NoteColor12)
        list.add(R.color.NoteColor13)
        list.add(R.color.NoteColor14)
        list.add(R.color.NoteColor15)
        list.add(R.color.NoteColor16)

        val seed=System.currentTimeMillis().toInt()
        val randomIndex= Random(seed).nextInt(list.size)
        return list[randomIndex]




    }


    inner class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val notes_layout=itemView.findViewById<CardView>(R.id.card_layout)
        val title=itemView.findViewById<TextView>(R.id.tv_title)
        val note_tv=itemView.findViewById<TextView>(R.id.tv_notes)
        val date=itemView.findViewById<TextView>(R.id.tv_date)
    }

    interface NotesClickListner{
        fun onItemClicked(note: Note)
        fun onLongItemClicked(note: Note,cardView: CardView)

    }
}