package String;

public interface String {
    public String strCopy(String S);

    public void clearString(String S);

    public boolean stringEmpty(String S);

    public int strLength(String S);

    public boolean strCompare(String T);

    public String concat(String S1,String S2);

    public String subString(String S,int pos,int length);

    public int index(String T,int pos);

    public void replace(String T,String V);

    public void strInsert(String s,String T,int pos);

    public void strDelete(String S,int pos,int length);
}
