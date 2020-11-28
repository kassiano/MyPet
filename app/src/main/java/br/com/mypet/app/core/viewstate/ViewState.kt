package br.com.mypet.app.core.viewstate

sealed class ViewState {
    class Loading :ViewState()
    class Success(val message:String):ViewState()
    class Error(val message:String ):ViewState()
}