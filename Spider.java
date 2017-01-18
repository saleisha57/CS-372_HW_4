/**
* This program will display the links that are available on the webpage provided in the program. It will display which sites it has visit
*ed.
*/

import java.io.*;
import java.net.URL;
import java.util.regex.*;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Spider
{
    static Map<String, Boolean> m = new HashMap<String, Boolean>();
    static ArrayList<String> str = new ArrayList<String>();
    
    public static void main(String[] args)
    {
	try {
	    String web = "http://www.whitworth.edu/cms/";
            URL url = new URL(web);
            BufferedReader rdr = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            int i=100;
            while ((line = rdr.readLine()) != null && i > 0) {
                i--;
	
	    }//while

	    while (line != null) 
		{
		    Pattern website = Pattern.compile("<a\\s*?href=\"(http:.*?)\"");
		    Matcher matcher = website.matcher(line);
		    if (matcher.find())
			m.put(matcher.group(1), false);
		    
		    String a;
		    
		    for(Map.Entry<String, Boolean> en: m.entrySet())
			{
			    if(en.getValue() == false)
				{
				    a = en.getKey();
				    str.add(a);				    
				    m.put(a, true);				    
				}//if
			    System.out.println(en.getKey());
			}
		    line = rdr.readLine();
		}//while
        }//try
        catch (Exception ex) {
            System.out.printf("Oops: %s", ex.getMessage());
        }//catch
	
    }
    
    

}
