import java.sql.Connection
import java.sql.DriverManager

object Utils {

  val firstNames =
    listOf("Bill", "Ted", "Mark", "John", "Paul", "Steve", "James", "Robert", "Michael", "Mary", "Patricia", "Jennifer")

  val lastNames =
    listOf(
      "Smith",
      "Johnson",
      "Williams",
      "Jones",
      "Brown",
      "Davis",
      "Miller",
      "Wilson",
      "Moore",
      "Taylor",
      "Anderson",
      "Thomas"
    )

  val emails = listOf("gmail.com", "yahoo.com", "hotmail.com", "live.com", "me.com")

  val gradYears = listOf(2019, 2020, 2021, 2022, 2023, 2024, 2025, 2026, 2027, 2028, 2029, 2030)

  fun getConnection(): Connection {
    val hostname = System.getenv("DB_HOSTNAME") ?: "localhost"
    val dbname = System.getenv("DB_DATABASE")
    val user = System.getenv("DB_USERNAME")
    val password = System.getenv("DB_PASSWORD")
    return DriverManager.getConnection("jdbc:postgresql://$hostname:5432/$dbname", user, password)
  }

}