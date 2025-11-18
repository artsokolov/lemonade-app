package com.example.lemonade

open class Step(
    val imageResourceId: Int,
    val contentResourceId: Int,
    val nextStep: StepName,
    val actionTextResourceId: Int
) {
    open fun onClick(onSuccess: () -> Unit) {
        onSuccess()
    }
}