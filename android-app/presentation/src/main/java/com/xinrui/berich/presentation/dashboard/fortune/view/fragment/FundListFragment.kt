package com.xinrui.berich.presentation.dashboard.fortune.view.fragment

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xinrui.berich.R
import com.xinrui.berich.presentation.dashboard.fortune.model.FundModel
import com.xinrui.berich.presentation.dashboard.fortune.presenter.FundListPresenter
import com.xinrui.berich.presentation.dashboard.fortune.view.FundListView
import com.xinrui.berich.presentation.dashboard.fortune.view.adapter.FundListAdapter
import com.xinrui.berich.presentation.BerichApplication
import com.xinrui.berich.presentation.dashboard.fortune.view.adapter.FundListAdapter.OnItemClickListener
import java.text.FieldPosition
import javax.inject.Inject


class FundListFragment: Fragment(), FundListView {

    companion object {
        fun newInstance() = FundListFragment()
    }

    @Inject lateinit var fundListPresenter: FundListPresenter
    @Inject lateinit var fundListAdapter: FundListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity!!.application as BerichApplication).appComponent
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fundListPresenter.fundListView = this;
        val viewManager = LinearLayoutManager(this.context)
        val fragementView = inflater.inflate(R.layout.fragment_fund_list, container, false)
        val recycleViewHeader = inflater.inflate(R.layout.rv_fund_list_header, container, false)
        fundListAdapter.header = recycleViewHeader
        val onItemClickListener: OnItemClickListener = object : OnItemClickListener {
            override fun onFundItemClicked(funModel: FundModel) {
                    fundListPresenter.onFundClicked(funModel)
            }
        }
        fundListAdapter.onItemClickListener = onItemClickListener
        val recyclerView = fragementView!!.findViewById<RecyclerView>(R.id.my_recycler_view)
        recyclerView.apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)
            // use a linear layout manager
            layoutManager = viewManager
            // specify an viewAdapter (see also next example)
            adapter = fundListAdapter
        }
        val dividerItemDecoration =
            DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration);
        return fragementView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null)
            fundListPresenter.loadFundList()

    }

    override fun renderFundList(funds: List<FundModel>) {
        fundListAdapter.funds = funds
    }

    override fun viewFunndDetail(fund: FundModel) {
        Log.d("debug", fund.toString())
        activity!!.supportFragmentManager.beginTransaction()
            .replace(R.id.dashboard_fragement_container, FundDetail.newInstance(fund))
            .commitNow()
    }
}
