package yeo.chi.design_pattern.single_ton

class SingleTon {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //object 는 싱글톤으로 여러번 생성해도 항상 같은 객체를 얻는다.
            val a = NotMovies
            val b = NotMovies

            require(a == b) { "a b 가 서로 달라요!" }

            Movies.printMovies()
        }
    }
}

object NotMovies

fun List<String>.printMovies() {
    this.map(::println)
}

// object 는 인터페이스를 상속 받을 수 있다.
object Movies : List<String> {
    private val list: List<String> = listOf()

    override val size = list.size
    override fun contains(element: String) = list.contains(element)
    override fun containsAll(elements: Collection<String>) = list.containsAll(elements)
    override fun get(index: Int) = list[index]
    override fun indexOf(element: String) = list.indexOf(element)
    override fun isEmpty() = list.isEmpty()
    override fun iterator() = list.iterator()
    override fun lastIndexOf(element: String) = list.lastIndexOf(element)
    override fun listIterator() = list.listIterator()
    override fun listIterator(index: Int) = list.listIterator(index)
    override fun subList(fromIndex: Int, toIndex: Int) = list.subList(fromIndex, toIndex)
}
