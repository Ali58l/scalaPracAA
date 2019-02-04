import scala.collection.mutable.ListBuffer

case class RecLine(id:String,name:String,country:String,
	code:String,tel:String,action:String) extends Rec

trait Rec extends FileType{
	val hasHeader = true
	var body = null
	val fields: List[String] = List("id","name","country","code","tel","action")
	val headerIndexs =  scala.collection.mutable.Map[String, Int]()

	def validHeader(header:String): Boolean = {
		val headerFields = header.split('|')
		fields.foreach{ f => 
			if (fields.indexOf(f) >= 0 ){
				headerIndexs += (f -> fields.indexOf(f))
			} else {
				return false
			}
		}
		return true
	} 		  

	def ckeckFileHasHeader():Boolean = {
		return hasHeader
	}

	 def readFileBody(fileLines:List[String]):ListBuffer[RecLine] = {
	 	val filebody = if (ckeckFileHasHeader) fileLines.drop(1) else fileLines
	 	var bodydata = new ListBuffer[RecLine]()
	 	filebody.foreach{ f => 
	 	val bodyFields = f.split('|')  	
		val recLine =   RecLine(
	     id = bodyFields(headerIndexs("id")),
	     name = bodyFields(headerIndexs("name")),
	     country = bodyFields(headerIndexs("country")),
	     code = bodyFields(headerIndexs("code")),
	     tel = bodyFields(headerIndexs("tel")),
	     action = bodyFields(headerIndexs("action"))
         )
         bodydata +=recLine
		}

		println(bodydata)
		return bodydata
	 }
 }