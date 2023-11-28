import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.OutputStream
import java.net.InetAddress
import java.net.ServerSocket
import java.net.Socket
import java.nio.charset.Charset
import com.google.gson.Gson
import data.Database


fun main(args: Array<String>) {


    val server: ServerSocket = ServerSocket(5000, 2, InetAddress.getLocalHost())
    println("================== "+server.inetAddress.toString()+" ==================")

    while (true) {
        Thread { handleClient(server.accept()) }.start()
    }


}


fun handleClient(socket: Socket) {

    println("Se ha conectado: ${socket.inetAddress}")

    val charset: Charset = Charset.forName("UTF-8")
    val operationLen = CharArray(1)
    val outputStream: OutputStream = socket.getOutputStream()
    val inputStream: BufferedReader = BufferedReader(InputStreamReader(socket.getInputStream(), charset))

    try {
        while (true) {
            val data: Int = inputStream.read(operationLen)
            if (data == -1) {
                break
            }

            val stringData: String = String(operationLen, 0, data)

            when (stringData.toInt()) {
                0 -> break
                1 -> {
                    val choosedElement: Quest = Database.getRandomElement() ?: Quest(-1,"error","error")
                    val elementJson: String = Gson().toJson(choosedElement)
                    val outputBytes: ByteArray = Utils.outputPreparer(elementJson)
                    outputStream.write(outputBytes)
                    outputStream.flush()
                }
                else -> continue
            }
        }
    } catch (e: Exception) {
        println("An error occurred: ${e.message}")
    } finally {
        outputStream.close()
        inputStream.close()
        println("Se ha desconectado: ${socket.inetAddress}")
        socket.close()

    }
}

