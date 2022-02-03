import Utils.emails
import Utils.firstNames
import Utils.getConnection
import Utils.gradYears
import Utils.lastNames
import java.sql.Connection
import java.sql.Statement
import kotlin.random.Random
import kotlin.system.exitProcess

object LoadData {

  @JvmStatic
  fun main(args: Array<String>) {
    try {
      Class.forName("org.postgresql.Driver")

      val conn: Connection = getConnection()

      conn.autoCommit = false

      println("Opened database")

      repeat(100) {
        val stmt: Statement = conn.createStatement()

        val first = firstNames.random()
        val last = lastNames.random()
        val email = "${first.first()}.$last-${Random.nextInt(100)}@${emails.random()}"
        val grad = gradYears.random()

        val sql =
          "INSERT INTO students (first_name, last_name, email, grad_year) VALUES ('$first', '$last', '$email', $grad);"
        stmt.executeUpdate(sql)
        println("Executed sql: $sql")

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

    println("Records created")
  }
}