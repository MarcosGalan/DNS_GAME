package data.api

import com.google.gson.Gson
import domain.Quest
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.InetAddress
import java.net.Socket

object QuestsApiImpl : QuestsApi {

    val socket = Socket(InetAddress.getLocalHost().hostAddress, 5000)
    val outputStream = socket.getOutputStream()
    val inputStream = BufferedReader(InputStreamReader(socket.inputStream))
    val dataFlag = CharArray(8)


    override fun getRandomQuest(): Quest {

        val req:ByteArray = "1".encodeToByteArray()
        outputStream.write(req)
        outputStream.flush()

        try {

            val length = inputStream.read(dataFlag)
            val nextDataBytes:CharArray = CharArray(String(dataFlag,0,length).toInt())

            val dataBytes = inputStream.read(nextDataBytes)
            val data = String(nextDataBytes,0,dataBytes)

            return Gson().fromJson(data,Quest::class.java)

        }catch (e:Exception){
            println(e.message)
        }

        return Quest(-1,"error","error")

    }

}