object Utils {

    val questsMock = listOf<Quest>(
        Quest(
            1,
            "HTTP",
            "Protocolo de transferencia de hipertexto utilizado para la transmisión de datos en la World Wide Web."
        ),
        Quest(
            2,
            "FTP",
            "Protocolo de transferencia de archivos que permite la transferencia de archivos entre sistemas en una red."
        ),
        Quest(
            3,
            "TCP",
            "Protocolo de control de transmisión que proporciona una comunicación confiable y ordenada entre aplicaciones en una red."
        ),
        Quest(4, "IP", "Protocolo de Internet que proporciona la dirección lógica de los dispositivos en una red."),
        Quest(
            5,
            "DNS",
            "Sistema de nombres de dominio que traduce nombres de dominio legibles por humanos a direcciones IP."
        ),
        Quest(6, "SMTP", "Protocolo de transferencia de correo simple utilizado para enviar correo electrónico."),
        Quest(7, "POP", "Protocolo de oficina de correos utilizado para recibir correo electrónico."),
        Quest(
            8,
            "IMAP",
            "Protocolo de acceso a mensajes de Internet utilizado para recibir correo electrónico de servidores."
        ),
        Quest(
            9,
            "HTTPS",
            "Protocolo de transferencia de hipertexto seguro utilizado para comunicaciones en línea seguras."
        ),
        Quest(10, "LAN", "Red de área local que conecta dispositivos en un área geográfica limitada."),
        Quest(11, "WAN", "Red de área amplia que conecta dispositivos en áreas geográficas extensas."),
        Quest(12, "VPN", "Red privada virtual que crea un entorno seguro sobre una red pública, como internet."),
        Quest(13, "MAC", "Dirección de control de acceso al medio que identifica de manera única una interfaz de red."),
        Quest(
            14,
            "ARP",
            "Protocolo de resolución de direcciones que asocia direcciones IP a direcciones MAC en una red local."
        ),
        Quest(
            15,
            "DHCP",
            "Protocolo de configuración dinámica de host que asigna direcciones IP y otros parámetros de red automáticamente."
        ),
        Quest(16, "QUIC", "Protocolo rápido y seguro para la comunicación en internet."),
        Quest(17, "P2P", "Red entre pares que permite compartir recursos y servicios directamente entre los usuarios.")
    )

    fun outputPreparer(data: String): ByteArray {
        val messageLen = if (data.length.toString().length > 8) "9".padEnd(8, '9')
        else data.length.toString().padStart(8, '0')

        return (messageLen + data).encodeToByteArray()
    }

}

