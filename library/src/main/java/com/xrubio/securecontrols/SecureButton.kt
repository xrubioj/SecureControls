package com.xrubio.securecontrols

import android.content.Context
import android.support.v7.widget.AppCompatButton
import android.util.AttributeSet
import android.view.MotionEvent

class SecureButton
@JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        AppCompatButton(context, attrs, defStyleAttr),
        FilterTouchEventInterface by FilterTouchEvent() {

    override fun onFilterTouchEventForSecurity(event: MotionEvent): Boolean {
        val result = this.onFilterTouchEventForSecurityHandler(this, event)
        return when (result) {
            is Handled    -> result.result
            is NotHandled -> super.onFilterTouchEventForSecurity(event)
        }
    }

}
