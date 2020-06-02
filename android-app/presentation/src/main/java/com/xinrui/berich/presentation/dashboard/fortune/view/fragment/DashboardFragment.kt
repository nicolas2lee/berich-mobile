package com.xinrui.berich.presentation.dashboard.fortune.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import javax.inject.Inject

class DashboardFragment: Fragment(), FundListView {


    companion object {
        fun newInstance() = DashboardFragment()
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
        val fragementView = inflater.inflate(R.layout.dashboard_fragment, container, false)
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


}
