package io.iskaldvind.poplibs

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import io.iskaldvind.poplibs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get(): ActivityMainBinding = _binding!!
    val presenter = MainPresenter(this)

    private val btn_counter1: Button by lazy { binding.btnCounter1 }
    private val btn_counter2: Button by lazy { binding.btnCounter2 }
    private val btn_counter3: Button by lazy { binding.btnCounter3 }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listener = View.OnClickListener {
            presenter.counterClick(it.id)
        }

        btn_counter1.setOnClickListener(listener)
        btn_counter2.setOnClickListener(listener)
        btn_counter3.setOnClickListener(listener)
    }


    //Подсказка к ПЗ: поделить на 3 отдельные функции и избавиться от index
    override fun setButtonText(index: Int, text: String) {
        when(index){
            0 -> btn_counter1.text = text
            1 -> btn_counter2.text = text
            2 -> btn_counter3.text = text
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}