package com.pokemon.jv.ui.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pokemon.jv.R
import com.pokemon.jv.databinding.FragmentConfigurationBinding
import com.pokemon.jv.internal.dagger.component.DaggerConfigurationFragmentComponent
import com.pokemon.jv.internal.dagger.component.DaggerListPokemonFragmentComponent
import com.pokemon.jv.ui.activities.LoginActivity
import com.pokemon.jv.ui.base.BaseFragment
import com.pokemon.jv.ui.presenter.ConfigurationPresenter
import com.pokemon.jv.ui.views.ConfigurationView
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ConfigurationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ConfigurationFragment : BaseFragment(), ConfigurationView {
    @Inject
    lateinit var presenter: ConfigurationPresenter
    lateinit var binding: FragmentConfigurationBinding

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        buildInjection()
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private fun buildInjection() {
        DaggerConfigurationFragmentComponent.builder()
            .applicationComponent(getAndroidApplication().getApplicationComponent())
            .build().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentConfigurationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initUI()
    }

    override fun onResume() {
        super.onResume()
        presenter.resume()
    }

    override fun onPause() {
        super.onPause()
        presenter.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ConfigurationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ConfigurationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun goLogin() {
        val intent = Intent(context(), LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        activity?.finish()
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun initUI() {
        presenter.setView(this)
        binding.btnLogout.setOnClickListener {
            presenter.logout()
        }
    }

    override fun context(): Context {
        return requireContext()
    }

    override fun showErrorMessage(message: String) {

    }

    override fun showErrorNetworkMessage(message: String) {

    }
}