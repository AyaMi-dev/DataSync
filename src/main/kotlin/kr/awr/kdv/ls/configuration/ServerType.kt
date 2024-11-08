package kr.awr.kdv.ls.configuration

enum class ServerType {
    ITEM,
    BLOCK,
    ENTITY,
    PLAYER,
    BLOCK_ENTITY,
    MOB
}

class ServerTypeInfo {

    companion object {
        // 익명 static 객체 정의
        val instance: SendData = object : SendData {
            override fun sendData(serverType: ServerType, data: Any) {
                println("Sending $data to server of type $serverType")
            }

            override fun sendData(serverType: ServerType) {
                println("Sending data to server of type $serverType")
            }

            override fun sendData(data: Any) {
                println("Sending data: $data")
            }

            override fun sendData() {
                println("Sending default data")
            }

            override fun sendData(serverType: ServerType, data: Any, callback: () -> Unit) {
                println("Sending $data to server of type $serverType with callback")
                callback()
            }

            override fun sendData(serverType: ServerType, callback: () -> Unit) {
                println("Sending data to server of type $serverType with callback")
                callback()
            }

            override fun sendData(data: Any, callback: () -> Unit) {
                println("Sending data: $data with callback")
                callback()
            }

            override fun sendAllData(serverType: ServerType, data: Any) {
                println("Sending all data: $data to server of type $serverType")
            }
        }
    }
}

// 사용 예시
fun main() {
    ServerTypeInfo.instance.sendData(ServerType.ITEM, "Example Data") {
        println("Callback executed")
    }
}
