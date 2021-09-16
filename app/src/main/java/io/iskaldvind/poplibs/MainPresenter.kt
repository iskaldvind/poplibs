package io.iskaldvind.poplibs

class MainPresenter(private val view: MainView) {

    private val model = CountersModel()

    fun counterClickFirst() = counterClickHandler(0)

    fun counterClickSecond() = counterClickHandler(1)

    fun counterClickThird() = counterClickHandler(2)

    private fun counterClickHandler(index: Int) {
        val nextValue = model.next(index = index).toString()
        when (index) {
            0 -> view.setFirstCounter(nextValue)
            1 -> view.setSecondCounter(nextValue)
            2 -> view.setThirdCounter(nextValue)
        }
    }
}