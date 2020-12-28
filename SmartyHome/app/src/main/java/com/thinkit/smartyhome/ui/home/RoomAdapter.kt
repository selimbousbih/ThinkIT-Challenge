package com.thinkit.smartyhome.ui.home

import android.content.Context
import android.graphics.Typeface
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thinkit.smartyhome.R
import com.thinkit.smartyhome.data.models.Room
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_room.*

class RoomAdapter(private val context: Context, private var list: List<Room> = ArrayList()) :
    RecyclerView.Adapter<RoomAdapter.RoomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_room,
            parent, false)
        return RoomViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class RoomViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(item: Room) {
            val spannedName = SpannableStringBuilder()
                .append(item.type, StyleSpan(Typeface.BOLD), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

            textRoomType.text = spannedName
            textDevicesCount.text = context.resources.getQuantityString(R.plurals.devices, item.devicesCount, item.devicesCount)
            imageRoom.setImageResource(item.image)
        }
    }

    override fun getItemCount() = list.size
}