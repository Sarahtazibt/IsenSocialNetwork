package fr.isen.tazibt.isensocialnetwork

class Post(
    val userId: String? = "",
    val carImg: String? = "",
    val carYear: String? = "",
    val carRetro: Boolean? = false,
    val carBrand: String? = "",
    val carColor: String? = "",
    val carModel: String? = "",
    val carHorsepower: String? = ""
) : java.io.Serializable