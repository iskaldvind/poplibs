package io.iskaldvind.poplibs.presentation.converter

import android.content.Intent
import android.content.Intent.ACTION_GET_CONTENT
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import io.iskaldvind.poplibs.R.layout.fragment_converter
import by.kirich1409.viewbindingdelegate.viewBinding
import io.iskaldvind.poplibs.arguments
import io.iskaldvind.poplibs.data.converter.ConverterFactory
import io.iskaldvind.poplibs.databinding.FragmentConverterBinding
import io.iskaldvind.poplibs.scheduler.SchedulersFactory
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ConverterFragment: MvpAppCompatFragment(fragment_converter), ConverterView {

    companion object {

        fun newInstance() : Fragment = ConverterFragment().arguments()
    }

    private var uri: Uri = Uri.EMPTY

    private val presenter: ConverterPresenter by moxyPresenter {
        ConverterPresenter(
            SchedulersFactory.create(),
            ConverterFactory.create(requireContext())
        )
    }

    private val binding: FragmentConverterBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            if (uri != Uri.EMPTY) presenter.load(uri)
        }
        binding.picker.setOnClickListener {
            pickImage()
        }
    }

    override fun showSuccess() {
        hideAll()
        uri = Uri.EMPTY
        showPath()
        Toast.makeText( requireContext(), "Success", Toast.LENGTH_SHORT).show()
    }

    override fun showButton() {
        binding.button.visibility = View.VISIBLE
        binding.progress.visibility = View.GONE
    }

    override fun showLoading() {
        binding.button.visibility = View.GONE
        binding.progress.visibility = View.VISIBLE
    }

    override fun showPath() {
        binding.path.setText(uri.lastPathSegment)
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.localizedMessage, Toast.LENGTH_SHORT).show()
    }

    override fun hideAll() {
        uri = Uri.EMPTY
        showPath()
        binding.button.visibility = View.GONE
        binding.progress.visibility = View.GONE
    }

    private fun pickImage() {
        val intent = Intent(ACTION_GET_CONTENT)
        intent.type = "image/*"
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.data.let {
           uri = if (it != null) {
               showButton()
               it
           } else {
               hideAll()
               Uri.EMPTY
           }
            showPath()
        }
    }
}