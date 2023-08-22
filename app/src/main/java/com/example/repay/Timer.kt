//package com.example.repay
//
//import android.util.Log
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.Job
//import kotlinx.coroutines.SupervisorJob
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
//
//class Timer {
//    private val job= SupervisorJob()
//    private val scope = CoroutineScope(Dispatchers.Default + job)
//
//    private fun startCoroutineTimer(delayMillis: Long = 0, repeatMillis: Long = 0, action: () -> Unit) = scope.launch(Dispatchers.IO){
//        delay(delayMillis)
//        if (repeatMillis > 0){
//            while (true){
//                action()
//                delay(repeatMillis)
//            }
//        }else {
//            action()
//
//    }
//}
//    private val timer: Job = startCoroutineTimer(delayMillis = 0, repeatMillis = 20000) {
//        Log.d(TAG, "Background - tick")
//
//        scope.launch(Dispatchers.Main) {
//            Log.d(TAG, "Main thread - tick")
//
//        }
//    }