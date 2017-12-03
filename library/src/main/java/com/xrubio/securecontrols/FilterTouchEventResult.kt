package com.xrubio.securecontrols

sealed class FilterTouchEventResult

data class Handled(val result: Boolean) : FilterTouchEventResult()
class NotHandled : FilterTouchEventResult()
