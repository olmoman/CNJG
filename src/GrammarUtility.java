// Assigned to Chris

// Warning! 
// The Stanford Named Entity Recognizer (NER) requires a heap size of at least 300MB
// The default heap size of JRE is only 256MB! 
// Please perform the following steps to increase the heap size in Eclipse
// http://edwards.sdsu.edu/labsite/index.php/daniel/236-increasing-heap-size-in-eclipse


import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.*;
//import edu.stanford.nlp.io.IOUtils;
import edu.stanford.nlp.ling.CoreLabel;
//import edu.stanford.nlp.ling.CoreAnnotations.AnswerAnnotation;



import java.util.List;
import java.io.IOException;



public class GrammarUtility 
{
	private String serializedClassifier;
	
	public GrammarUtility()
	{
		// Use classifier CoNLL 2003 (trained for 4 classes: PERSON, ORGANIZATION, LOCATION, and MISC)
		serializedClassifier = "lib/english.conll.4class.distsim.crf.ser.gz";
		
	}
	
	public List<String> getNamedEntityList(String sentence)
	{
		List<String> ls = new ArrayList<String>();
		

		// Instance classifier
		AbstractSequenceClassifier<CoreLabel> classifier = CRFClassifier.getClassifierNoExceptions(serializedClassifier);
		 
		// System.out.println(classifier.classifyToString(sentence));
		
		// Classify passed sentence
		String classifiedString = classifier.classifyToString(sentence);
		
		// Split classified sentence by words
		String[] tokens = classifiedString.split(" ");
		
		// Iterate all words and add only classified words to list
		for (int i=0;i<tokens.length;i++)
		{
			String[] classifiedToken = tokens[i].split("/");
			
			//System.out.println(classifiedToken[1]);
			
			if (!(classifiedToken[1].equals("O")))
			{
				ls.add(classifiedToken[0]);
				//System.out.println("Found " + classifiedToken[0] + " as " + classifiedToken[1]);
			}
		}
		
		return ls;
	}
	
}
