//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val board = Board()

    //Creates and places white pawn at a2
    val whitePawn = Pawn(Position('a',2), Color.WHITE)
    board.placePiece(whitePawn, whitePawn.position)

    //Creates and places black rook at h8
    val blackRook = Rook(Position('h', 8), Color.BLACK)
    board.placePiece(blackRook, blackRook.position)

    //Prints board state
    println(board)

    //Shows possible moves per each piece
    println("Possible moves for white pawn: ${whitePawn.possibleMoves()}")
    println("Possible moves for black rook: ${blackRook.possibleMoves()}")
}