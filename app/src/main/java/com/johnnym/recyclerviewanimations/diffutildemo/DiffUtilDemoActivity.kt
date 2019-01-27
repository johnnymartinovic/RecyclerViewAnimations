package com.johnnym.recyclerviewanimations.diffutildemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.johnnym.recyclerviewanimations.R
import com.johnnym.recyclerviewanimations.travelino.TravelinoMockFactory
import com.johnnym.recyclerviewanimations.travelino.TravelinoViewModelMapper
import com.johnnym.recyclerviewanimations.common.MarginItemDecoration
import com.johnnym.recyclerviewanimations.common.bindView
import com.johnnym.recyclerviewanimations.travelino.TravelinoItem

class DiffUtilDemoActivity : AppCompatActivity() {

    companion object {

        fun createIntent(context: Context): Intent =
                Intent(context, DiffUtilDemoActivity::class.java)
    }

    private val toolbar: Toolbar by bindView(R.id.toolbar)
    private val itemsView: RecyclerView by bindView(R.id.itemsRecyclerView)
    private val refreshButton: View by bindView(R.id.refreshButton)

    private val itemsAdapter = DiffUtilDemoAdapter()
    private val itemsMapper = TravelinoViewModelMapper()

    private lateinit var itemsLayoutManager: LinearLayoutManager

    private var nextInstanceNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.diff_util_demo_activity)

        toolbar.setNavigationOnClickListener { onBackPressed() }

        itemsLayoutManager = LinearLayoutManager(this)

        with(itemsView) {
            setHasFixedSize(true)
            adapter = itemsAdapter
            layoutManager = itemsLayoutManager
            addItemDecoration(MarginItemDecoration(
                    resources.getDimensionPixelSize(R.dimen.general_item_decoration_margin)))
        }

        refreshButton.setOnClickListener {
            changeAdapterData()
        }

        changeAdapterData()
    }

    private fun changeAdapterData() {
        itemsAdapter.setItems(createTravelinoItemList(nextInstanceNumber).map { itemsMapper.map(it) })
        itemsLayoutManager.scrollToPosition(0)
        nextInstanceNumber = (nextInstanceNumber + 1) % 2
    }

    private fun createTravelinoItemList(instanceNumber: Int): List<TravelinoItem> {
        val list = when (instanceNumber) {
            0 -> listOf(
                    TravelinoMockFactory.Paris.copy(),
                    TravelinoMockFactory.NewYork.copy(),
                    TravelinoMockFactory.Zagreb.copy(infoMessage = "Hurry up, Zagreb is great!"),
                    TravelinoMockFactory.London.copy(),
                    TravelinoMockFactory.Sidney.copy(),
                    TravelinoMockFactory.Berlin.copy())
            1 -> listOf(
                    TravelinoMockFactory.Zagreb.copy(infoMessage = "Now Zagreb is even cheaper!", price = 42),
                    TravelinoMockFactory.Paris.copy(),
                    TravelinoMockFactory.Havana.copy(),
                    TravelinoMockFactory.NewYork.copy(infoMessage = "New York is pretty good!"),
                    TravelinoMockFactory.Sidney.copy(price = 120),
                    TravelinoMockFactory.Berlin.copy())
            else -> throw IllegalStateException("$instanceNumber should be between 0 (included) and 1 (included)")
        }

        return list
    }
}
