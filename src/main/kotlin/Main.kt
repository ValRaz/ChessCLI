//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val board = Board()

    //Initializes the board with pieces in starting positions
    board.initBoard()

    //Prints starting board state
    println("Starting Board:")
    println(board)
    println()

    //Test move for white pawn from e2 to e4
    val from = Position('e', 2)
    val to = Position('e', 4)
    println("Moving pawn from $from to $to")
    if (board.makeMove(from, to)) {
        println("Successful move\n")
    } else {
        println("Invalid move")
    }

    //Displays updated board
    println("Board updated:")
    println(board)
}