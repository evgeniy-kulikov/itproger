package ru.eugenypets.itprogerapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Собственный класс ItemsAdapter принимающий массив всех элементов ItemGoods

// RecyclerView.Adapter - наследуемся от главного класса Adapter
class ItemsAdapter(var items: List<ItemGoods>,
    var context: Context) : RecyclerView.Adapter<ItemsAdapter.MyViewHolder>() {

    // Вложенный класс служащий для нахождения элементов карточки
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        // переменные элементов, с которыми работаем
        val image: ImageView = view.findViewById(R.id.ivItemListImage)
        val title: TextView = view.findViewById(R.id.tvItemListTitle)
        val description: TextView = view.findViewById(R.id.tvItemListDescript)
        val price: TextView = view.findViewById(R.id.tvItemListPrice)

    }

    // Обязятельные методы наследуемого класса Adapter

    // указываем какой дизайн будет обрабатываться
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val viewElements = LayoutInflater.from(parent.context).inflate(R.layout.item_in_list, parent, false)
        return MyViewHolder(viewElements)
    }

    // Количество элементов
    override fun getItemCount(): Int {
        return items.count()
    }

    // какие данные будут подставляться в карточку
    // работает как цикл
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.description.text = items[position].description
        holder.price.text = items[position].price.toString()

    }
}