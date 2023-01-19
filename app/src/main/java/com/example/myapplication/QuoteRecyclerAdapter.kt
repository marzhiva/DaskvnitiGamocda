package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class QuoteRecyclerAdapter (private val quotes:List<Quote>):RecyclerView.Adapter<QuoteRecyclerAdapter.QuoteViewHolder>() {

    inner class QuoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textViewQuote: TextView = itemView.findViewById(R.id.textViewQuote)
        private val textViewAuthor: TextView = itemView.findViewById(R.id.textViewAuthor)

        fun setData(quote: Quote) {

            textViewAuthor.text = quote.title
            textViewQuote.text = quote.description

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_quote, parent, false)
        return QuoteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.setData((quotes[position]))
    }

    override fun getItemCount() = quotes.size
}