import java.io.OutputStream;
import java.io.PrintStream;

import java.util.*;

import edu.stanford.nlp.coref.data.CorefChain;
import edu.stanford.nlp.coref.data.CorefChain.CorefMention;
import edu.stanford.nlp.simple.*;

public class SimpleDemo {

	public static void main(String[] args) {
			PrintStream err = System.err;
		System.setErr(new PrintStream(new OutputStream() {
		    public void write(int b) {
		    }
		}));
		
		
		String text = "He's the best man alive if everyone else is dead.";
		Document doc = new Document(text);
	
/*		Map<Integer, CorefChain> map = doc.coref();

		for(Integer i : map.keySet()) { 
			 List<CorefMention> l = map.get(i).getMentionsInTextualOrder();
			 
			 for(CorefMention c : l) {
				 System.out.print(c.mentionSpan + " ");
			 }
			 
			 System.out.println();
		 }*/
		
		
		
		for (Sentence s : doc.sentences()) {
			System.out.println(s);
			
			System.out.println(s.sentiment());
/*			List<String> words = s.words();

			int index = 0;*/

/*			for (String word : words) {
				System.out.print(word);
				System.out.println(" : " + s.posTag(index)); 
				System.out.println(" : " + s.nerTag(index)); 

				index++;
			
		}*/
			
/*			SentenceAlgorithms sa = s.algorithms();
			List<String> keyphrases = sa.keyphrases();
			
			for(String phrase: keyphrases) {
				System.out.println(phrase);
			}*/
			
			System.out.println();
		
		}
		
		

		
		System.setErr(err); 

	}
}
