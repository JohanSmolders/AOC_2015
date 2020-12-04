package be.krikkrok.fifteen.pojo

class CircuitCommand(val command: String) {

    lateinit var wire: String
    lateinit var operation: CircuitOperation
    var value: Int? = null

    var first: String? = null
    var second: String? = null

    val numberRegex = Regex("\\d?")

    init {
        when {
            !command.contains("NOT") && !command.contains("AND") && !command.contains("OR") && !command.contains("LSHIFT") && !command.contains(
                "RSHIFT"
            ) -> {
                performAssign(command)
            }
            command.contains("NOT") -> {
                performNot(command)
            }
            command.contains("AND") -> {
                performAnd(command)
            }
            command.contains("OR") -> {
                performOr(command)
            }
            command.contains("LSHIFT") -> {
                performLShift(command)
            }
            command.contains("RSHIFT") -> {
                performRShift(command)
            }
        }
    }

    private fun performRShift(name: String) {
        this.first = name.substring(0, name.indexOf(" "))
        this.value = name.substring(name.indexOf("RSHIFT ") + 7, name.indexOf(" ->")).toInt()
        this.wire = name.substring(name.indexOf("-> ") + 3)
        this.operation = CircuitOperation.RSHIFT
    }

    private fun performLShift(name: String) {
        this.first = name.substring(0, name.indexOf(" "))
        this.value = name.substring(name.indexOf("LSHIFT ") + 7, name.indexOf(" ->")).toInt()
        this.wire = name.substring(name.indexOf("-> ") + 3)
        this.operation = CircuitOperation.LSHIFT
    }

    private fun performOr(name: String) {

        val first = name.substring(0, name.indexOf(" "))
        val second = name.substring(name.indexOf("OR ") + 3, name.indexOf(" ->"))

        if(first.matches(numberRegex) || second.matches(numberRegex)){
            this.first = if (first.matches(numberRegex)) second else first
            this.value = if (first.matches(numberRegex)) first.toInt() else second.toInt()
            this.operation = CircuitOperation.ORVALUE
        }else{
            this.first = first
            this.second = second
            this.operation = CircuitOperation.OR
        }

        this.wire = name.substring(name.indexOf("-> ") + 3)
    }

    private fun performAnd(name: String) {
        val first = name.substring(0, name.indexOf(" "))
        val second = name.substring(name.indexOf("AND ") + 4, name.indexOf(" ->"))

        if(first.matches(numberRegex) || second.matches(numberRegex)){
            this.first = if (first.matches(numberRegex)) second else first
            this.value = if (first.matches(numberRegex)) first.toInt() else second.toInt()
            this.operation = CircuitOperation.ANDVALUE
        }else{
            this.first = first
            this.second = second
            this.operation = CircuitOperation.AND
        }

        this.wire = name.substring(name.indexOf("-> ") + 3)
    }

    private fun performNot(name: String) {
        this.first = name.substring(name.indexOf("NOT ") + 4, name.indexOf(" ->"))
        this.wire = name.substring(name.indexOf("-> ") + 3)
        this.operation = CircuitOperation.NOT
    }

    private fun performAssign(name: String) {
        try {
            this.value = name.substring(0, name.indexOf(" ")).toInt()
            this.wire = name.substring(name.indexOf("-> ") + 3)
            this.operation = CircuitOperation.ASSIGN
        }catch (e: Exception){
            this.first = name.substring(0, name.indexOf(" "))
            this.wire = name.substring(name.indexOf("-> ") + 3)
            this.operation = CircuitOperation.ASSIGNWIRE
        }
    }
}