package zipunzip;


public class ZipUnzipAlgorithm {

	public static String doCompress(String text) {
		
		if(text == null) {
			return "";
		}
		if(text.isEmpty() || text.length() < 1) {
			return text;
		}
		int i = 0;
		StringBuilder stringBuilder = new StringBuilder();
		while(i <= text.length() - 1) {
			int count = 1;
		    int j = i + 1;
			while(j < text.length() && text.charAt(i) == text.charAt(j)) {
		    	count++;
		    	j++;
		    }
			stringBuilder.append(text.charAt(i));
		    if(count > 1 ) {
		    	stringBuilder.append(count);
		    }
		    i = j;
		}
		if(stringBuilder.toString().length() > text.length()) {
			return text;
		}
		return stringBuilder.toString();
	}
	
	public static String doDecompression(String text) {
		
		if(text == null) {
			return "";
		}
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i < text.length() - 1; i++) {
			
			Character currentChar = text.charAt(i);
			Character nextChar = text.charAt(i + 1);
			if(!Character.isDigit(nextChar)) {
				stringBuilder.append(currentChar);
			}
			else {
				int count = 1;
				
				 {
					count = Integer.parseInt(nextChar.toString());
					while(count > 0) {
						stringBuilder.append(currentChar);
						count--;
					}
					i++;
				}
			}
		}
		Character lastChar = text.charAt(text.length()-1);
		if(!Character.isDigit(lastChar)) {
			stringBuilder.append(lastChar);
		}
		
		return stringBuilder.toString();
	}
	
}
