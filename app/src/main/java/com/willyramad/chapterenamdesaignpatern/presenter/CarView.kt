package com.willyramad.chapterenamdesaignpatern.presenter

import com.willyramad.chapterenamdesaignpatern.model.GetAllResponCar
import com.willyramad.chapterenamdesaignpatern.model.GetAllResponCarItem

interface CarView {

    fun onSuccess(pesan : String, car : List<GetAllResponCarItem>)
    fun onError(pesan : String)
}