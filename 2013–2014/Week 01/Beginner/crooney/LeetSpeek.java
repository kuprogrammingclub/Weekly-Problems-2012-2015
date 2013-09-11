

public class LeetSpeek {


    public static void main(String[] args) {
    	final String weirdComparison = "This String_HasNotChanged";
    	
	//Holds combined input
	String extendedArg = "";
	//Holds output    	
	String encodedString = "";
    	
	//characters defined in the charactersToReplace array are replaced with their counterparts in the 
	//charactersReplaceWith array.
	char[] charactersToReplace   =   {'l','L','e','E','c','C','h','H','t','T','o','O','b','B','a','A','s','S','d',  'D','w','W','k','K',  'v','V'};
    	String[] charactersReplaceWith = {"1","1","3","3","(","(","#","#","7","7","0","0","8","8","4","4","$","$","[)","[)","₩","₩","|<","|<","\\/","\\/"};
    	

	//combines the args into a single string
    	for(String arg : args) {
    		extendedArg = extendedArg + " " + arg;
    	}
	//it usually ended up having a space at the beginning, so I'll trim it.
    	extendedArg = extendedArg.trim();

	//make the input into an array of characters in order to loop through it and replace stuff
    	char[] leetString = extendedArg.toCharArray();

    	
    	for(int j=0; j<leetString.length; j++) {
    		String characters = "This String_HasNotChanged";
    		for(int i=0; i<charactersToReplace.length; i++) {
    			if(leetString[j] == charactersToReplace[i]) {
    				characters = charactersReplaceWith[i];
    			}
    		}
    		if(characters.equals(weirdComparison)) {
    			encodedString = encodedString + leetString[j];
    		} else {
    			encodedString = encodedString + characters;
    		}
    	}
    	System.out.println(encodedString);
	}
}
