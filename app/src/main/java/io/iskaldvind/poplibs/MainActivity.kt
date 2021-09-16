package io.iskaldvind.poplibs

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import io.iskaldvind.poplibs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get(): ActivityMainBinding = _binding!!
    private val presenter = MainPresenter(this)

    private val btnCounter1: Button by lazy { binding.btnCounter1 }
    private val btnCounter2: Button by lazy { binding.btnCounter2 }
    private val btnCounter3: Button by lazy { binding.btnCounter3 }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnCounter1.setOnClickListener { presenter.counterClickFirst() }
        btnCounter2.setOnClickListener { presenter.counterClickSecond() }
        btnCounter3.setOnClickListener { presenter.counterClickThird() }
    }

    override fun setFirstCounter(text: String) {
        btnCounter1.text = text
    }

    override fun setSecondCounter(text: String) {
        btnCounter2.text = text
    }

    override fun setThirdCounter(text: String) {
        btnCounter3.text = text
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}