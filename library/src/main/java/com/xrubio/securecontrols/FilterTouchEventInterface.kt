package com.xrubio.securecontrols

import android.view.MotionEvent
import android.view.View

/**
 * Listener invoked if a MotionEvent is detected to be targeted to an obscured window.
 *
 * @param view View that has received the event
 * @param event MotionEvent that needs to be processed
 * @return Whether the event should continue being processed (true) or not
 */
typealias SecurityListener = (view: View, event: MotionEvent) -> Boolean

/**
 * Common interface implemented by FilterTouchEvent, which can be used to delegate notification logic
 * common to all the controls by using "FilterTouchEventInterface by FilterTouchEvent()" in the
 * definition of the control.
 */
interface FilterTouchEventInterface {

    /**
     * Property that holds the listener that will be used to notify that a touch event in an obscured
     * control has been detected. The listener can return "false" to cancel the event or "true" to allow
     * it to be processed normally.
     */
    var windowObscuredTouchEvent: SecurityListener?

    /**
     * Handles the MotionEvent and verifies if it has been sent to an obscured window.
     *
     * @param view View that has received the event
     * @param event MotionEvent that needs to be processed
     * @return FilterTouchEventResult notifying if the event has been handled or not, and in the case
     *         it has been handled, whether the event should continue being processed (true) or not
     */
    fun onFilterTouchEventForSecurityHandler(view: View, event: MotionEvent): FilterTouchEventResult

}
