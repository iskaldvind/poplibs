package io.iskaldvind.poplibs

interface UserItemView: IItemView {
    fun setLogin(text: String)
    fun getLogin(): String
}