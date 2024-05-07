package grocerypackage

data class Grocery(val name:String, val category:String, val unit:String, val unitPrice:Double, val quantity:Int ):Comparable<Grocery> {

    override fun compareTo(other: Grocery): Int {
        return if (this.unitPrice > other.unitPrice){
            1
        }else if (this.unitPrice == other.unitPrice){
            0
        }else{
            -1
        }
    }


}