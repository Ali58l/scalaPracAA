import Util._


object Main {
   def main(args: Array[String]) {
   	  println("#" * 100)
      println("Verifying the args....")
      
      val filename = "myfile.txt"
      val fileLines = readFile(filename)
      val fileRe1 = new FileContainer with Rec
      val status = fileRe1.doFileStuff(fileLines)

      println("the args verified...., STATUS ::: " + status)
   }
}
