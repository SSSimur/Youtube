// ExpenseRvAdapter.kt
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.models.ExpenseData
import com.example.youtube.databinding.ExpenseItemBinding

class ExpenseRvAdapter(private val expenseList: List<ExpenseData>) : RecyclerView.Adapter<ExpenseRvAdapter.ExpenseViewHolder>() {

    class ExpenseViewHolder(binding: ExpenseItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val expenseTitle = binding.expenseTitle
        val expensePrice = binding.expensePrice
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val binding = ExpenseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExpenseViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return expenseList.size
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        holder.expenseTitle.text = expenseList[position].title
        holder.expensePrice.text = expenseList[position].amount.toString()
    }
}
