import Utils.getConnection
import Utils.gradYears
import io.github.serpro69.kfaker.Faker
import java.sql.Connection
import java.sql.Statement
import kotlin.system.exitProcess

object LoadData {

  @JvmStatic
  fun main(args: Array<String>) {
    val count = 100
    try {
      Class.forName("org.postgresql.Driver")

      val conn: Connection = getConnection()

      conn.autoCommit = false

      println("Opened database")

      val faker = Faker()

      repeat(count) {
        val stmt: Statement = conn.createStatement()
        val first = faker.name.firstName()
        val last = faker.name.lastName()
        val domain = faker.internet.domain()
        val email = "$first.${last.replace("'", "")}@$domain"
        val grad = gradYears.random()
        val sql =
          "INSERT INTO students (first_name, last_name, email, grad_year) VALUES ('$first', '${
            last.replace(
              "'",
              "''"
            )
          }', '$email', $grad)"
        println("Executed sql: $sql")
        stmt.executeUpdate(sql)

        // Close statement
        stmt.close()
      }

      // Commit transaction
      conn.commit()

      // Close connection
      conn.close()

    } catch (e: Exception) {
      System.err.println("${e.javaClass.name}: ${e.message}")
      exitProcess(0)
    }

    println("$count records inserted")
  }
}