package com.johnnym.recyclerviewanimations.notifydemo

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.johnnym.recyclerviewanimations.R
import com.johnnym.recyclerviewanimations.common.MarginItemDecoration
import com.johnnym.recyclerviewanimations.common.bindView
import com.johnnym.recyclerviewanimations.travelino.TravelinoMockFactory
import com.johnnym.recyclerviewanimations.travelino.TravelinoItem
import com.johnnym.recyclerviewanimations.travelino.TravelinoViewModelMapper
import kotlinx.android.parcel.Parcelize

class NotifyDemoActivity : AppCompatActivity() {

    companion object {

        private const val EXTRA_NOTIFY_DEMO_INIT_DATA = "EXTRA_NOTIFY_DEMO_INIT_DATA"

        fun createIntent(context: Context, initData: NotifyDemoInitData): Intent {
            val intent = Intent(context, NotifyDemoActivity::class.java)
            intent.putExtra(EXTRA_NOTIFY_DEMO_INIT_DATA, initData)
            return intent
        }
    }

    private val toolbar: Toolbar by bindView(R.id.toolbar)
    private val itemsView: RecyclerView by bindView(R.id.itemsRecyclerView)
    private val playButton: View by bindView(R.id.playButton)

    private val notifyDemoAdapter = NotifyDemoAdapter()
    private val mapper = TravelinoViewModelMapper()

    private lateinit var demoType: NotifyDemoInitData.DemoType

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notify_demo_activity)

        val initData: NotifyDemoInitData = intent.getParcelableExtra(EXTRA_NOTIFY_DEMO_INIT_DATA)
        demoType = initData.demoType

        val toolbarTitleResource = when (demoType) {
            NotifyDemoInitData.DemoType.INSERT_ITEM -> R.string.notify_demo_insert_item_label
            NotifyDemoInitData.DemoType.MOVE_ITEM -> R.string.notify_demo_move_item_label
            NotifyDemoInitData.DemoType.REMOVE_ITEM_RANGE -> R.string.notify_demo_remove_item_range_label
            NotifyDemoInitData.DemoType.CHANGE_ITEM -> R.string.notify_demo_change_item_label
            NotifyDemoInitData.DemoType.CHANGE_ITEM_WITH_PAYLOAD -> R.string.notify_demo_change_item_with_payload_label
        }

        with(toolbar) {
            setTitle(toolbarTitleResource)
            setNavigationOnClickListener { onBackPressed() }
        }

        with(itemsView) {
            setHasFixedSize(true)
            adapter = notifyDemoAdapter
            layoutManager = LinearLayoutManager(this@NotifyDemoActivity)
            addItemDecoration(MarginItemDecoration(
                    resources.getDimensionPixelSize(R.dimen.general_item_decoration_margin)))
        }

        notifyDemoAdapter.setItems(items.map { mapper.map(it) })

        playButton.setOnClickListener {
            playButton.setOnClickListener(null)
            playButton.animate()
                    .scaleX(0f)
                    .scaleY(0f)
                    .rotation(360f)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator?) {
                            playButton.visibility = View.GONE
                        }
                    })

            runAnimations()
        }
    }

    private fun runAnimations() {
        when (demoType) {
            NotifyDemoInitData.DemoType.INSERT_ITEM -> {
                val newItem = TravelinoItem(
                        "id_08",
                        "Hawaii",
                        120,
                        150,
                        TravelinoMockFactory.createUnsplashImageUrl("prSogOoFmkw"),
                        "")
                notifyDemoAdapter.insertItem(mapper.map(newItem), 2)
            }
            NotifyDemoInitData.DemoType.MOVE_ITEM -> {
                notifyDemoAdapter.moveItem(3, 1)
            }
            NotifyDemoInitData.DemoType.REMOVE_ITEM_RANGE -> {
                notifyDemoAdapter.removeItemRange(1, 2)
            }
            NotifyDemoInitData.DemoType.CHANGE_ITEM -> {
                notifyDemoAdapter.changeItem(1, "Eiffel tower is here!")
            }
            NotifyDemoInitData.DemoType.CHANGE_ITEM_WITH_PAYLOAD -> {
                notifyDemoAdapter.changeItemWithPayload(1, "Eiffel tower is here!")
            }
        }
    }

    private val items = listOf(
            TravelinoMockFactory.Zagreb.copy(),
            TravelinoMockFactory.Paris.copy(infoMessage = "Paris is in France."),
            TravelinoMockFactory.NewYork.copy(),
            TravelinoMockFactory.London.copy(),
            TravelinoMockFactory.Sidney.copy(infoMessage = "Sidney is in Australia."),
            TravelinoMockFactory.Berlin.copy(),
            TravelinoMockFactory.Rome.copy(infoMessage = "Rome is in Italy."),
            TravelinoMockFactory.Havana.copy())

    @Parcelize
    data class NotifyDemoInitData(
            val demoType: DemoType
    ) : Parcelable {

        enum class DemoType {
            INSERT_ITEM,
            MOVE_ITEM,
            REMOVE_ITEM_RANGE,
            CHANGE_ITEM,
            CHANGE_ITEM_WITH_PAYLOAD
        }
    }
}
