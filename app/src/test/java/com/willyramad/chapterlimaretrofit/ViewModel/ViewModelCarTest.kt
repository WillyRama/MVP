package com.willyramad.chapterlimaretrofit.ViewModel

import com.willyramad.chapterlimaretrofit.model.GetAllCarResponseItem
import com.willyramad.chapterlimaretrofit.service.ApiService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import retrofit2.Call

class ViewModelCarTest {

    lateinit var servis: ApiService

    @Before
    fun setUp() {
        servis = mockk()
    }

    @Test
    fun getCarTest(): Unit = runBlocking {
//        mocking GIVEN
        val respAllCar = mockk<Call<List<GetAllCarResponseItem>>>()

        every {
            runBlocking {
                servis.getAllcar()
            }
        } returns respAllCar

//        System Under Test (WHEN)
        val result = servis.getAllcar()

        verify {
            runBlocking { servis.getAllcar() }
        }
        Assert.assertEquals(result, respAllCar)

    }
    @Test
    fun GetCarTestnorunblock(){
        val respAllCar = mockk<Call<List<GetAllCarResponseItem>>>()

    every {
        runBlocking {
            servis.getAllcar()
        }
    } returns respAllCar

    //        System Under Test (WHEN)
    val result = servis.getAllcar()

    verify {
        runBlocking { servis.getAllcar() }
    }
    Assert.assertEquals(result, respAllCar)

    }
}