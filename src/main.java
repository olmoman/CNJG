import java.util.List;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.print("maxMemory: ");
		System.out.print(java.lang.Runtime.getRuntime().maxMemory()); 
		System.out.println(" (make sure this value is greater than 256MB!)");
		
		SentenceGrabber sentenceGrabber = new SentenceGrabber();
		String firstSentence = sentenceGrabber.getSentence();
		System.out.println(firstSentence);

		GrammarUtility grammarUtil = new GrammarUtility();
		List<String> EntityList = grammarUtil.getNamedEntityList(firstSentence);
		
		// Replace first entity with "Chuck Norris"
		firstSentence = grammarUtil.replaceNoun(firstSentence, EntityList.get(0));
		System.out.println(firstSentence);
		
		/*
		 * 
		 * ALGORITHM IN PSEUDO CODE
		 * 
		 * 
		UberChuckNorrisJoke = "";

		// Get first sentence from the web
		firstSentence = SentenceGrabber.getSentence();

		// Get all nouns from sentence (only the first returned noun will be used for further processing)
		nounList = GrammarUtility.getNounList(firstSentence);

		// Use first noun returned to determine topic list
		topicList = TopicRecognition.getTopics(nounList[0]);    

		// Replace first noun with "Chuck Norris" [Passing a string lateral instead of a variable is intended as this generator shall ONLY create Chuck Norris jokes!]
		firstSentence = GrammarUtility.replaceNoun(firstSentence, 0, "Chuck Norris");

		// Get second sentence based on topic
		secondSentence = JokeGenerator.getStupidJoke(topicList[0]);

		// Create another awesome Chuck Norris joke
		UberChuckNorrisJoke = firstSentence + secondSentence;
		
		*/
		
		
	}

}
