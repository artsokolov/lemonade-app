package com.example.lemonade

class StepSqueezeLemon(
    imageResourceName: Int,
    contentDescriptionName: Int,
    nextStep: StepName,
    actionTextResourceId: Int
) : Step(imageResourceName, contentDescriptionName, nextStep, actionTextResourceId) {
    var neededClicks = (2..4).random()

    override fun onClick(onSuccess: () -> Unit) {
        neededClicks--

        if (neededClicks == 0) {
            neededClicks = (2..4).random()
            onSuccess()
        }
    }
}
