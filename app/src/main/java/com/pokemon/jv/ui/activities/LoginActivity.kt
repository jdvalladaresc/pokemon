package com.pokemon.jv.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.pokemon.jv.databinding.ActivityLoginBinding
import com.pokemon.jv.internal.dagger.component.DaggerLoginActivityComponent
import com.pokemon.jv.ui.base.BaseActivity
import com.pokemon.jv.ui.presenter.LoginPresenter
import com.pokemon.jv.ui.views.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginView {
    lateinit var binding: ActivityLoginBinding

    @Inject
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        buildInjection()
        initUI()
    }

    private fun buildInjection() {
        DaggerLoginActivityComponent.builder().applicationComponent(getApplicationComponent())
            .build()
            .inject(this)
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

    override fun goHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun getUsername(): String {
        return etUsername.text.toString()
    }

    override fun getPassword(): String {
        return etPassword.text.toString()
    }

    override fun initUI() {
        presenter.setView(this)
        presenter.validateScreen()
        binding.btnLogin.setOnClickListener {
            presenter.validate()
        }
    }

    override fun context(): Context {
        return this
    }

    override fun showErrorMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showErrorNetworkMessage(message: String) {

    }
}