package com.xinrui.berich.presentation.dashboard.fortune.view.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.xinrui.berich.R
import com.xinrui.berich.presentation.dashboard.fortune.model.FundModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val INPUT_FUND = "inputFund"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [FundDetail.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [FundDetail.newInstance] factory method to
 * create an instance of this fragment.
 */
class FundDetail : Fragment() {
    companion object {
        fun newInstance(fund: FundModel) =
            FundDetail().apply { arguments = Bundle().apply { putParcelable(INPUT_FUND, fund) } }
    }

    private lateinit var fund: FundModel
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            fund = it.getParcelable(INPUT_FUND)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fund_detail, container, false)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

}
