package com.xrubio.securecontrols

import android.view.MotionEvent
import android.view.View
import android.widget.Toast

/**
 * Common implementation of {@link FilterTouchEventInterface}. Used by different secure controls by delegation,
 * in order to group the common functionality and logic.
 */
class FilterTouchEvent : FilterTouchEventInterface {

    override var windowObscuredTouchEvent: SecurityListener? = null

    override fun onFilterTouchEventForSecurityHandler(view: View, event: MotionEvent): FilterTouchEventResult {
        if ((event.flags and MotionEvent.FLAG_WINDOW_IS_OBSCURED) == MotionEvent.FLAG_WINDOW_IS_OBSCURED) {
            if (windowObscuredTouchEvent == null) {
                val context = view.context
                val message = context.resources.getString(R.string.security_alert_message)
                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
            }
            return Handled(windowObscuredTouchEvent?.invoke(view, event) ?: false)
        }
        return NotHandled()
    }

}