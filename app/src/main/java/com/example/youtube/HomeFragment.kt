package com.example.youtube

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.youtube.databinding.ActivityMainBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"





class   HomeFragment : Fragment() {
    private lateinit var binding: ActivityMainBinding
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

//        GlobalScope.launch(Dispatchers.IO) {
//            val response = try {
//                RetrofitIntance.api.login(email, password);
//
//            } catch (e: HttpException) {
//                Toast.makeText(applicationContext, "http error ${e.message}", Toast.LENGTH_LONG)
//                    .show()
//                return@launch
//            } catch (e: IOException) {
//                Toast.makeText(applicationContext, "app error ${e.message}", Toast.LENGTH_LONG)
//                    .show()
//                return@launch
//            }
//            System.out.println(response);
//
//            if (response.isSuccessful && response.body() != null) {
//                withContext(Dispatchers.Main) {
//                    Snackbar.make(
//                        binding.root,
//                        "code: ${response.code()}",
//                        Snackbar.LENGTH_INDEFINITE
//                    )
//                        .show()
//                    binding.apply {
//
//                    }
//                }
//            }

        }



        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?


        ): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_home, container, false)


        }


    }




