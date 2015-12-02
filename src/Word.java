//package com.telstra.cms.interview;

public class Word {


	/**
	 * Please reverse the given sentence. 
	 * For an example, input of "fox jump over the fence" shall return "fence the over jump fox"
	 * Note: Any unnecessary white spaces will be eliminated. e.g.  " white  space  " shall return "space white"
	 * 
	 * @param sentence
	 * @return resersed sentence
	 */
	public String reverseSentence(String sentence) {
		
		if (null==sentence)
			return null;

		String reversed = "";
        if (sentence != null && !sentence.isEmpty()) {

	        String[] words = sentence.split(" ");
	        for (int i = words.length-1; i>=0; i--) {
	            reversed += words[i].trim() + " ";
	        }
        }
        
		return reversed;
		
	}

	public static void main(String[] args){
        
        String sentence = "fox jump over the fence";

        Word word = new Word();
        System.out.println(word.reverseSentence(sentence));

        System.out.println(Integer.MAX_VALUE);

    }
}
