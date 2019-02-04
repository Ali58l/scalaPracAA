class FileContainer {
    self: FileType =>

    def doFileStuff(fileLines:List[String]):String = {
    	var isHeadValid = true
    	if ( ckeckFileHasHeader() ) {
    		isHeadValid = validHeader(fileLines(0))
    	}
    	if (isHeadValid ){
    		val bodydata = readFileBody(fileLines)
         	return "Done!"
    	} else {
    		return "Head not valid!!"
    	}
    }
}