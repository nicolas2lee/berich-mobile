package com.xinrui.berich.presentation.dashboard.fortune.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xinrui.berich.R
import com.xinrui.berich.presentation.dashboard.fortune.model.FundModel
import javax.inject.Inject


class FundListAdapter @Inject constructor(val context: Context) : RecyclerView.Adapter<FundListAdapter.TwoLineItemViewHolder>() {

    var funds: List<FundModel> = emptyList()

    open class SingleLineItemViewHolder(val icon: ImageView?, val text: TextView?, val view: View): RecyclerView.ViewHolder(view)

    class TwoLineItemViewHolder(icon: ImageView?, text: TextView?, view: View) :
        SingleLineItemViewHolder(icon, text, view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TwoLineItemViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        return TwoLineItemViewHolder(
            null,
            null,
            layoutInflater.inflate(R.layout.rv_fund_txt, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return funds.size
    }

    override fun onBindViewHolder(holder: TwoLineItemViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.fund_list_item_name).setText(funds.get(position).name)
        holder.view.findViewById<TextView>(R.id.fund_list_item_secondary_code).setText(funds.get(position).code)
        holder.view.findViewById<TextView>(R.id.fund_list_item_current_value).setText(funds.get(position).value)
        //holder.view.findViewById<TextView>(R.id.fund_value).setText(funds.get(position).value)
        //holder.view.setText(fundList.get(position).name)
    }
}