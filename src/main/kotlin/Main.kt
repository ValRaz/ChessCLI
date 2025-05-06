//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println(
        """
            *ChessCLI*
            -Please enter moves in column, row format(a-h, 1-8) ie: e2,e4
            -Type quit to exit the game.
        """.trimIndent()
    )

    //Sets starting positions
    val board = Board().apply {
        initBoard()
        drawBoard()
    }

    //Move history tracking and validation setup
    val history = mutableListOf<Move>()
    var isWhiteTurn = true
    val squarePattern = Regex("^[a-h][1-8]$")

    //Main game loop
    loop@ while (true) {
        val (playerNum, colorName) = if (isWhiteTurn) {
            "player_1" to "White"
        } else "player_2" to "Black"
        print("$playerNum ($colorName)'s move: ")

        val line = readLine()?.trim()?.lowercase() ?: continue
        if (line == "quit") {
            println("Leaving the Game, thank you for playing!")
            break@loop
        }

        //Move input validation
        val turnTokens = line.split(",")
        if (turnTokens.size != 2) {
            println("Invalid move format. Please try a valid format. (e.g. e2, e4")
            continue@loop
        }

        val fromSquare = turnTokens[0].trim()
        val toSquare = turnTokens[1].trim()

        if (!squarePattern.matches(fromSquare) ||
            !squarePattern.matches(toSquare)
            ) {
            println("Invalid move. Please use letters a-h and numbers 1-8")
            continue@loop
        }

        //Build and use valid move
        val move = Move(
            from = Position(fromSquare[0], fromSquare[1].digitToInt()),
            to = Position(toSquare[0], toSquare[1].digitToInt())
        )
        if (!board.applyMove(move)) {
            println("Illegal move. Please try again")
            continue@loop
        }

        //Records successful move, changes turn
        history += move
        isWhiteTurn = !isWhiteTurn
        board.drawBoard()
    }

    if (history.isNotEmpty()) {
        println("\n moves played this game:")
        history.forEachIndexed {idx, mv ->
            println("${idx +1}. ${mv.from} → ${mv.to}")
        }
    }
}