package data
import Quest
import java.lang.Error
import java.sql.*

object Database {

    private fun establishConnection(): Connection? {
        return try {
            val url = "jdbc:sqlite:C:\\Users\\swift\\IdeaProjects\\Server\\Quests"
            DriverManager.getConnection(url)
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
            null
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }

    private fun getIds(connection: Connection?): List<Int> {
        val idsList: MutableList<Int> = mutableListOf()
        connection?.let {
            try {
                val statement: Statement = it.createStatement()
                val query = "SELECT id FROM quests;"
                val resultSet: ResultSet = statement.executeQuery(query)

                while (resultSet.next()) {
                    val id = resultSet.getInt("id")
                    idsList.add(id)
                }

                resultSet.close()
                statement.close()
            } catch (e: SQLException) {

                println(e.message)
                println(e.errorCode)
                e.printStackTrace()
            }
        }
        return idsList
    }




    private fun getElement(id: Int, connection: Connection?): Quest?{
        connection?.let {
            try {
                val statement: Statement = it.createStatement()
                val query = "SELECT acronim,description FROM QUESTS WHERE id == $id LIMIT 1;"
                val resultSet: ResultSet = statement.executeQuery(query)

                while (resultSet.next()) {
                    val name = resultSet.getString("acronim")
                    val age = resultSet.getString("description")

                    return Quest(id,name,age)
                }

                resultSet.close()
                statement.close()
            } catch (e: SQLException) {
                e.printStackTrace()

            }
        }
        return null
    }


    fun getRandomElement(): Quest?{

        val connection = establishConnection()
        val id:Int = getIds(connection).random()

        return getElement(id,connection)
    }

}