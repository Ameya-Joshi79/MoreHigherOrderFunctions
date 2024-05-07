import grocerypackage.Grocery2

fun main(args:Array<String>){

    val groceries2 = listOf(
        Grocery2("Tomatoes", "Vegetable", "1lb", 3.0, 3),
        Grocery2("Mushrooms", "Vegetable", "1lb", 4.0, 1),
        Grocery2("Bagels", "Bakery", "Pack", 1.5, 2),
        Grocery2("Olive Oil", "Pantry", "Bottle", 6.0, 1),
        Grocery2("Ice Cream", "Frozen", "Pack", 3.0, 2)
    )

    /*
       forEach function example. For Each takes a lambda as a Parameter. However, neither the function nor the lambda return anything.
     */

    /*
      Loop through each item in the collection and print it's name
     */
    groceries2.forEach {
        println(it.name)
    }

    /*
       Chaining calls to use forEach
     */

    /*
      Imagine that you want to print the name of each item in groceries whose
      unitPrice is greater than 3.0.
     */

    println("print the name of each item in groceries whose\n" +
            "      unitPrice is greater than 3.0.")

    groceries2.filter {
        it.unitPrice > 3.0
    }.forEach {
        println(it.name)
    }

    /*
       Updating variables defined outside the forEach() from within the lambda passed to the forEach. Referred to
       as the lambda's closure
     */
    var itemNames:String = ""

    groceries2.forEach{

        itemNames += "${it.name} - "
    }

    println(itemNames)


    /*
       groupBy Examples
     */

    /*
       groupBy() Higher Order function returns a Map<K, List<T>>
     */
    val groupByCategory = groceries2.groupBy { it.category }

    println(groupByCategory)

    /*
        Chaining calls with groupBy()
     */

    groceries2.groupBy {
        it.category
    }.forEach{ it:Map.Entry<String, List<Grocery2>> ->
        println(it.key)

        it.value.forEach{
            println("   ${it.name}")
        }

    }


/*
   Using the fold() higher order function
 */
    val ints = listOf<Int>(1, 2, 3, 4 ,5)

    val sumOfInts = ints.fold(0){ runningSum, item ->
        runningSum + item
    }

    println(sumOfInts)

    /*
      Get the Product of the above list
     */

    val productOfInts = ints.fold(1){ productValue, item ->
        productValue * item
    }

    println(productOfInts)

    /*
      Concatenate name of each item in the groceries list
     */

    val name = groceries2.fold(""){ initialString:String, item:Grocery2 ->

        initialString + "${item.name} "

    }

    println(name)

    /*
      use fold to work out how much change you’d have left if you
were to buy all the items in a List<Grocery>.
     */

    val change = groceries2.fold(50.0){ change:Double, item:Grocery2 ->
        change - (item.quantity * item.unitPrice)
    }


    println(change)


}//main