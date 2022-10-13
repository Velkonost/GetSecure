package com.get.secure.vm

import com.get.secure.util.RxViewModel
import com.get.secure.util.SingleLiveEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import javax.inject.Inject


class BaseViewModel @Inject constructor(

) : RxViewModel() {

    val errorEvent = SingleLiveEvent<String>()
    val successEvent = SingleLiveEvent<String>()

    init {
        if (EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this)
    }

    override fun onCleared() {
        if (EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().unregister(this)

        super.onCleared()
    }

    @Subscribe
    fun onEvent(event: Any) {
        //Dummy event subscription to prevent exceptions
    }
}