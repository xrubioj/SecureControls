package com.xrubio.securecontrols

import android.view.MotionEvent
import android.view.View

typealias SecurityListener = (view: View, event: MotionEvent) -> Boolean

interface FilterTouchEventInterface {

    var windowObscuredTouchEvent: SecurityListener?

    fun onFilterTouchEventForSecurityHandler(view: View, event: MotionEvent): FilterTouchEventResult

}
