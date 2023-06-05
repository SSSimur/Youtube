// HistoryFragment.kt
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.models.ExpenseData
import com.example.preferences.SharedPreferences
import com.example.retrofit.ApiInterface
import com.example.retrofit.RetrofitHelper
import com.example.youtube.databinding.FragmentHistoryBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HistoryFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentHistoryBinding
    private lateinit var expenseRv: RecyclerView
    private lateinit var apiInterface: ApiInterface
    private lateinit var prefs: SharedPreferences

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        expenseRv = binding.recyclerView
        prefs = SharedPreferences(requireContext())

        apiInterface = RetrofitHelper.getInstance().create(ApiInterface::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            Log.d("ayush", "userId: ${prefs.getId()}, email: ${prefs.getEmail()}")
            val response = apiInterface.getExpensesOfUser(prefs.getToken(), prefs.getId())
            Log.d("ayush", "expenses: ${response.body()}")
            if (response.isSuccessful) {
                withContext(Dispatchers.Main) {
                    val expenseList: List<ExpenseData> = response.body()!!
                    binding.progressBar.visibility = View.GONE
                    expenseRv.adapter = ExpenseRvAdapter(expenseList)
                    expenseRv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HistoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
