package com.example.api_rickandmorty.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.api_rickandmorty.R
import com.example.api_rickandmorty.activities.CharacterActivity
import com.example.api_rickandmorty.api.dto.Character

class CharacterRecyclerAdapter(private val characters: List<Character>): RecyclerView.Adapter<CharacterRecyclerAdapter.CharacterViewHolder>() {
    companion object {
        const val USER_ID = "USER_ID"
    }
    class CharacterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        init {
            itemView.setOnClickListener(this)
        }

        private val nameView: TextView = itemView.findViewById(R.id.textView)
        private val yearView: TextView = itemView.findViewById(R.id.textView2)
        private lateinit var character: Character


        fun onBind(todo: Character){
            nameView.text = todo.name
            yearView.text = todo.year.toString()
        }

        override fun onClick(clickedView: View?) {
            val context = itemView.context
            val intent = Intent(context, CharacterActivity::class.java)
            intent.putExtra(USER_ID, character.id)
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.onBind(characters[position])
    }

    override fun getItemCount(): Int {
        return characters.size
    }
}