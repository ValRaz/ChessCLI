data class Position (val file: Char, val rank: Int) {
    override fun toString(): String = "$file$rank"

    // convert file and rank to 0 based indices for array access
    fun fileIndex(): Int = file- 'a'
    fun rankIndex(): Int = rank-1
}