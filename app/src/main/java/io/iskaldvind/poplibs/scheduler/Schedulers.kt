package io.iskaldvind.poplibs.scheduler

import io.reactivex.Scheduler

interface Schedulers {

    fun background(): Scheduler
    fun main(): Scheduler
    fun io(): Scheduler
}