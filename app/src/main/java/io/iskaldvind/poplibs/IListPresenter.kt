package io.iskaldvind.poplibs

interface IListPresenter<V: IItemView> {

    var itemClickListener: ((V) -> Unit)?

    fun bindView(view: V)

    fun getCount(): Int
}