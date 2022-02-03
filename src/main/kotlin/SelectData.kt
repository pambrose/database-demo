import Utils.getConnection
import java.sql.Connection
import java.sql.ResultSet
import kotlin.system.exitProcess


object SelectData {
  @JvmStatic
  fun main(args: Array<String>) {
    try {
      Class.forName("org.postgresql.Driver")
      val conn: Connection = getConnection()

      conn.autoCommit = false

      println("Opened database successfully")

      val stmt = conn.createStatement()

      val rs: ResultSet = stmt.executeQuery("SELECT * FROM students")

      while (rs.next()) {
        val id = rs.getInt("id")
        val first = rs.getString("first_name")
        val last = rs.getString("last_name")
        val email = rs.getString("email")
        val gradYear = rs.getInt("grad_year")

        println("ID = $id")
        println("First = $first")
        println("Last = $last")
        println("Email = $email")
        println("Graduation Year = $gradYear")
        println()
      }

      // Close ResultSet
      rs.close()

      // Close statement
      stmt.close()

      // Close connection
      conn.close()
    } catch (e: Exception) {
      System.err.println(e.javaClass.name + ": " + e.message)
      exitProcess(0)
    }

    println("Select completed")
  }
}