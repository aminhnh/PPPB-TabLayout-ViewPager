package com.example.pppbtablayoutviewpager

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.pppbtablayoutviewpager.databinding.FragmentRegisterBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!


    companion object {
        val accounts = mutableMapOf("admin" to "admin")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val view = binding.root

        with(binding){
            btnRegister.setOnClickListener{
                if (validate()){
                    val username = inputUsername.text.toString()
                    val password = inputPassword.text.toString()
                    accounts[username] = password

                    MainActivity.viewPager2.currentItem = 1
                }
            }
            txtLoginLink.setOnClickListener{
                MainActivity.viewPager2.currentItem = 1
            }

            val textView = txtToc
            val text = "By checking the box you agree to our Terms and Conditions."

            val spannable = SpannableStringBuilder(text)

            val startIndexTerms = text.indexOf("Terms")
            val endIndexTerms = startIndexTerms + "Terms".length

            val startIndexConditions = text.indexOf("Conditions")
            val endIndexConditions = startIndexConditions + "Conditions".length

            spannable.setSpan(
                ForegroundColorSpan(Color.BLUE),
                startIndexTerms,
                endIndexTerms,
                Spannable.SPAN_INCLUSIVE_INCLUSIVE
            )

            spannable.setSpan(
                ForegroundColorSpan(Color.BLUE),
                startIndexConditions,
                endIndexConditions,
                Spannable.SPAN_INCLUSIVE_INCLUSIVE
            )

            textView.text = spannable

        }

        return view
    }


    private fun validate() : Boolean{
        with(binding){
            if ( inputUsername.text.toString().isEmpty() ){
                editTextUsername.error = "Username is required!"
                return false
            }
            if ( inputEmail.text.toString().isEmpty() ){
                editTextEmail.error = "Email is required!"
                return false
            }
            if ( inputPhone.text.toString().isEmpty() ) {
                editTextPhone.error = "Phone is required!"
                return false
            }
            if ( inputPassword.text.toString().isEmpty() ) {
                inputPassword.error = "Password is required!"
                return false
            }
            if ( inputPassword.text.toString().length < 5 ) {
                inputPassword.error = "Password must be at least 5 characters long"
                return false
            }
            if (!checkbox.isChecked) {
                Toast.makeText(this@RegisterFragment.requireActivity(), "Please agree to the Terms and Conditions", Toast.LENGTH_SHORT).show()
                return false
            }

            return true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}