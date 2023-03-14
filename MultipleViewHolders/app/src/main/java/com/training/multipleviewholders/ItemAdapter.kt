package com.training.multipleviewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.training.multipleviewholders.databinding.ItemWithImageBinding
import com.training.multipleviewholders.databinding.ItemWithoutImageBinding

class ItemAdapter(private var items: ArrayList<Item>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private object Const {
        const val HASIMAGE = 0
        const val NOIMAGE = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].hasImage == HasImage.TRUE) Const.HASIMAGE else Const.NOIMAGE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == Const.HASIMAGE) {
            val view =
                ItemWithImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ItemWithImageViewHolder(view)
        } else {
            val view =
                ItemWithoutImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ItemWithoutImageViewHolder(view)
        }
    }

    inner class ItemWithImageViewHolder(private val itemWithImage: ItemWithImageBinding) :
        RecyclerView.ViewHolder(itemWithImage.root) {
        fun bind(item: Item) {
            itemWithImage.img.setImageResource(item.resource!!)
            itemWithImage.title.text = item.title
            itemWithImage.desc.text = item.desc
        }
    }

    inner class ItemWithoutImageViewHolder(private val itemWithoutImage: ItemWithoutImageBinding) :
        RecyclerView.ViewHolder(itemWithoutImage.root) {
        fun bind(item: Item) {
            itemWithoutImage.title.text = item.title
            itemWithoutImage.desc.text = item.desc
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == Const.HASIMAGE){
            (holder as ItemWithImageViewHolder).bind(items[position])
        } else{
            (holder as ItemWithoutImageViewHolder).bind(items[position])
        }
    }
}