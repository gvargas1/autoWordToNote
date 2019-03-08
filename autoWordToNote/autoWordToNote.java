import java.io.*; 

public class autoWordToNote
{ 
  public static void main(String[] args)throws Exception 
  { 
    // We need to provide file path as the parameter: 
    // double backquote is to avoid compiler interpret words 
    // like \test as \t (ie. as a escape sequence) 
    File file = new File("C:\\Users\\georg\\Downloads\\agile.txt"); 

    BufferedReader br = new BufferedReader(new FileReader(file)); 

    PrintWriter writer = new PrintWriter("modAgile.txt");

    String st; 
    String modLine = "";
    String anw = "";
    int i = 1;
    while ((st = br.readLine()) != null) {
        if (st.contains(i + ":")) {
            if (i != 1) {
                modLine = "}, \ncorrectAnswer: \"" + anw + "\"},{";
                writer.println(modLine);
                System.out.println(modLine);
            }
            i++;
            modLine = "question: \"" + st.concat("\", \nanswers: {");
            writer.println(modLine);
            System.out.println(modLine);
        } else {
            if (st.contains("a:") || st.contains("b:") || st.contains("c:") || st.contains("d:") || st.contains("e:")) {
                if (st.contains("*a:") || st.contains("*b:") || st.contains("*c:") || st.contains("*d:") || st.contains("*e:")) {
                    anw = String.valueOf(st.charAt(1));
                    modLine = st.substring(1, 3)+ "\"" + st.substring(4) + "\",";
                    writer.println(modLine);
                    System.out.println(modLine);
                } else {
                    modLine = st.substring(0, 2)+ "\"" + st.substring(3) + "\",";
                    writer.println(modLine);
                    System.out.println(modLine);
                }
            }
        }
    }
    br.close();
    writer.close();
  }
} 