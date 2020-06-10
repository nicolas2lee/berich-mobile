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

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_NORMAL = 2
    }

    interface OnItemClickListener {
        fun onFundItemClicked(funModel: FundModel)
    }

    var funds: List<FundModel> = emptyList()
    lateinit var header: View

    lateinit var onItemClickListener: OnItemClickListener

    open class SingleLineItemViewHolder(val icon: ImageView?, val text: TextView?, val view: View): RecyclerView.ViewHolder(view)

    class TwoLineItemViewHolder(icon: ImageView?, text: TextView?, view: View) :
        SingleLineItemViewHolder(icon, text, view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TwoLineItemViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val layoutId = when(viewType){
            TYPE_HEADER -> R.layout.rv_fund_list_header
            TYPE_NORMAL-> R.layout.rv_fund_list
            else -> R.layout.rv_fund_list
        }
        return TwoLineItemViewHolder(
            null,
            null,
            layoutInflater.inflate(layoutId, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return funds.size+1
    }

    override fun onBindViewHolder(holder: TwoLineItemViewHolder, position: Int) {
        when(position){
            TYPE_HEADER-> setHeader(holder, position)
            else-> setNormalItem(holder, position)
        }

    }

    private fun setHeader(holder: TwoLineItemViewHolder, position: Int) {
        //do noting
    }

    private fun setNormalItem(holder: TwoLineItemViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.rv_fund_list_item_name).setText(funds.get(position-1).name)
        holder.view.findViewById<TextView>(R.id.rv_fund_list_item_secondary_code).setText(funds.get(position-1).code)
        holder.view.findViewById<TextView>(R.id.rv_fund_list_item_current_value).setText(funds.get(position-1).value)
        //holder.view.findViewById<TextView>(R.id.fund_value).setText(funds.get(position).value)
        //holder.view.setText(fundList.get(position).name)
        holder.itemView.setOnClickListener(View.OnClickListener { onItemClickListener.onFundItemClicked(funds.get(position-1)) })
        //holder.itemView.setOnClickListener(android.view.View.OnClickListener())
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) TYPE_HEADER else TYPE_NORMAL
    }
}