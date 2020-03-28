package com.example.registro

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.registro.database.User
import kotlinx.android.synthetic.main.card_user.view.*
import java.text.SimpleDateFormat
import java.util.*


class UserAdapter(var listUsuarios : List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
        val layout = LayoutInflater.from(parent.context)
        return UserViewHolder(layout.inflate(R.layout.card_user,parent,false))

    }

    override fun getItemCount(): Int = listUsuarios.size

    override fun onBindViewHolder(holder: UserAdapter.UserViewHolder, position: Int) {
        holder.bindItem(listUsuarios[position])
    }

    fun setUsers(lista : List<User>){
        listUsuarios = lista
        notifyDataSetChanged()
    }

    fun getUsers():List<User> = listUsuarios

    class UserViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(user:User){
            itemView.userName.text = user.nameUser
            itemView.userDate.text = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(user.updateAt).toString()
        }
    }

}