package hr.ferit.luka.majstorovic.myapplication


data class ResponseData(
    val status: String,
    val code: Int,
    val total: Int,
    val data: ArrayList<Person>
)

data class Person(
    val image: String,
    val firstname: String,
    val lastname: String,
    val birthday: String,
    val address: Address
)

data class Address(
    val street: String
)
