2 sentence joke generator
-----------------------------

Goal: Creation of a joke comprising 2 sentences in the following structure.
	The first sentence contains noun "Chuck Norris", verb and object.
	The second sentence contains noun, verb and object related to the topic of the first sentence.

Algorithm:
	<Sentence Grabber fetches and returns sentence from open website (e.g. WIKI, news page, etc.)>
	<Grammar Utility Module extracts list of nouns from fetched sentence>
	<Topic Recognition Module returns list of associated topics related to passed noun sorted by frequency in descending order>
	<Joke Generator Module fetches sentence based on passed topic.>
		
		
Pseudo Code:

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
	
		

	
	