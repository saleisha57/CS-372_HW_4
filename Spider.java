import java.io.*;
import java.net.URL;
import java.util.regex.*;
import java.util.Map;
import java.util.HashMap;

public class Spider
{
    static Map<String, Boolean> m = new HashMap<String, Boolean>();
    
    public static void main(String[] args)
    {
	try {
	    String web = "http://www.whitworth.edu/cms/";
            URL url = new URL(web);
            BufferedReader rdr = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            int i=50;
            while ((line = rdr.readLine()) != null && i > 0) {
                i--;
                System.out.printf("%s\n", line);
            }

	    while (line != null) 
		{
		    Pattern website = Pattern.compile("<a\\s*?href=\"(http:.*?)\"");
		    Matcher matcher = website.matcher(line);
		    if (matcher.find())
			m.put(matcher.group(1), true);
		    for(Map.Entry<String, Boolean> en: m.entrySet())
			{
			    System.out.println("Key " + en.getKey());
			    System.out.println("Value " + en.getValue() + "\n");
			}
		    line = rdr.readLine();
		}
        }
        catch (Exception ex) {
            System.out.printf("Oops: %s", ex.getMessage());
        }
	


       




	
    }
    
    

}
