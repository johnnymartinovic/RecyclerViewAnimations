package com.johnnym.recyclerviewanimations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.johnnym.recyclerviewanimations.diffutildemo.DiffUtilDemoActivity
import com.johnnym.recyclerviewanimations.notifydemo.NotifyDemoActivity
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        insertItemDemoButton.setOnClickListener {
            startActivity(NotifyDemoActivity.createIntent(
                    this,
                    NotifyDemoActivity.NotifyDemoInitData(
                            NotifyDemoActivity.NotifyDemoInitData.DemoType.INSERT_ITEM)))
        }

        moveItemDemoButton.setOnClickListener {
            startActivity(NotifyDemoActivity.createIntent(
                    this,
                    NotifyDemoActivity.NotifyDemoInitData(
                            NotifyDemoActivity.NotifyDemoInitData.DemoType.MOVE_ITEM)))
        }

        removeItemRangeDemoButton.setOnClickListener {
            startActivity(NotifyDemoActivity.createIntent(
                    this,
                    NotifyDemoActivity.NotifyDemoInitData(
                            NotifyDemoActivity.NotifyDemoInitData.DemoType.REMOVE_ITEM_RANGE)))
        }

        changeItemDemoButton.setOnClickListener {
            startActivity(NotifyDemoActivity.createIntent(
                    this,
                    NotifyDemoActivity.NotifyDemoInitData(
                            NotifyDemoActivity.NotifyDemoInitData.DemoType.CHANGE_ITEM)))
        }

        changeItemWithPayloadDemoButton.setOnClickListener {
            startActivity(NotifyDemoActivity.createIntent(
                    this,
                    NotifyDemoActivity.NotifyDemoInitData(
                            NotifyDemoActivity.NotifyDemoInitData.DemoType.CHANGE_ITEM_WITH_PAYLOAD)))
        }

        diffUtilDemoButton.setOnClickListener {
            startActivity(DiffUtilDemoActivity.createIntent(this))
        }
    }
}
