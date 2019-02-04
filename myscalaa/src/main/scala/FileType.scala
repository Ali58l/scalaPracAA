import scala.collection.mutable.ListBuffer

trait FileType {

	def validHeader(header:String): Boolean 		  
	def ckeckFileHasHeader():Boolean
	def readFileBody(fileLines:List[String]):ListBuffer[RecLine]
}
