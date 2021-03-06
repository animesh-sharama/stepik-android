package org.stepic.droid.ui.activities

import org.stepic.droid.base.FragmentActivityBase

abstract class BackToExitActivityBase : FragmentActivityBase() {
    override fun finish() {
        super.finish()
        overridePendingTransition(org.stepic.droid.R.anim.no_transition, org.stepic.droid.R.anim.push_down)
    }
}
