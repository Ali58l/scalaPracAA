import scala.io.Source

object Util {

     def readFile(filename:String): List[String] ={
     	val lines = Source.fromFile(filename).getLines().toList
     	return lines
   	}

   	def removeDollars(line: String): String = line.replaceAll("\\$", "")
}