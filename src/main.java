
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Test!");
		
		SentenceGrabber sentenceGrabber = new SentenceGrabber();
		String firstSentence = sentenceGrabber.getSentence();
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
