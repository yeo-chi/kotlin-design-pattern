package yeo.chi.design_pattern.factory_method

class FactoryMethod {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(createPiece("pcs"))
        }

        fun createPiece(notation: String): ChessPiece {
            val (type, file, rank) = notation.toCharArray()

            return when (type) {
                'q' -> Queen(file, rank)
                'p' -> Pawn(file, rank)
                else -> throw RuntimeException()
            }
        }
    }
}

interface ChessPiece {
    val file: Char
    val rank: Char
}

data class Pawn(
    override val file: Char,
    override val rank: Char,
) : ChessPiece

data class Queen(
    override val file: Char,
    override val rank: Char,
) : ChessPiece

class StaticFactoryMethod {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Server.runByPort(8080)
        }
    }
}

class Server private constructor(port: Long) {
    init {
        println("$port 포트에서 서버가 시작됐습니다.")
    }

    companion object {
        fun runByPort(port: Long) = Server(port = port)
    }
}

class AbstractFactoryMethod {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val portProperty = property("port: 8080")
            val environmentProperty = property("environment: product")
        }

        fun property(prop: String): Property {
            val (name, value) = prop.split(":")

            return when (name) {
                "port" -> PropertyImpl(name, value.trim().toInt())
                "environment" -> PropertyImpl(name, value.trim())
                else -> throw RuntimeException("알 수 없는 속성: $name")
            }
        }
    }
}

interface Property {
    val name: String
    val value: Any
}

interface ServerConfiguration {
    val properties: List<Property>
}

data class PropertyImpl(
    override val name: String,
    override val value: Any,
) : Property

data class ServerConfigurationImpl(
    override val properties: List<Property>,
) : ServerConfiguration
