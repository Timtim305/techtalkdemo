import edu.stanford.nlp.coref.CorefCoreAnnotations.CorefChainAnnotation;
import edu.stanford.nlp.coref.data.CorefChain;
import edu.stanford.nlp.coref.data.CorefChain.CorefMention;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;

import java.util.*;

public class Test {
	
	public static void main(String []args) {
		Properties p = new Properties();
		p.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref, sentiment");
		
		StanfordCoreNLP pipeline = new StanfordCoreNLP(p);
		
		String text = "I love classes! He's the best man alive if everyone else in the world was dead. Everyone you meet is better than you.";
		
		Annotation doc = new Annotation(text);
		pipeline.annotate(doc);
		
		System.out.println(doc);

		List<CoreMap> sentences = doc.get(SentencesAnnotation.class);
		for (CoreMap sentence : sentences) {
			 for (CoreLabel token: sentence.get(TokensAnnotation.class)) {
				System.out.println("This is the word: " + token.get(TextAnnotation.class));
				System.out.println("This is the POS tag: " + token.get(PartOfSpeechAnnotation.class));
				System.out.println("This is the NER label: " + token.get(NamedEntityTagAnnotation.class));
				System.out.println("");
			}
			 System.out.println(sentence.get(SentimentCoreAnnotations.SentimentClass.class));
		}
		
		Map<Integer, CorefChain> graph = 
				  doc.get(CorefChainAnnotation.class);
	
		for(Integer chain : graph.keySet()) {
			CorefChain c = graph.get(chain);
			
			List<CorefMention> list = c.getMentionsInTextualOrder();
			
			for (CorefMention m : list) {
				System.out.println(m.mentionSpan);
			}
			
			System.out.println();
		}
		
	}
	
	
}
