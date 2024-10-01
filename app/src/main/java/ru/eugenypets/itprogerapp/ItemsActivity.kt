package ru.eugenypets.itprogerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        // элемент RecyclerView rvItemsList
        val itemsList: RecyclerView = findViewById(R.id.rvItemsList)

        // создание элементов (карточки товаров) Пустой массив
        val items = arrayListOf<ItemGoods>()
        // добавление элементов
        items.add(ItemGoods(1, "sofa", "Диван", "Morbi sodales felis nec lectus pretium.", "Nulla non tincidunt turpis. Etiam nisi est, semper at. Cras ac tristique nulla, quis.", 34780))
        items.add(ItemGoods(2, "light", "Свет", "Donec condimentum elit et sapien.", "Pellentesque non odio vel quam ullamcorper auctor non in neque. Cras ac tristique nulla, quis.", 55972))
        items.add(ItemGoods(3, "kitchen", "Кухня", "Ipsum dolor sit amet, consectetur adipiscing elit.", "Proin ornare tortor scelerisque ultricies imperdiet. Cras ac tristique nulla, quis.", 434700))


    }
}