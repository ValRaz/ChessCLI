abstract class Piece( var position: Position, val color: Color) {
    //Returns a list of legal (stub) moves for the piece
    abstract fun possibleMoves(): List<Position>

    //uppercase single character for White, lowercase for Black
    abstract override fun toString(): String
}