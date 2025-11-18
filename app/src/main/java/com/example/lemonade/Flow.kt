package com.example.lemonade

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.lemonade.StepName

class Flow {
    private val steps: HashMap<StepName, Step> = hashMapOf(
        StepName.LemonTree to Step(
            R.drawable.lemon_tree,
            R.string.content_description_lemon_tree,
            StepName.LemonSqueeze,
            R.string.action_lemon_tree
        ),
        StepName.LemonSqueeze to StepSqueezeLemon(
            R.drawable.lemon_squeeze,
            R.string.content_description_lemon,
            StepName.FullGlass,
            R.string.action_squeeze
        ),
        StepName.FullGlass to Step(
            R.drawable.lemon_drink,
            R.string.content_description_glass,
            StepName.EmptyGlass,
            R.string.action_drink_lemonade
        ),
        StepName.EmptyGlass to Step(
            R.drawable.lemon_restart,
            R.string.content_description_empty_glass,
            StepName.LemonTree,
            R.string.action_restart
        )
    )

    var currentStepName: StepName by mutableStateOf(StepName.LemonTree)
        private set

    fun getCurrentStep(): Step {
        return steps[currentStepName]
            ?: error("No step found for $currentStepName")
    }

    fun makeStep() {
        currentStepName = getCurrentStep().nextStep
    }

    fun onClick() {
        getCurrentStep().onClick { makeStep() }
    }
}
